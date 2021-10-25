package com.example.saasutil.service;

import com.example.saasutil.util.SignUtil;

/**
 * @program: boot-base
 * @description: 老国泰
 * @author: hushenggui
 * @create: 2021-06-29 17:17
 **/
public class OldGuotai {

  public static void main(String[] args) {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
        + "<root>\n"
        + "    <corrects>\n"
        + "         <correct>\n"
        + "            <OrderNo>TBaoHanGB2021070209222804482</OrderNo>\n"
        + "            <PolicyNo>EP202100000077938995</PolicyNo>\n"
        + "            <DecodeKey>832c33c2-0c4d-4308-a973-372c19ce09b9</DecodeKey>\n"
        + "            <OpenTime>2021-07-05 09:30:00</OpenTime>\n"
        + "            <TendereeCode>Y13301123456123456</TendereeCode>\n"
        + "        </correct>\n"
        + "\t\t\n"
        + "\t\t\n"
        + "\t\t <correct>\n"
        + "            <OrderNo>TBaoHanGB2021063009375329572</OrderNo>\n"
        + "            <PolicyNo>06022105160923202100000691</PolicyNo>\n"
        + "            <DecodeKey>75a401d5-84f3-4de4-8bdf-b3d89c8a8cd5</DecodeKey>\n"
        + "            <OpenTime>2021-07-05 09:30:00</OpenTime>\n"
        + "            <TendereeCode>Y13301123456123456</TendereeCode>\n"
        + "        </correct>\n"
        + "\t\t\n"
        + "\t\t\n"
        + "\t\t\n"
        + "\n"
        + "\t\t\n"
        + "    </corrects>\n"
        + "    <Sign>9285ba7baae9cde83d5fee19b246c083</Sign>\n"
        + "</root>";

    String key = "B86C37C1A09E49737E2F3139BCC35D78";
    System.out.println(SignUtil.sign(xml, "Sign","corrects", key));
  }

}
