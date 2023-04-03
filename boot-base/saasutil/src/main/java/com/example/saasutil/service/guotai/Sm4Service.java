package com.example.saasutil.service.guotai;

import com.example.saasutil.util.SM4Util;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-03-31 14:14
 **/
public class Sm4Service {

  public static void main(String[] args) throws Exception {
    String key = "qhAej/h6yk3mVsUpM+khUQ==";
    String data = "1265010045762987XC";
    byte[] bKey = Base64.decodeBase64(key.getBytes());
    byte[] sm4 = SM4Util.encrypt_Ecb_Padding(bKey, data.getBytes());
    String encData = Base64.encodeBase64String(sm4);
    System.out.println(encData);

    byte[] tendereeUserCreditCode = SM4Util.decrypt_Ecb_Padding(Base64.decodeBase64(key.getBytes()), Base64.decodeBase64(encData));
    System.out.println(new String(tendereeUserCreditCode));
  }
}
