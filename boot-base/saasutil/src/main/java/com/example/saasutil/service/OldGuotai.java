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
        + "        <OrderNo>10110102111002022092312162262473</OrderNo>\n"
        + "        <PolicyNo>10671003901783314570</PolicyNo>\n"
        + "        <DownloadUrl>https://pj-jy.gongbao.cn/upload/10671003901783314570.pdf</DownloadUrl>\n"
        + "        <Amount>570000.00</Amount>\n"
        + "        <InsuranceTime>2022-09-29 00: 00: 00至2022-12-27 23: 59: 59</InsuranceTime>\n"
        + "        <InsuranceName>中国平安财产保险股份有限公司</InsuranceName>\n"
        + "        <InsuranceAddress>深圳市福田区益田路5033号平安金融中心12、13、38、39、40层</InsuranceAddress>\n"
        + "        <PhoneNumber>95511</PhoneNumber>\n"
        + "        <BidderNumber>18168298388</BidderNumber>\n"
        + "    </body>\n"
        + "    <Sign>EED72DB1DC4ABA1AAC50FFDFCCC0E2CE</Sign>\n"
        + "</root>";

    String key = "BQ7gZnRvhTq7fM1DrS6Xm66r";
    System.out.println(SignUtil.sign(xml, "Sign","body", key));


  }

}
