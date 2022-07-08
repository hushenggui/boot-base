package com.example.saasutil.service;

import com.example.saasutil.util.SignUtil;

/**
 * @program: boot-base
 * @description: 保险公司延签
 * @author: hushenggui
 * @create: 2021-11-03 17:46
 **/
public class insranceService1 {
  public static void main(String[] args) {
    String reqXml2 = "<?xml version='1.0' encoding='utf-8'?>\n"
        + "<queryPolicyRequest>\n"
        + "    <requestHead>\n"
        + "        <requestUUID>0c2be428-40ed-4667-9b09-9e76c5f70e94</requestUUID>\n"
        + "        <sign>6904deaea05efca3cd187170a64ae724</sign>\n"
        + "    </requestHead>\n"
        + "    <requestBody>\n"
        + "        <policyNo>2112223405002200001R</policyNo>\n"
        + "        <proposalNo>1112223405002200001Z</proposalNo>\n"
        + "        <payType>1</payType>\n"
        + "        <payTime>2022-06-07 14:14:45</payTime>\n"
        + "        <insuranceCode>00004</insuranceCode>\n"
        + "        <downLoadUrl>\n"
        + "            <![CDATA[https://test-open.zking.com/dz/1MqIp2M]]>\n"
        + "        </downLoadUrl>\n"
        + "        <guaranteeUrl></guaranteeUrl>\n"
        + "    </requestBody>\n"
        + "</queryPolicyRequest>";

    String signKey = "MeTKJnC3fIAxeer8erADRTlJ";
   /* String sign = SignUtil.getSignFromXml(reqXml2, signKey, "requestBody", "00020", "");
    System.out.println(sign);
    String json =  SignUtil.signMap(reqXml2, new HashMap<>(), "sign", "requestBody", sign);
    System.out.println(json);*/

    System.out.println(SignUtil.sign(reqXml2, "sign", "requestBody", signKey));

  }

}
