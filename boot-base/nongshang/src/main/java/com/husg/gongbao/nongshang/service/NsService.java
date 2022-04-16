package com.husg.gongbao.nongshang.service;

import com.husg.gongbao.nongshang.utils.NSHttpUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpMethod;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-11-08 13:25
 **/
public class NsService {


  public static void main(String[] args) {
    String url = "http://106.14.21.222:2011";
    String params = " \n hello word";
    Map<String, String> headers = new HashMap<>();
    headers.put("Content-Type", "INFOSEC_SIGN/1.0");
    String resp = NSHttpUtil.request(url, params, headers, HttpMethod.POST.name());
    System.out.println("返回结果：" + resp);
  }

}
