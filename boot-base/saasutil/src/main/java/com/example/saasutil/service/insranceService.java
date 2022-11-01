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
        + "<correctRequest>\n"
        + "    <requestHead>\n"
        + "        <sign>4A548003149ED095DFF729C5D82B34C3</sign>\n"
        + "        <requestUUID>211100-6B6B24198E3A4D02993A447B3730F935</requestUUID>\n"
        + "    </requestHead>\n"
        + "    <requestBody>\n"
        + "        <isPtextFlag>1</isPtextFlag>\n"
        + "        <endorseText>一、本特别约定，作为投标保证保险合同的有效组成部分，与保险保单或其它保险 凭证具有同等法律效力。 二、保险单生效时间为投保项目投标截止时间，保险期间为投保项目《招标文件》 中载明的投标有效期。 三、投保人违反所投项目《招标文件》规定要求导致投标保证金不予退还情形的均 属于本保单保险责任。 四、退保处理 1.开标前项目发生中止、暂停的，可进行退保； 2.开标前项目发生流标、终止的，可进行退保； 3.开标后项目发生流标的，可进行退保； 4.除上述 3 种情形外均不予退保。 5.投保人办理退保事宜，满足退保条件的，保险费全额退还。 五、线下理赔材料提供如下： 1.索赔申请书； 2.招标文件和投标文件； 3.投保人违约证明材料。 六、保险公司应在收到索赔申请书和相关材料后 10 个工作日内完成理赔。 七、保险人向被保险人赔偿后，保险人享有向投保人追偿的权利。</endorseText>\n"
        + "        <policyno>10671003901782578468</policyno>\n"
        + "        <correctInfo>\n"
        + "            <dateInfo>\n"
        + "                <stratDate>2022-09-29 00:00:00</stratDate>\n"
        + "                <endDate>2022-12-27 23:59:59</endDate>\n"
        + "                <tender>90</tender>\n"
        + "            </dateInfo>\n"
        + "            <insuredInfo>\n"
        + "                <name>盘锦市自然资源事务服务中心</name>\n"
        + "                <idNumber>12211100MB19949408</idNumber>\n"
        + "                <mobile>04273390888</mobile>\n"
        + "            </insuredInfo>\n"
        + "            <baqRequiredInfo>\n"
        + "                <projectName>2022年度辽河流域（浑太水系）山水林田湖草沙一体化保护和修复工程（下游盘锦段）（中央资金部分）项目EPC</projectName>\n"
        + "                <projectNo>202221110011263987001</projectNo>\n"
        + "                <tendereeAddress>盘锦市兴隆台区惠宾大街109号</tendereeAddress>\n"
        + "            </baqRequiredInfo>\n"
        + "        </correctInfo>\n"
        + "    </requestBody>\n"
        + "</correctRequest>";

    String signKey = "yglXW9iOz6aqh66y2RX00X1aZKTCBM";
   /* String sign = SignUtil.getSignFromXml(reqXml2, signKey, "requestBody", "00020", "");
    System.out.println(sign);
    String json =  SignUtil.signMap(reqXml2, new HashMap<>(), "sign", "requestBody", sign);
    System.out.println(json);*/

    System.out.println(SignUtil.sign(reqXml2, "sign", "requestBody", signKey));

  }

}
