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
public class newGuotaiNormal {


  public static void main(String[] args) throws Exception {
    String json = "{\n"
        + "    \"appkey\": \"finance_gbinsure\",\n"
        + "    \"timestamp\": \"2022-09-23 14:42:59\",\n"
        + "    \"applyno\": \"TBaoHanGBS2022083016481484550\",\n"
        + "    \"baohanno\": \"SVO62227222162554091\",\n"
        + "    \"sign\": \"e82b26e413d92b89365c03eb24293e8f9096f0d33e7c4245f53e138b749a1af1\"\n"
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
