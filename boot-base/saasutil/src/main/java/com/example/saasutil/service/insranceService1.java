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
    String reqXml2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
        + "<correctRequest>    <requestHead>      <sign>E58E36781626AEA0DEAED4A93973676B</sign>       <requestUUID>610100-25B960C7A62149F485B31AB8060D107F</requestUUID>    </requestHead>     <requestBody>      <isPtextFlag>1</isPtextFlag>       <endorseText>一、本特别约定，作为投标保证保险合同的有效组成部分，与保险保单或其它保险凭证具有同等法律效力。二、保险单生效时间为投保项目投标截止时间，保险期间为投保项目《招标文件》中载明的投标有效期。三、投保人违反所投项目《招标文件》规定要求导致投标保证金不予退还情形的均属于本保单保险责任。四、线下理赔材料提供如下：1.索赔申请书；2.招标文件和投标文件；3.投保人违约证明材料。五、保险公司应在收到索赔申请书和相关材料后10个工作日内完成理赔。六、保险人向被保险人赔偿后，保险人享有向投保人追偿的权利。</endorseText>       <policyno>11744003902019378279</policyno>     <correctInfo>        <dateInfo>          <stratDate>2023-05-04 00:00:00</stratDate>           <endDate>2023-10-30 23:59:59</endDate>           <tender>180</tender>        </dateInfo>         <insuredInfo>          <name>西安市高新区城更隆汇房地产开发有限公司</name>           <idNumber>91610132MAB0TB03XD</idNumber>           <mobile>15029913307</mobile>        </insuredInfo>         <baqRequiredInfo>          <projectName>隆清城景观绿化工程</projectName>           <projectNo>E6101003506Io5zxzEky001</projectNo>          <tendereeAddress>西安市高新区高新四路1号高科广场A座26层</tendereeAddress>       </baqRequiredInfo>      </correctInfo>    </requestBody>  </correctRequest>";

    String signKey = "bpZ5VvBwJF8tN3QhHqeGRE2csAySWgmX";
   /* String sign = SignUtil.getSignFromXml(reqXml2, signKey, "requestBody", "00020", "");
    System.out.println(sign);
    String json =  SignUtil.signMap(reqXml2, new HashMap<>(), "sign", "requestBody", sign);
    System.out.println(json);*/

    System.out.println(SignUtil.sign(reqXml2, "sign", "requestBody", signKey));

  }

}
