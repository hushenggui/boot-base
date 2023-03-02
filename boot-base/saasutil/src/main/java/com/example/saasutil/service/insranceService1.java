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
    String reqXml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<queryPolicyRequest>\n"
        + "    <requestHead>\n"
        + "        <requestUUID>3fc6099c-3021-4a5b-af8c-e3a3b14c8300</requestUUID>\n"
        + "        <sign>a875b15b139ddd6c358a0538ff17c334</sign>\n"
        + "    </requestHead>\n"
        + "    <requestBody>\n"
        + "        <policyNo>PBTP22430105070000960001</policyNo>\n"
        + "        <proposalNo>0323130184020220000340</proposalNo>\n"
        + "        <downLoadUrl>https://iopen-uat.ccic-net.com.cn/management-service/rest/v1/epolicy/download/PBTP22430105070000960001-6527BAC7A7A032892D3C604B6E64269851340C9BA782240011E70413B7F6E6B7</downLoadUrl>\n"
        + "        <payType>3</payType>\n"
        + "        <payTime>2022-11-17 09:01:33</payTime>\n"
        + "        <insuranceCode>00005</insuranceCode>\n"
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
