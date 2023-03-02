package com.example.saasutil.service;

import com.example.saasutil.util.SignUtil;
import java.util.HashMap;

/**
 * @program: boot-base
 * @description: 保险公司延签
 * @author: hushenggui
 * @create: 2021-11-03 17:46
 **/
public class insranceService {
  public static void main(String[] args) {
    String reqXml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
        + "<queryPolicyRequest>\n"
        + "    <requestHead>\n"
        + "        <sign>5B2BF4FA054A293390F0E685105B4C64</sign>\n"
        + "        <requestUUID>5cfcac63-05e3-48e6-bc86-1e451932c4d6</requestUUID>\n"
        + "    </requestHead>\n"
        + "    <requestBody>\n"
        + "        <policyNo>6230308002222000012</policyNo>\n"
        + "        <proposalNo>T230308002222000023</proposalNo>\n"
        + "        <payType>3</payType>\n"
        + "        <payTime>2023-03-0210:18:59</payTime>\n"
        + "        <downLoadUrl>http://devyun.guorenpcic.com/plcy/myPolicy/getEpolicyUrl?policyNo=6230308002222000012</downLoadUrl>\n"
        + "        <insuranceCode>00020</insuranceCode>\n"
        + "    </requestBody>\n"
        + "</queryPolicyRequest>";

    String signKey = "MeTKJnC3fIAxeer8erADRTlJ";
   /* String sign = SignUtil.getSignFromXml(reqXml2, signKey, "requestBody", "00020", "");
    System.out.println(sign);
    String json =  SignUtil.signMap(reqXml2, new HashMap<>(), "sign", "requestBody", sign);
    System.out.println(json);*/
    String sign = SignUtil.sign(reqXml2, "sign", "requestBody", signKey);
    System.out.println(sign);
   // System.out.println("90C490BF7A2957E676CE21B45546577E".equalsIgnoreCase("90c490bf7a2957e676ce21b45546577e"));

  }

}
