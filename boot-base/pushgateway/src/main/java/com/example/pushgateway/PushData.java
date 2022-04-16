package com.example.pushgateway;

import com.example.pushgateway.config.AlterCollector;
import com.example.pushgateway.config.GBPushGateway;
import com.example.pushgateway.dto.AlterDto;
import com.example.pushgateway.utils.JacksonUtils;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.PushGateway;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @program: boot-base
 * @description:
 * @author: hushenggui
 * @create: 2021-02-24 16:03
 **/
@RestController
@Slf4j
public class PushData {
    @Autowired
    GBPushGateway pushgateway;

    public final static  String SEND_ALERT_MSG_ALERT_NAME_YACE = "压测数据-test";

    @RequestMapping("test")
    @GetMapping
    public String push(String value, String job){
        String log = "{\"alertName\":\"交易中心_还原失败\",\"alertSource\":\"电子保函\",\"alertArea\":\"kashi\",\"alertType\":\"TRADE_CENTER\",\"errorCode\":\"TC00030\",\"content\":\"123\",\"traceId\":\"08277fdd-1328-4503-be99-065bbfd246df\",\"orderSerialNo\":\"orderSeriaNo-123456\",\"policyNo\":\"policyNo-123456\",\"orderNo\":\"orderNo-123456\",\"alertTime\":\"2021-02-25 14:20:01\",\"alertTimes\":1,\"alertLevel\":\"HIGH\",\"alertIp\":\"gbj_test01/172.16.76.69\",\"application\":\"TC_SERVICE\",\"requestUrl\":\"\",\"requestBody\":\"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"?><root><Sign>95ad7499fa1c0769dbaa5e247b597830</Sign><body><OrderInfos><OrderInfo><OrderNo>5c1acc12-5ee3-4e51-acb3-d1bfe87c3cdf</OrderNo></OrderInfo></OrderInfos></body></root>\",\"responseBody\":\"1234\",\"result\":\"\",\"tradeCode\":\"\",\"requester\":\"\",\"receiver\":\"公共资源交易中心\"}\n" +
                "\n";

        /*for (int i = 8; i < 200 ; i++) {
            System.out.println("开始发送value：-----" + i);
            AlterDto alterDto = JacksonUtils.jsonString2Obj(log, AlterDto.class);
            CollectorRegistry registry = new CollectorRegistry(Boolean.TRUE);
            try {
                Thread.sleep(10000);
                System.out.println("10 s ----");
                AlterCollector requests = new AlterCollector(alterDto, String.valueOf(i));
                registry.register(requests);
                pushgateway.pushAdd(registry, job + i);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                registry.clear();
                CollectorRegistry.defaultRegistry.clear();
            }
        }*/

        System.out.println("开始发送value：-----" + value);
        AlterDto alterDto = JacksonUtils.jsonString2Obj(log, AlterDto.class);
        alterDto.setOrderSerialNo(job);
        alterDto.setCityCode("653100");
        alterDto.setCityName("喀什市");
        CollectorRegistry registry = new CollectorRegistry(Boolean.TRUE);
        try {
            registry.clear();
            AlterCollector requests = new AlterCollector(alterDto, String.valueOf(value));
            registry.register(requests);
            String alertLevel = org.apache.commons.lang3.StringUtils.defaultIfEmpty(alterDto.getAlertLevel().name(), "null") ;
            String errorCode = org.apache.commons.lang3.StringUtils.defaultIfEmpty(alterDto.getErrorCode().name(), "null") ;
            Map<String, String> groupingKey = new HashMap<>();
            groupingKey.put("instance", alterDto.getJob());
            groupingKey.put("alertLevel", alertLevel);
            groupingKey.put("errorCode", errorCode);
            pushgateway.pushAdd(registry, "huadong", groupingKey);
        }catch (Exception e){
            e.printStackTrace();
            registry.clear();
        }
        return "success";
    }

    @RequestMapping("testL")
    @GetMapping
    public String pushL(){
        String log = "{\"alertName\":\"交易中心_还原失败\",\"alertSource\":\"电子保函\",\"alertArea\":\"kashi\",\"alertType\":\"TRADE_CENTER\",\"errorCode\":\"TC00030\",\"content\":\"123\",\"traceId\":\"08277fdd-1328-4503-be99-065bbfd246df\",\"orderSerialNo\":\"orderSeriaNo-123456\",\"policyNo\":\"policyNo-123456\",\"orderNo\":\"orderNo-123456\",\"alertTime\":\"2021-02-25 14:20:01\",\"alertTimes\":1,\"alertLevel\":\"HIGH\",\"alertIp\":\"gbj_test01/172.16.76.69\",\"application\":\"TC_SERVICE\",\"requestUrl\":\"\",\"requestBody\":\"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"?><root><Sign>95ad7499fa1c0769dbaa5e247b597830</Sign><body><OrderInfos><OrderInfo><OrderNo>5c1acc12-5ee3-4e51-acb3-d1bfe87c3cdf</OrderNo></OrderInfo></OrderInfos></body></root>\",\"responseBody\":\"1234\",\"result\":\"\",\"tradeCode\":\"\",\"requester\":\"\",\"receiver\":\"公共资源交易中心\"}\n" +
            "\n";
        System.out.println("开始发送value：-----" + 1);
        String json = "{\"alertSource\":\"probe\",\"alertArea\":\"kashi-ceshi\",\"errorCode\":\"TC00002\",\"traceId\":\"\",\"orderSerialNo\":\"\",\"policyNo\":\"\",\"orderNo\":\"\",\"alertTime\":\"\",\"alertTimes\":1,\"alertLevel\":\"SEVERE\",\"requestBody\":\"测试数据\",\"responseBody\":\"测试数据\",\"cityCode\":\"650100\",\"cityName\":\"测试\"}";
        AlterDto alterDto = JacksonUtils.jsonString2Obj(json, AlterDto.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String alertName = SEND_ALERT_MSG_ALERT_NAME_YACE + sdf.format(new Date());
        alterDto.setAlertName(alertName);
        String orderSerialNo = "1018810650100" + sdf.format(new Date()) + new Random().nextInt(99999) + new Random().nextInt(99999) + new Random().nextInt(99999) + new Random().nextInt(99999) + new Random().nextInt(99999) + new Random().nextInt(99999);
        alterDto.setOrderSerialNo(orderSerialNo);
        alterDto.setAlertTimes(1);
        CollectorRegistry registry = new CollectorRegistry(Boolean.TRUE);
        try {
            registry.clear();
            AlterCollector requests = new AlterCollector(alterDto, String.valueOf(1));
            registry.register(requests);
            String alertLevel = org.apache.commons.lang3.StringUtils.defaultIfEmpty(alterDto.getAlertLevel().name(), "null") ;
            String errorCode = org.apache.commons.lang3.StringUtils.defaultIfEmpty(alterDto.getErrorCode().name(), "null") ;
            Map<String, String> groupingKey = new HashMap<>();
            groupingKey.put("instance", alterDto.getJob());
            groupingKey.put("alertLevel", alertLevel);
            groupingKey.put("errorCode", errorCode);
            pushgateway.pushAdd(registry, orderSerialNo, groupingKey);
        }catch (Exception e){
            e.printStackTrace();
            registry.clear();
        }
        return "success";
    }

    @RequestMapping("testM/{no}/{value}")
    @GetMapping
    public String pushM(@PathVariable String no, @PathVariable String value){
        String log = "{\"alertName\":\"交易中心_还原失败\",\"alertSource\":\"电子保函\",\"alertArea\":\"kashi\",\"alertType\":\"TRADE_CENTER\",\"errorCode\":\"TC00030\",\"content\":\"123\",\"traceId\":\"08277fdd-1328-4503-be99-065bbfd246df\",\"orderSerialNo\":\"orderSeriaNo-123456\",\"policyNo\":\"policyNo-123456\",\"orderNo\":\"orderNo-123456\",\"alertTime\":\"2021-02-25 14:20:01\",\"alertTimes\":1,\"alertLevel\":\"HIGH\",\"alertIp\":\"gbj_test01/172.16.76.69\",\"application\":\"TC_SERVICE\",\"requestUrl\":\"\",\"requestBody\":\"<?xml version=\\\"1.0\\\" encoding=\\\"utf-8\\\"?><root><Sign>95ad7499fa1c0769dbaa5e247b597830</Sign><body><OrderInfos><OrderInfo><OrderNo>5c1acc12-5ee3-4e51-acb3-d1bfe87c3cdf</OrderNo></OrderInfo></OrderInfos></body></root>\",\"responseBody\":\"1234\",\"result\":\"\",\"tradeCode\":\"\",\"requester\":\"\",\"receiver\":\"公共资源交易中心\"}\n" +
            "\n";
        System.out.println("开始发送value：-----" + 1);
        String json = "{\"alertSource\":\"probe\",\"alertArea\":\"kashi-ceshi\",\"errorCode\":\"TC00002\",\"traceId\":\"\",\"orderSerialNo\":\"\",\"policyNo\":\"\",\"orderNo\":\"\",\"alertTime\":\"\",\"alertTimes\":1,\"alertLevel\":\"SEVERE\",\"requestBody\":\"测试数据\",\"responseBody\":\"测试数据\",\"cityCode\":\"650100\",\"cityName\":\"测试\"}";
        AlterDto alterDto = JacksonUtils.jsonString2Obj(json, AlterDto.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String alertName = SEND_ALERT_MSG_ALERT_NAME_YACE + sdf.format(new Date());
        alterDto.setAlertName(alertName);
        alterDto.setOrderSerialNo(no);
        alterDto.setAlertTimes(1);
        CollectorRegistry registry = new CollectorRegistry(Boolean.TRUE);
        try {
            registry.clear();
            AlterCollector requests = new AlterCollector(alterDto, String.valueOf(value));
            registry.register(requests);
            String alertLevel = org.apache.commons.lang3.StringUtils.defaultIfEmpty(alterDto.getAlertLevel().name(), "null") ;
            String errorCode = org.apache.commons.lang3.StringUtils.defaultIfEmpty(alterDto.getErrorCode().name(), "null") ;
            Map<String, String> groupingKey = new HashMap<>();
            groupingKey.put("instance", alterDto.getJob());
            groupingKey.put("alertLevel", alertLevel);
            groupingKey.put("errorCode", errorCode);
            pushgateway.pushAdd(registry, no, groupingKey);
        }catch (Exception e){
            e.printStackTrace();
            registry.clear();
        }
        return "success";
    }

    @RequestMapping("delete/{no}")
    @GetMapping
    public String delete(@PathVariable String no){
        try {
            Map<String, String> groupingKey = new HashMap<>();
            groupingKey.put("instance", no);
            groupingKey.put("alertLevel", "SEVERE");
            groupingKey.put("errorCode", "TC00002");
            pushgateway.delete(no, groupingKey);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }


}
