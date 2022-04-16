package com.example.saasutil.util;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

@Slf4j
public class GuotaiUtil {

  public static final String appkey = "finance_yg";
  public static final String demo = "SM4加解密测试DEMO";
  public static String sortparam = "appkey=finance_yg&applyno=TBaoHanNTYG2020022113301054383&applystatus=1&baohanfile=aHR0cHM6Ly9pZXBvbGljeS5zaW5vc2lnLmNvbS9kaWdpdGFsQmlsbF9kb3dubG9hZC9kb3dubG9hZFBvbGljeS5hY3Rpb24/ZmlsZT0yMDIwMDMwMjE0MDEtN2ZiMTdlM2UtMzA0ZC00YmJjLWI3NTUtNjM2MTNiOTA5OWZh&baohanno=1181822272020000030&baohanurl=http://testservicebus.sinosig.com/WebContent/QueryEpolicyForGBW.do?sign=MTE4MTgyMjI3MjAyMDAwMDAzMCxZR05UVEJMWQ==&cost=3200.00&generatetime=2020-03-03 19:11:03&instname=阳光财产保险股份有限公司&payeraccount=345678954678&payername=中国银行&rate=1.00&timestamp=2020-03-04 10:58:00";//排序使用treemap，key1=value1&key2=value2
  public static final String appsecret = "5df7053d-ddad-4fa6-a51e-3ff600fe8725";

  public static void main1(String[] args) throws Exception {

    // SM4加密原文
    byte[] bKey = SM4Util.generateKey();
    byte[] sm4 = SM4Util.encrypt_Ecb_Padding(bKey, demo.getBytes("UTF-8"));
    String encData = Base64.encodeBase64String(sm4);
    System.out.println("密文：" + encData);
    byte[] dd = SM4Util.decrypt_Ecb_Padding(bKey, Base64.decodeBase64(encData));
    String datainfo = new String(dd, "UTF-8");
    System.out.println("解密后的原文：" + datainfo);

    //sign签名
    sortparam += "&appsecret=" + appsecret;
    byte[] signHash = SM3Util.hash(sortparam.getBytes("UTF-8"));
    StringBuilder signature = new StringBuilder();
    for (byte b : signHash) {
      signature.append(byteToHexString(b));
    }
    String sign = signature.toString();
    System.out.println("签名String值为：" + sign);
  }

  public static String encode(Object req, String appkey, String appsecret) {
    try {
      Gson gson = new Gson();
      Map<String, Object> map;
      if(req instanceof String) {
        map = gson.fromJson((String) req, HashMap.class);
      } else if(req instanceof Map) {
        map = (Map) req;
      } else {
        map = BeanTool.toMap(req);
      }
      map.remove("sign");
      map.put("appkey", appkey);
      String signStr = StringFormatterUtils.mapCovertString(map, null, "&", "=");
      String param = signStr + "&appsecret=" + appsecret;
      byte[] signHash = SM3Util.hash(param.getBytes("UTF-8"));
      StringBuilder signature = new StringBuilder();
      for (byte b : signHash) {
        signature.append(byteToHexString(b));
      }
      return signature.toString();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  public static String encodeSensitive(Object req, String appkey, String appsecret) {
    try {
      Gson gson = new Gson();
      Map<String, Object> map;
      if(req instanceof String) {
        map = gson.fromJson((String) req, HashMap.class);
      } else if(req instanceof Map) {
        map = (Map) req;
      } else {
        map = BeanTool.toMap(req);
      }
      map.remove("sign");
      String reason = (String) map.get("Reason");
      map.remove("Reason");
      map.put("appkey", appkey);
      String signStr = StringFormatterUtils.mapCovertString(map, null, "&", "=");
      String param = "";
      if(StringUtils.isEmpty(reason)){
        param = signStr + "&appsecret=" + appsecret;
      }else{
        param = "Reason="+reason+"&"+signStr + "&appsecret=" + appsecret;
      }
      log.info("appsecret {} guotaiUtil>> {}", appsecret, param);
      byte[] signHash = SM3Util.hash(param.getBytes("UTF-8"));
      StringBuilder signature = new StringBuilder();
      for (byte b : signHash) {
        signature.append(byteToHexString(b));
      }
      return signature.toString();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  public static String encodeByJackson(Object req, String appkey, String appsecret) {
    try {
      Map<String, Object> map;
      if(req instanceof String) {
        map = JacksonUtils.jsonString2Obj((String) req, HashMap.class);
      } else if(req instanceof Map) {
        map = (Map) req;
      } else {
        map = BeanTool.toMap(req);
      }
      map.remove("sign");
      map.put("appkey", appkey);
      String signStr = StringFormatterUtils.mapCovertString(map, null, "&", "=");
      String param = signStr + "&appsecret=" + appsecret;
      log.info("appsecret {} guotaiUtil>> {}", appsecret, param);
      System.out.println(param);
      byte[] signHash = SM3Util.hash(param.getBytes("UTF-8"));
      StringBuilder signature = new StringBuilder();
      for (byte b : signHash) {
        signature.append(byteToHexString(b));
      }
      return signature.toString();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      return null;
    }
  }

  public static String byteToHexString(byte ib) {
    char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    char[] ob = new char[2];
    ob[0] = Digit[(ib >>> 4) & 0X0f];
    ob[1] = Digit[ib & 0X0F];
    String str = new String(ob);
    return str;
  }

  public static void main(String[] args) {
    try {
      String req = "{\"amount\":3200.0,\"biddercode\":\"16823212-0\",\"address\":\"南通\",\"baohanno\":\"1181822272020000030\",\"mobile\":\"18862617299\",\"type\":0,\"bank\":\"浙商银>行\",\"phone\":\"18862617299\",\"applyno\":\"TBaoHanNTYG2020022113301054383\",\"biddername\":\"test测试锁1\",\"account\":\"123456\",\"email\":\"776453473@qq.com\",\"timestamp\":\"2020-03-05 15:48:59\"}";
      String sign = GuotaiUtil.encode(req, appkey, appsecret);
      System.out.println(sign);
//      String keys = "CCkilI4yrFBCnIFnswXSMw==";
//      byte[] key = SM4Util.decrypt_Ecb_Padding(appsecret.getBytes(), Base64.decodeBase64(keys));
//      byte[] contentByte = SM4Util.decrypt_Ecb_Padding(keys.getBytes(), Base64.decodeBase64("FGTVlPmbHL2sPVqthsIOJobDQAptfIIyq7eyqgnddI03/1O+WCMJrc/l82qvO0Vv"));
//      byte[] contentByte2 = SM4Util.decrypt_Ecb_Padding(Base64.decodeBase64(keys.getBytes()), Base64.decodeBase64("FGTVlPmbHL2sPVqthsIOJobDQAptfIIyq7eyqgnddI03/1O+WCMJrc/l82qvO0Vv"));
//      System.out.println(new String(contentByte, "UTF-8"));
//      System.out.println(new String(contentByte2, "UTF-8"));
    } catch (Exception e) {
      System.out.println("解密失败");
    }
  }
}
