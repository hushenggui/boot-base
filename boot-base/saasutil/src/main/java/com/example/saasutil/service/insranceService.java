package com.example.saasutil.service;

import com.example.saasutil.util.SignUtil;

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
        + "        <sign>C9281C41007B88006A84EC385C63E343</sign>\n"
        + "        <requestUUID>511500-87D423AC2A0947D7B0E593E966D5DC6B</requestUUID>\n"
        + "    </requestHead>\n"
        + "    <requestBody>\n"
        + "        <isPtextFlag>1</isPtextFlag>\n"
        + "        <endorseText>一、本特别约定，作为投标保证保险保单的有效组成部分，与保险合同、保单或其它保险凭证具有同等法律效力。二、保险单生效时间为投保项目投标截止时间，保险期间为投保项目《招标文件》中载明的投标有效期。三、投保人违反所投项目《招标文件》规定要求导致投标保证金不予退还或罚没情形的均属于本保单保险责任。四、退保处理1.开标前投保人自愿放弃投保或项目发生中止、暂停的，可进行退保；2.开标前项目发生流标、终止的，可进行退保；3.开标后项目发生流标的，可进行退保；4.除上述 3 种情形外均不予退保。5.投保人办理退保事宜，满足退保条件的，保险费全额退还。五、线下理赔材料提供如下：1.索赔申请书；2.招标文件和投标文件；3.投保人违约证明材料。六、保险公司应在收到索赔申请书和相关材料后 10 个工作日内完成理赔。七、保险人向被保险人赔偿后，保险人享有向投保人追偿的权利。</endorseText>\n"
        + "        <policyno>202010506202100013037</policyno>\n"
        + "        <correctInfo>\n"
        + "            <dateInfo>\n"
        + "                <stratDate>2021-10-08 00:00:00</stratDate>\n"
        + "                <endDate>2022-04-05 23:59:59</endDate>\n"
        + "                <tender>180</tender>\n"
        + "            </dateInfo>\n"
        + "            <insuredInfo>\n"
        + "                <name>宜宾戎州金成建设投资开发集团有限公司</name>\n"
        + "                <idNumber>91511521MA62AFK7X1</idNumber>\n"
        + "                <mobile>17398803602</mobile>\n"
        + "            </insuredInfo>\n"
        + "            <baqRequiredInfo>\n"
        + "                <projectName>宜宾市叙州区南部新区ABO片区综合开发项目（一标段）监理一标段</projectName>\n"
        + "                <projectNo>YBXSZ2021090003001</projectNo>\n"
        + "                <tendereeAddress>511500</tendereeAddress>\n"
        + "            </baqRequiredInfo>\n"
        + "        </correctInfo>\n"
        + "    </requestBody>\n"
        + "</correctRequest>";

    String signKey = "IwBu03ZxIo2Ih0P8t7TTVHGDwhaugjuY";
    System.out.println(SignUtil.getSignFromXml(reqXml2, signKey, "requestBody", "00021", ""));
  }

}
