package com.example.saasutil.util;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.example.saasutil.exception.Base64Exception;
import org.springframework.util.StringUtils;

/**
 * <国密> <br>
 *
 * @className: SmUtils
 * @package: com.cngongbao.nobasic.platform.util
 * @author: 刘川
 * @date: 2020/11/10 11:01
 */
public class SmUtils {

  public static final String appsecret = "&appsecret=ba22726d-14aa-11ea-9b2d-b888e3ebf769";

  /**
   * SM4解密
   *
   * @param base64Value base64字符值
   * @param base64Key   base64字符key
   * @return
   */
  public static String decryptionSM4Base64Param(String base64Value, String base64Key)
      throws Base64Exception {
    if (StringUtils.isEmpty(base64Key) || StringUtils.isEmpty(base64Value)) {
      return null;
    }
    // sm4
    byte[] key = null;
    try {
      key = Base64Util.decode(base64Key);
    } catch (Exception e) {
      throw new Base64Exception("key值base64解码失败");
    }
    byte[] value = null;
    try {
      value = Base64Util.decode(base64Value);
    } catch (Exception e) {
      throw new Base64Exception("base64解码失败");
    }
    try {
      SymmetricCrypto sm4 = SmUtil.sm4(key);
      return sm4.decryptStr(value);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * SM4解密
   *
   * @param key   key
   * @param value 字符
   * @return
   */
  public static String decryptionSM4(String key, String value) {
    if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
      return null;
    }
    try {
      // sm4
      SymmetricCrypto sm4 = SmUtil.sm4(key.getBytes());
      return sm4.decryptStr(value);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * SM4解密
   *
   * @param key   byte组key
   * @param value 字符
   * @return
   */
  public static String decryptionSM4(byte[] key, String value) {
    // sm4
    if (key == null || key.length < 1 || StringUtils.isEmpty(value)) {
      return null;
    }
    try {
      SymmetricCrypto sm4 = SmUtil.sm4(key);
      return sm4.decryptStr(value);
    } catch (Exception e) {
      return null;
    }
  }

  /**
   * sm3加密
   *
   * @param str 待加密字符
   * @return
   */
  public static String encryptionSM3(String str) {
    if (StringUtils.isEmpty(str)) {
      return null;
    }
    // sm3
    str += appsecret;
    try {
      return SmUtil.sm3(str);
    } catch (Exception e) {
      return null;
    }
  }
}