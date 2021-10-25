package com.example.pushgateway.config;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.pushgateway.dto.AlterDto;
import com.example.pushgateway.utils.BeanTool;
import com.example.pushgateway.utils.UUIDGenUtil;
import com.google.gson.Gson;
import io.prometheus.client.Collector;
import io.prometheus.client.CounterMetricFamily;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import org.springframework.data.util.Pair;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author: huacailiang
 * @date: 2021/2/4
 * @description:
 **/
@NoArgsConstructor
public class AlterCollector extends Collector {

  private AlterDto alterDto;
  private int value;

  public AlterCollector(AlterDto alterDto, String value) {
    this.alterDto = alterDto;
    this.value = Integer.valueOf(value);
  }

/*  public List<MetricFamilySamples> collect() {
    String gauge = "SaaS";
    List<MetricFamilySamples> mfs = new ArrayList<>();
    CounterMetricFamily labeledGauge = new CounterMetricFamily(gauge, "help", Arrays.asList("application", "detailInfo", "alertSendInfo", "source", "alertName", "alertLevel"));
    String orderSerialNo = StringUtils.defaultIfEmpty(alterDto.getOrderSerialNo(), "null") ;
    String orderNo = StringUtils.defaultIfEmpty(alterDto.getOrderNo(), "null") ;
    String policyNo = StringUtils.defaultIfEmpty(alterDto.getPolicyNo(), "null") ;
    String alertName = StringUtils.defaultIfEmpty(alterDto.getErrorCode().name(), "null") ;
    String alertLevel = StringUtils.defaultIfEmpty(alterDto.getAlertLevel().name(), "null") ;
    HashMap hashMap = new HashMap();
    hashMap.put("orderSerialNo", orderSerialNo);
    hashMap.put("orderNo", orderNo);
    hashMap.put("alertLevel", alertLevel);
    hashMap.put("alertName", alertName);
    hashMap.put("policyNo", policyNo);
    Gson gson = new Gson();
    String detailInfo = gson.toJson(hashMap);
    //邮件信息
    HashMap hashMapSend = new HashMap();
    HashMap hashMapParam  = new HashMap();
    hashMapParam.put("alertNo", UUID.randomUUID().toString());
    hashMapParam.put("alertSource", alterDto.getAlertSource());
    hashMapParam.put("nodeCode", alterDto.getErrorCode().getAlertName());
    hashMapParam.put("areaName", "喀什");
    hashMapParam.put("orderNo", alterDto.getOrderNo());
    hashMapParam.put("orderSerialNo", alterDto.getOrderSerialNo());
    hashMapParam.put("policyNo", alterDto.getPolicyNo());
    hashMapParam.put("requestUrl", alterDto.getRequestUrl());
    hashMapParam.put("receiver", alterDto.getReceiver());
    hashMapParam.put("responseContent", alterDto.getResponseBody());


    hashMapSend.put("param", gson.toJson(hashMapParam));
    hashMapSend.put("source", alterDto.getAlertArea());
    hashMapSend.put("code", "EM000001");
    String alertSendInfo = gson.toJson(hashMapSend);
    labeledGauge.addMetric(Arrays.asList("SaaS", detailInfo, alertSendInfo, alterDto.getAlertArea(), alertName, alertLevel), value );
    mfs.add(labeledGauge);
    return mfs;
  }*/

  @Override
  public List<MetricFamilySamples> collect() {
    String gauge = "SaaS";
    List<MetricFamilySamples> mfs = new ArrayList<>();
    Pair<List<String>, List<String>> alertMap = collectorMetric(alterDto, "emailCode", "pushGatewayAddress", null);
    CounterMetricFamily labeledGauge = new CounterMetricFamily(gauge, "help", alertMap.getFirst());
    int alert = alterDto.getAlertTimes() > 0 ? alterDto.getAlertTimes() : -1;
    labeledGauge.addMetric(alertMap.getSecond(), value);
    mfs.add(labeledGauge);
    return mfs;
  }


  public static Pair<List<String>, List<String>> collectorMetric(AlterDto alterDto, String emailCode,  String pushGatewayAddress, List<String> prometheusLabels) {
    Map<String, Object> alterMap = BeanTool.toTreeMap(alterDto);
    List<String> labels = new ArrayList<>();
    List<String> values = new ArrayList<>();
    if (alterMap.isEmpty()) {
      return Pair.of(labels, values);
    }
    if(!CollectionUtils.isEmpty(prometheusLabels)){
      alterMap.forEach((key, value) -> {
        if(prometheusLabels.contains(key)){
          labels.add(key);
          values.add(value.toString());
        }
      });
    }else{
      alterMap.forEach((key, value) -> {
        if(!ObjectUtils.isEmpty(value)){
          labels.add(key);
          values.add(value.toString());
        }
      });
    }

    labels.add("instance");
    values.add(alterDto.getJob());
/*    labels.add("detailInfo");
    values.add(alterDto.getTraceId());

    labels.add("alertArea");
    values.add(alterDto.getAlertArea());

    labels.add("instance");
    values.add(alterDto.getJob());

    labels.add("requestBody");
    values.add(alterDto.getRequestBody());

    labels.add("responseBody");
    values.add(alterDto.getResponseBody());

    labels.add("emailCode");
    values.add(emailCode);

    labels.add("alertName");
    values.add(alterDto.getAlertName());

    labels.add("cityCode");
    values.add(alterDto.getCityCode());

    labels.add("pushGatewayAddress");
    values.add(pushGatewayAddress);
    如果没有traceId  补充一个
    if(!labels.contains("traceId")){
      labels.add("traceId");
      values.add(UUIDGenUtil.createUUID());
    }*/

    //如果没有traceId  补充一个
    if(!labels.contains("traceId")){
      labels.add("traceId");
      values.add(UUIDGenUtil.createUUID());
    }
    return Pair.of(labels, values);
  }

  public static void main(String[] args) {
    BigDecimal c = new BigDecimal("0");
    System.out.println(c.compareTo(new BigDecimal("-1")));
  }

}
