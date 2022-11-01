package com.example.saasutil.service;

import com.example.saasutil.util.Base64Util;
import com.example.saasutil.util.FileUtil;
import com.example.saasutil.util.GuotaiUtil;
import com.example.saasutil.util.JacksonUtils;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-12-30 10:57
 **/
public class newGuotaiNotice {


  public static void main(String[] args) throws Exception {
    /*String json = "{\"appkey\":\"finance_gongbaowang\",\"applyno\":\"TBaoHanGBWBH2022022314223517227\",\"biaoduanname\":\"22yLFrP+hxQKOJe71oMF4Q==\",\"biaoduanno\":\"ZQTlFtJoYGGph9ER3ft7rOynfKUgdTF2gGqvpgvv9fk=\",\"biddercode\":\"123456789987654332\",\"biddername\":\"江苏国泰测试用单位新疆4建\",\"bzjamount\":\"20000.00\",\"jbrname\":\"张三\",\"jbrphone\":\"18118833439\",\"platformcode\":\"A3205650121\",\"sign\":\"0aad4d9c91de0ea47ba9aac295397e96f8b8113577049b0587222fd3c168504c\",\"timestamp\":\"2022-02-23 14:22:13\",\"zbr\":\"XhKYCAmA6IqQvH/eDuTabVrzVPeTmWLluA0X4fkU00k=\",\"zbrorgnum\":\"6ParPCtarP8r5rCLbv3wZ1gIEjlmUW27AOfUxd+85ww=\"}";

    String appKey = "finance_gongbaowang";
    String signKey = "9c821377-9c04-4adb-96ae-c987f06e1b21";
    String sign = GuotaiUtil.encode(json, appKey, signKey);
    System.out.println(json);
    System.out.println(sign);

    String param = "Reason=测试&appkey=finance_gongbaowang&applyno=TBaoHanGBWBH2022022314223517227&applyusername=测试&applyuserphone=18118833439&baohanno=1&filelist=[{\"fileurl\":\"http://www.baidu.com/img/flexible/logo/pc/result.png\"}]&payeraccount=1&payeramount=1&platformcode=A3205650121&timestamp=2022-02-23 16:07:17&appsecret=9c821377-9c04-4adb-96ae-c987f06e1b21";
    byte[] signHash = SM3Util.hash(param.getBytes("UTF-8"));
    StringBuilder signature = new StringBuilder();
    for (byte b : signHash) {
      signature.append(byteToHexString(b));
    }
    System.out.println(signature.toString());*/
    String json = "{\n"
        + "\t\"appkey\": \"finance_gbinsure\",\n"
        + "\t\"timestamp\": \"2022-09-15 10:46:52\",\n"
        + "\t\"applyno\": \"TBaoHanGBS2022091121593860302\",\n"
        + "\t\"baohanno\": \"12374003901774119296\",\n"
        + "\t\"baohanurl\": \"https://xjbt-jy.gongbao.cn/ic-service/gongbaoToInsurance/download?policyNo=12374003901774119296\",\n"
        + "\t\"sign\": \"81607f42d3111604e5aa32abb20cbbb8352a2090e5f5f9a80c736386d403d8ae\"\n"
        + "}";

    Map<String, String> map = new LinkedHashMap<>();
    map = JacksonUtils.jsonString2Obj(json, Map.class);
    File tempFile = new File("E:\\12374003901774119296.pdf");
    String url = "https://xjbt-jy.gongbao.cn/ic-service/gongbaoToInsurance/download?policyNo=12374003901773074106";
    //FileUtil.copyURLToFile(url, tempFile);
    String str =  Base64Util.fileToBase64(tempFile);
    map.put("baohanfile", str);
    String json1 = JacksonUtils.obj2JsonString(map);
    String appKey = "finance_gbinsure";
    String signKey = "317307f1-781f-40da-9a0f-e5513ca8de64";
    String sign = GuotaiUtil.encode(json1, appKey, signKey);
    System.out.println("=================");
    System.out.println();
    System.out.println(json1);
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println(sign);

    byte[] bytes = Base64Util.decodeImage(str);
    File tempFile1 = new File("E:\\1111.pdf");
    FileUtils.writeByteArrayToFile(tempFile1, bytes);

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
