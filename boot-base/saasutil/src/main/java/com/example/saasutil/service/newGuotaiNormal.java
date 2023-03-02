package com.example.saasutil.service;

import com.example.saasutil.util.Base64Util;
import com.example.saasutil.util.FileUtil;
import com.example.saasutil.util.GuotaiUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.SM3Util;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-12-30 10:57
 **/
public class newGuotaiNormal extends Object{


  public static void main(String[] args) throws Exception {
    String json = "{\n"
        + "\t\"appkey\": \"finance_gbinsure\",\n"
        + "\t\"timestamp\": \"2023-02-01 16:39:32\",\n"
        + "\t\"applyno\": \"TBaoHanGBS2023013012010599003\",\n"
        + "\t\"baohanno\": \"PBAQ20236501Q000E00288\",\n"
        + "\t\"sign\": \"4f7efcc87a23d3fbb3e146b9052d18916540473768f411b5df0fb9b27ef78f7c\"\n"
        + "}";

    String appKey = "finance_gbinsure";
    String signKey = "317307f1-781f-40da-9a0f-e5513ca8de64";
    String sign = GuotaiUtil.encode(json, appKey, signKey);
    System.out.println(json);
    System.out.println(sign);

/*    String param = "Reason=测试&appkey=finance_gongbaowang&applyno=TBaoHanGBWBH2022022314223517227&applyusername=测试&applyuserphone=18118833439&baohanno=1&filelist=[{\"fileurl\":\"http://www.baidu.com/img/flexible/logo/pc/result.png\"}]&payeraccount=1&payeramount=1&platformcode=A3205650121&timestamp=2022-02-23 16:07:17&appsecret=9c821377-9c04-4adb-96ae-c987f06e1b21";
    byte[] signHash = SM3Util.hash(param.getBytes("UTF-8"));
    StringBuilder signature = new StringBuilder();
    for (byte b : signHash) {
      signature.append(byteToHexString(b));
    }
    System.out.println(signature.toString());*/

  }

  public static String byteToHexString(byte ib) {
    char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    char[] ob = new char[2];
    ob[0] = Digit[(ib >>> 4) & 0X0f];
    ob[1] = Digit[ib & 0X0F];
    String str = new String(ob);
    return str;
  }

}
