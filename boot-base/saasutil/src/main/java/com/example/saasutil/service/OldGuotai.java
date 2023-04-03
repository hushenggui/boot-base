package com.example.saasutil.service;

import com.example.saasutil.util.SignUtil;
import java.util.List;

/**
 * @program: boot-base
 * @description: 老国泰
 * @author: hushenggui
 * @create: 2021-06-29 17:17
 **/
public class OldGuotai {

  public static void main(String[] args) {
    String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
        + "<root>\n"
        + "    <AccName>PRJ_Receipt</AccName>\n"
        + "    <body>\n"
        + "        <OrderNo>TBaoHanGB2023032211450547232</OrderNo>\n"
        + "        <PolicyNo>EP202303810024104173</PolicyNo>\n"
        + "        <DownloadUrl>https://eeds-jy.gongbao.cn/upload/EP202303810024104173.pdf</DownloadUrl>\n"
        + "        <Amount>40000.00</Amount>\n"
        + "        <InsuranceTime>2023-03-27 00:00:00 至 2023-06-24 23:59:59</InsuranceTime>\n"
        + "        <InsuranceName>太平财产保险有限公司</InsuranceName>\n"
        + "        <InsuranceAddress>深圳市福田区益田路6001号太平金融大厦33层</InsuranceAddress>\n"
        + "        <PhoneNumber>95589</PhoneNumber>\n"
        + "        <BidderNumber>18047724628</BidderNumber>\n"
        + "    </body>\n"
        + "    <Sign>4DAC15AEB21A55DA67532F8A3F823845</Sign>\n"
        + "</root>";

    String key = "B86C37C1A09E49737E2F3139BCC35D78";
    System.out.println(SignUtil.sign(xml, "Sign","body", key));


  }

}
