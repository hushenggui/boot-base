package com.example.saasutil.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
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
    String data = new String(rsa.decrypt(signData, KeyType.PublicKey));
    log.info("paymentNoticeReqPayNoticeRespDto orgData {} data {}", orgData, data);
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

}
