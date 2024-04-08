package com.example.saasutil.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.example.saasutil.enums.DateFinalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/**
 *
 *
 * 类职责：<br/>
 *
 * <p>Title: DataConstant.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2020 工保科技 </p>
 * <p>Company: 工保科技 </p>
 *
 * <p>Author:Cmexico.Li</p>
 * <p>CreateTime:2020年11月3日上午9:40:55
 * <p>$LastChangedBy$</p>
 * <p>$LastChangedRevision$ </p>
 * <p>$LastChangedDate$ </p>
 * <p>$Id$ </p>
 */
@Slf4j
public class RSAUtil {

  /**
   * 加密
   *
   * @param orgData
   * @param privateKey
   * @return
   */
  public static String encrypt(String orgData, String privateKey) {
    System.out.println("加密字符串: " + orgData);
    RSA rsa = SecureUtil.rsa(privateKey, null);
    return new String(Base64.encode(rsa.encrypt(orgData, KeyType.PrivateKey)));
  }

  /**
   * 解密
   *
   * @param signData
   * @param publicKey
   * @return
   */
  public static String decrypt(String signData, String publicKey) {
    RSA rsa = SecureUtil.rsa(null, publicKey);
    return new String(rsa.decrypt(signData, KeyType.PublicKey));
  }

  /**
   * 验签
   *
   * @param orgData
   * @param signData
   * @param publicKey
   * @return
   */
  public static boolean check(String orgData, String signData, String publicKey) {
    RSA rsa = SecureUtil.rsa(null, publicKey);
    log.debug("参数内容为：" + orgData);
    String data = new String(rsa.decrypt(signData, KeyType.PublicKey));
    log.debug("解密内容为：" + data);
    if (StringUtils.hasText(data) && orgData.equals(data)) {
      return true;
    } else {
      return false;
    }
  }

  public static boolean checkByPublicSign(String orgData, String signData, String publicKey) {
    try {
      X509EncodedKeySpec x509EncodedKeySpec =
          new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(publicKey));
      KeyFactory keyFactory = KeyFactory.getInstance("RSA");
      PublicKey pubKey = keyFactory.generatePublic(x509EncodedKeySpec);
      // Signature signature = Signature.getInstance("MD5withRSA");//MD5withRSA
      Signature signature = Signature.getInstance("SHA256withRSA");// SHA256withRSA
      signature.initVerify(pubKey);
      signature.update(orgData.getBytes());
      return signature.verify(new BASE64Decoder().decodeBuffer(signData));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public static void main(String[] args) {
    String dateStr = "20230620110000";
    SimpleDateFormat sdf = new SimpleDateFormat(DateFinalFormat.YYYYMMddHHmmss.getCode());
    SimpleDateFormat sdf1 = new SimpleDateFormat(DateFinalFormat.YYYY_MM_dd_HH_mm_ss.getCode());
    String bidOpenTime = "";
    try {
      bidOpenTime = sdf1.format(sdf.parse(dateStr));
    }catch (Exception e) {
      e.printStackTrace();
      log.error("转换开标时间异常：{}", e.getMessage());
    }
    System.out.println(bidOpenTime);

  }

}
