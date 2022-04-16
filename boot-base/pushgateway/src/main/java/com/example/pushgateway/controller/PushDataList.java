package com.example.pushgateway.controller;

import com.example.pushgateway.config.AlterCollector;
import com.example.pushgateway.config.AlterCollectorListMore;
import com.example.pushgateway.config.GBPushGateway;
import com.example.pushgateway.dto.AlterDto;
import com.example.pushgateway.enums.AlertLevel;
import com.example.pushgateway.utils.JacksonUtils;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.PushGateway;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2022-02-15 13:19
 **/
@RestController
@Slf4j
public class PushDataList {

  @Autowired
  GBPushGateway gbPushGateway;

  @RequestMapping("pushList")
  @GetMapping
  public String push(String value){
    String log = "{\"alertName\":\"交易中心_还原失败\",\"alertSource\":\"电子保函\",\"alertArea\":\"kashi\",\"alertType\":\"TRADE_CENTER\",\"errorCode\":\"TC00030\",\"content\":\"123\",\"traceId\":\"08277fdd-1328-4503-be99-065bbfd246df\",\"orderSerialNo\":\"orderSeriaNo-123456\",\"policyNo\":\"policyNo-123456\",\"orderNo\":\"orderNo-123456\",\"alertTime\":\"2021-02-25 14:20:01\",\"alertTimes\":1,\"alertLevel\":\"HIGH\",\"alertIp\":\"gbj_test01/172.16.76.69\",\"application\":\"TC_SERVICE\",\"requestUrl\":\"\",\"requestBody\":\"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"?><root><Sign>95ad7499fa1c0769dbaa5e247b597830</Sign><body><OrderInfos><OrderInfo><OrderNo>5c1acc12-5ee3-4e51-acb3-d1bfe87c3cdf</OrderNo></OrderInfo></OrderInfos></body></root>\",\"responseBody\":\"1234\",\"result\":\"\",\"tradeCode\":\"\",\"requester\":\"\",\"receiver\":\"公共资源交易中心\"}\n" +
        "\n";

    String job = "Testhushenggui-01111";
    System.out.println("开始发送value：-----" + value);
    AlterDto alterDto = JacksonUtils.jsonString2Obj(log, AlterDto.class);
    alterDto.setOrderSerialNo(job);
    alterDto.setCityCode("653100");
    alterDto.setCityName("喀什市");
    alterDto.setAlertTimes(1);
    alterDto.setAlertLevel(AlertLevel.HIGH);
    alterDto.setAlertSource("SaaS0");


    String log1 = "{\"alertName\":\"交易中心_还原失败__shibai\",\"alertSource\":\"电子保函\",\"alertArea\":\"kashi\",\"alertType\":\"TRADE_CENTER\",\"errorCode\":\"TC00029\",\"content\":\"123\",\"traceId\":\"08277fdd-1328-4503-be99-12334\",\"orderSerialNo\":\"orderSeriaNo-123456\",\"policyNo\":\"policyNo-123456\",\"orderNo\":\"orderNo-123456\",\"alertTime\":\"2021-02-25 14:20:01\",\"alertTimes\":1,\"alertLevel\":\"HIGH\",\"alertIp\":\"gbj_test01/172.16.76.69\",\"application\":\"TC_SERVICE\",\"requestUrl\":\"\",\"requestBody\":\"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"?><root><Sign>95ad7499fa1c0769dbaa5e247b597830</Sign><body><OrderInfos><OrderInfo><OrderNo>5c1acc12-5ee3-4e51-acb3-d1bfe87c3cdf</OrderNo></OrderInfo></OrderInfos></body></root>\",\"responseBody\":\"1234\",\"result\":\"\",\"tradeCode\":\"\",\"requester\":\"\",\"receiver\":\"公共资源交易中心\"}\n" +
        "\n";

    System.out.println("开始发送value：-----" + value);
    AlterDto alterDto1 = JacksonUtils.jsonString2Obj(log1, AlterDto.class);
    alterDto1.setOrderSerialNo(job);
    alterDto1.setCityCode("653100");
    alterDto1.setCityName("喀什市");
    alterDto1.setAlertTimes(1);
    alterDto1.setAlertLevel(AlertLevel.HIGH);
    alterDto1.setAlertSource("SaaS1");

    List<AlterDto> alterDtoList = new ArrayList<>();
    alterDtoList.add(alterDto1);
    alterDtoList.add(alterDto);
    CollectorRegistry registry = new CollectorRegistry(Boolean.TRUE);
    try {

      AlterCollectorListMore requests = new AlterCollectorListMore(alterDtoList);
      registry.register(requests);
      String alertLevel = org.apache.commons.lang3.StringUtils.defaultIfEmpty(alterDto.getAlertLevel().name(), "null") ;
      String errorCode = org.apache.commons.lang3.StringUtils.defaultIfEmpty(alterDto.getErrorCode().name(), "null") ;
      Map<String, String> groupingKey = new HashMap<>();
      groupingKey.put("instance", alterDto.getJob());
      groupingKey.put("alertLevel", alertLevel);
      groupingKey.put("errorCode", errorCode);
      gbPushGateway.pushAdd(registry, "huadong", groupingKey);
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      registry.clear();
      CollectorRegistry.defaultRegistry.clear();
    }
    return "success";
  }

}
