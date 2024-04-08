package com.example.saasutil.service;

import cn.hutool.http.HttpUtil;
import com.example.saasutil.util.HttpClientUtil;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2023-12-26 09:45
 **/
public class HttpsTsl {

  public static void main(String[] args) throws Exception {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <queryRequest> <requestHead> <requestUUID>96c2207f-31cd-4641-a010-94ab1997212a</requestUUID> <sign>bc147974d68f9384a43f305ef807b3af</sign> </requestHead> <requestBody> <insuranceCode>00005</insuranceCode> <orgCode>00005</orgCode> <queryDate>20231221</queryDate> </requestBody> </queryRequest>";

    //String post = HttpUtil.post("https://taihu-jy.gongbao.cn/ic-service/insuranceNotice/getFileUrl", xml);
    HttpClientUtil.sendHttpPostBody(
        "https://taihu-jy.gongbao.cn/ic-service/insuranceNotice/getFileUrl", xml, 1,
        HttpClientUtil.UTF8, 30000);
  }

}
