package com.example.pushgateway.config;

import com.example.pushgateway.dto.AlterDto;
import com.example.pushgateway.utils.BeanTool;
import com.example.pushgateway.utils.UUIDGenUtil;
import io.prometheus.client.Collector;
import io.prometheus.client.CounterMetricFamily;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import lombok.NoArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/**
 * @author: huacailiang
 * @date: 2021/2/4
 * @description:
 **/
@NoArgsConstructor
public class AlterCollectorListMore extends Collector {
  private List<AlterDto> alterDtoList;

  public AlterCollectorListMore(List<AlterDto> alterDtoList) {
    this.alterDtoList = alterDtoList;
  }

  @Override
  public List<MetricFamilySamples> collect() {
    String gauge = "SaaS";
    List<MetricFamilySamples> mfs = new ArrayList<>();
    if(!CollectionUtils.isEmpty(alterDtoList)){
      alterDtoList.forEach(alterDtos -> {
        Pair<List<String>, List<String>> alertMap = collectorMetric(alterDtos, "emailCode", "pushGatewayAddress", null);
        CounterMetricFamily labeledGauge = new CounterMetricFamily(alterDtos.getAlertSource(), "help", alertMap.getFirst());
        int alert = alterDtos.getAlertTimes() > 0 ? alterDtos.getAlertTimes() : -1;
        labeledGauge.addMetric(alertMap.getSecond(), alert);
        mfs.add(labeledGauge);
      });
    }
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
