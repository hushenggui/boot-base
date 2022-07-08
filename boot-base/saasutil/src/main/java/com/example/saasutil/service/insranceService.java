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
    String reqXml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<queryPolicyRequest>\n"
        + "    <requestHead>\n"
        + "        <requestUUID>20220708102012</requestUUID>\n"
        + "        <sign>370C72BB27791DB1FD96198E957977EB</sign>\n"
        + "    </requestHead>\n"
        + "    <requestBody>\n"
        + "        <policyNo>03231301840202200</policyNo>\n"
        + "        <proposalNo>0323130184020220000229</proposalNo>\n"
        + "        <payType>1</payType>\n"
        + "        <payTime>2022-07-08 10:14:38</payTime>\n"
        + "        <insuranceCode>00002</insuranceCode>\n"
        + "        <bankAccount>husg003</bankAccount>\n"
        + "        <accountName>husg03</accountName>\n"
        + "        <downLoadUrl>https://open.pingan.com.cn/Gateway/P_ZJZTB_GP/printGPForDMZ?ciphertext=WStxUVNJVlNsTEVsbm40c0pZWS83Wm5uek5La3dvZzlTU001WnpNUWcwb1JVM0ZCUVFMdUQ3Vi95RVMveURhYkxtTWZKc1EwTHo4c3E0UVVtQUZUY3g0aU1KaTRsSStwa1BJRTdMMGdULzJJR0FGVGY0K05weEF1R0d0SlpEM1F2anhkaEp5cXJDY2lxVmVtQlZqeTFCWjMxc2dtditBWXFNZkRHMm5ocDBvPQ%3D%3D%26sign=Om%2FXlg9XCbeEU3QpFoW4zmR3tBnELGbttrlbpM%2BF14QDnQ9EHgQ21CNsCvTKN4kkTyWumDtQlzdoscx%2BfbdjcGj0Ls08ZhV4tNPi6gRn%2BVWEWcE4rL%2F5i21GiSSIX2D09UuMVu40QaOOMAyMj6iROHZdCHpPYlOY4MiYl0dFjnA%3D</downLoadUrl>\n"
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
