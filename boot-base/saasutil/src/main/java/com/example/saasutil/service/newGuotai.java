package com.example.saasutil.service;

import com.example.saasutil.util.Base64Util;
import com.example.saasutil.util.FileUtil;
import com.example.saasutil.util.GuotaiUtil;
import com.example.saasutil.util.JacksonUtils;
import com.example.saasutil.util.SM3Util;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-12-30 10:57
 **/
public class newGuotai {


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
        + "\t\t\"appkey\": \"finance_gongbaowang\",\n"
        + "\t\t\"timestamp\": \"2022-04-12 02:11:31\",\n"
        + "\t\t\"applyno\": \"TBaoHanGBWBH2022041117144412458\",\n"
        + "\t\t\"baohanno\": \"PBAQ20226501Q000E00214\",\n"
        + "\t\t\"baohanurl\": \"https://partnertest.mypicc.com.cn/ecooperation/policydownload/downloadurl.do?platfromcodes=CPI001814&policyNo=4FF0AE16055800E6E2C48289D9B77693046C01F5C7196F337F0D337E0D90C0FE&insuredID=5622D769B749E91A9BF519E0EDBAD291&flag=N\",\n"
        + "\t\t\"baohanfile\": \"UEsDBBQACAAIAHARjFQAAAAAAAAAAJwAAAAJAAAAZXJyb3IueG1ss7GvyM1RKEstKs7Mz7NVMtQzUFJIzUvOT8nMS7dVCg1x07VQsrfj4rIpys8vseNSULAJKMpPTi0udkksSQTxgSJFqcWlOSV2Bjb6UBZEOBeoKjE91c7QwMRGH8aB6SgpLcpLy8xJ1QebqY9iKNAcsGUAUEsHCBx6nMpyAAAAnAAAAFBLAQIUABQACAAIAHARjFQcepzKcgAAAJwAAAAJAAAAAAAAAAAAAAAAAAAAAABlcnJvci54bWxQSwUGAAAAAAEAAQA3AAAAqQAAAAAA\",\n"
        + "\t\t\"payername\": \"测试六\",\n"
        + "\t\t\"payeraccount\": \"12345678\",\n"
        + "\t\t\"instname\": \"中国人民财产保险股份有限公司\",\n"
        + "\t\t\"generatetime\": \"2022-04-11 17:29:15\",\n"
        + "\t\t\"rate\": \"0.007\",\n"
        + "\t\t\"cost\": \"600.00\",\n"
        + "\t\t\"applystatus\": \"1\",\n"
        + "\t\t\"sign\": \"59daccc44e7d334d438288bf141d667d708b9a0fb589dd4b4da1ca71e5932486\"\n"
        + "\t}";

    Map<String, String> map = new LinkedHashMap<>();
    map = JacksonUtils.jsonString2Obj(json, Map.class);
    File tempFile = new File("E:\\1234.pdf");
    String url = "https://partnertest.mypicc.com.cn/ecooperation/policydownload/downloadurl.do?platfromcodes=CPI001814&policyNo=4FF0AE16055800E6E2C48289D9B77693046C01F5C7196F337F0D337E0D90C0FE&insuredID=5622D769B749E91A9BF519E0EDBAD291&flag=N";
    FileUtil.copyURLToFile(url, tempFile);
    String str =  Base64Util.fileToBase64(tempFile);
    map.put("baohanfile", str);
    String json1 = JacksonUtils.obj2JsonString(map);
    String appKey = "finance_gongbaowang";
    String signKey = "9c821377-9c04-4adb-96ae-c987f06e1b21";
    String sign = GuotaiUtil.encode(json1, appKey, signKey);
    System.out.println("=================");
    System.out.println();
    System.out.println(json1);
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println(sign);
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
