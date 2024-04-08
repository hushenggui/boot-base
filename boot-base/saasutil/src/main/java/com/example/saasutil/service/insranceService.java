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
    String reqXml2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
        + "<queryPolicyRequest>\n"
        + "    <requestHead>\n"
        + "        <sign>f557b2c1b104bee497ed69060c34145b</sign>\n"
        + "        <requestUUID>1710233400602</requestUUID>\n"
        + "    </requestHead>\n"
        + "    <requestBody>\n"
        + "        <policyNo>HAB112227R1HHLKPTC00</policyNo>\n"
        + "        <proposalNo>TAB112227R1HHLKPTC00</proposalNo>\n"
        + "        <payType>3</payType>\n"
        + "        <payTime>2024-03-12 16:49:48</payTime>\n"
        + "        <insuranceCode>00009</insuranceCode>\n"
        + "        <downLoadUrl>\n"
        + "            <![CDATA[https://iepolicy.sinosig.com/digitalBill_download/downloadCmsPolicy.action?files=e2be26047d520edfdb7727673affba93bc27baf93b2fae01d6dd7f1c4739ec13085fa08208bce6ad8ea85d7b56328b7e384e412ccdfc3d08487ce9ac988882f934f39d78680d9112ea0c87a7e999209a82e480cb2a20bb7af8094bfb1d1bc410&type=C]]>\n"
        + "        </downLoadUrl>\n"
        + "    </requestBody>\n"
        + "</queryPolicyRequest>";


    String signKey = "3A6F4D7A5468091D1DA8C9AE9C0B1610";
   /* String sign = SignUtil.getSignFromXml(reqXml2, signKey, "requestBody", "00020", "");
    System.out.println(sign);
    String json =  SignUtil.signMap(reqXml2, new HashMap<>(), "sign", "requestBody", sign);
    System.out.println(json);*/
    String sign = SignUtil.sign(reqXml2, "sign", "requestBody", signKey);
    System.out.println(sign);
   // System.out.println("90C490BF7A2957E676CE21B45546577E".equalsIgnoreCase("90c490bf7a2957e676ce21b45546577e"));

  }

}
