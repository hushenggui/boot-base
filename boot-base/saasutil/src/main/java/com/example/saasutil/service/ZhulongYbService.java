package com.example.saasutil.service;

import com.example.saasutil.util.ZhuLongYBUtil;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-11-15 09:52
 **/
public class ZhulongYbService {

  public static void main(String[] args) {
    String str = "{\n"
        + "\t\"orderId\": \"YBJRPT2021111210384807077743640\",\n"
        + "\t\"orderStatus\": \"12\",\n"
        + "\t\"guaranteeId\": \"202010506202100015085\",\n"
        + "\t\"validateCode\": \"\",\n"
        + "\t\"insuranceCompany\": \"锦泰财产保险股份有限公司\",\n"
        + "\t\"payStatus\": 1,\n"
        + "\t\"baoFei\": 50000.0,\n"
        + "\t\"jumpUrl\": \"\",\n"
        + "\t\"guaranteeUrl\": \"http://policy.prop.ejintai.com/cbs_prop_policy/epolicy/download3.do?key=6QSUjWawOpqZoT5aO5DU1MfPlPT1YofW\",\n"
        + "\t\"timeStamp\": \"2021-11-12 12:12:36\",\n"
        + "\t\"platformCode\": \"ZL_GBW\",\n"
        + "\t\"signStr\": \"077131e6a0079a9738dd7c64518dd04a\"\n"
        + "}";

    System.out.println(ZhuLongYBUtil.encode(str, "62b116f6-2f58-4a69-a85e-1825d3f8104b"));
  }

}
