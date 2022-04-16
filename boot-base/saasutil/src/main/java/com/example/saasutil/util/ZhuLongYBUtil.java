package com.example.saasutil.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ZhuLongYBUtil {

  public static final String appkey = "ZL_GBW";
  public static final String demo = "SM4加解密测试DEMO";
  public static String sortparam = "appkey=finance_yg&applyno=TBaoHanNTYG2020022113301054383&applystatus=1&baohanfile=aHR0cHM6Ly9pZXBvbGljeS5zaW5vc2lnLmNvbS9kaWdpdGFsQmlsbF9kb3dubG9hZC9kb3dubG9hZFBvbGljeS5hY3Rpb24/ZmlsZT0yMDIwMDMwMjE0MDEtN2ZiMTdlM2UtMzA0ZC00YmJjLWI3NTUtNjM2MTNiOTA5OWZh&baohanno=1181822272020000030&baohanurl=http://testservicebus.sinosig.com/WebContent/QueryEpolicyForGBW.do?sign=MTE4MTgyMjI3MjAyMDAwMDAzMCxZR05UVEJMWQ==&cost=3200.00&generatetime=2020-03-03 19:11:03&instname=阳光财产保险股份有限公司&payeraccount=345678954678&payername=中国银行&rate=1.00&timestamp=2020-03-04 10:58:00";//排序使用treemap，key1=value1&key2=value2
  public static final String appsecret = "62b116f6-2f58-4a69-a85e-1825d3f8104b";

  public static void main1(String[] args) throws Exception {

 /*   // SM4加密原文
    byte[] bKey = SM4Util.generateKey();
    byte[] sm4 = SM4Util.encrypt_Ecb_Padding(bKey, demo.getBytes("UTF-8"));
    String encData = Base64.encodeBase64String(sm4);
    System.out.println("密文：" + encData);
    byte[] dd = SM4Util.decrypt_Ecb_Padding(bKey, Base64.decodeBase64(encData));
    String datainfo = new String(dd, "UTF-8");
    System.out.println("解密后的原文：" + datainfo);

    //sign签名
    sortparam += "appsecret=" + appsecret;
    byte[] signHash = SM3Util.hash(sortparam.getBytes("UTF-8"));
    StringBuilder signature = new StringBuilder();
    for (byte b : signHash) {
      signature.append(byteToHexString(b));
    }
    String sign = signature.toString();
    System.out.println("签名String值为：" + sign);*/


  }

  public static void main(String[] args) {
    String str = "{\n"
        + "\t\"orderId\": \"YBJRPT2021111210384807077743640\",\n"
        + "\t\"orderStatus\": \"12\",\n"
        + "\t\"guaranteeId\": \"202010506202100015085\",\n"
        + "\t\"validateCode\": \"\",\n"
        + "\t\"insuranceCompany\": \"锦泰财产保险股份有限公司\",\n"
        + "\t\"payStatus\": 1,\n"
        + "\t\"baoFei\": 50000.0,\n"
        + "\t\"jumpUrl\": \"\",\n"
        + "\t\"guaranteeUrl\": \"http://policy.prop.ejintai.com/cbs_prop_policy/epolicy/download3.do?key=6QSUjWawOpqZoT5aO5DU1MfPlPT1YofW\",\n"
        + "\t\"timeStamp\": \"2021-11-12 12:12:36\",\n"
        + "\t\"platformCode\": \"ZL_GBW\",\n"
        + "\t\"signStr\": \"077131e6a0079a9738dd7c64518dd04a\"\n"
        + "}";

    System.out.println(encode(str, "62b116f6-2f58-4a69-a85e-1825d3f8104b"));
  }

  public static String encode(Object req, String appsecret) {
    try {
      Gson gson = new Gson();
      Map<String, Object> map;
      if(req instanceof String) {
        map = gson.fromJson((String) req,new TypeToken<HashMap<String,String>>(){}.getType());
      } else if(req instanceof Map) {
        map = (Map) req;
      } else {
        map = BeanTool.toMap(req);
      }
      map.remove("signStr");
      String signStr = StringFormatterYBUtils.mapCovertString(map, null, "", "=");
      String param = signStr + appsecret;
       String sign= md5(param);
      return sign;
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


  public static String md5(String content) {
    if (content == null) {
      return null;
    }
    StringBuffer buf = new StringBuffer();
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(content.getBytes());
      byte b[] = md.digest();
      int i;
      for (int offset = 0; offset < b.length; offset++) {
        i = b[offset];
        if (i < 0) {
          i += 256;
        }
        if (i < 16) {
          buf.append("0");
        }
        buf.append(Integer.toHexString(i));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return buf.toString();
  }
}
