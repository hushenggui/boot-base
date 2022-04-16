package com.example.pushgateway.dto;

import com.example.pushgateway.enums.AlertLevel;
import com.example.pushgateway.enums.AlertName;
import com.example.pushgateway.enums.AlertType;
import com.example.pushgateway.enums.ApplicationType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Collections;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.net.InetAddress;
import java.util.Date;
import org.springframework.util.StringUtils;

/**
 * @author: huacailiang
 * @date: 2021/2/3
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class AlterDto implements java.io.Serializable {

  public AlterDto(String alertName, String alertArea, AlertType alertType, AlertName errorCode, String content,
                  String traceId, String orderSerialNo, String policyNo, String orderNo, AlertLevel alertLevel,
                  ApplicationType application, String requestUrl, String requestBody, String responseBody,
                  String result, String tradeCode, String requester, String receiver, Integer alertTimes) {
    this.alertName = alertName;
    this.alertArea = alertArea;
    this.alertType = alertType;
    this.errorCode = errorCode;
    this.content = content;
    this.traceId = traceId;
    this.alertLevel = alertLevel;
    this.application = application;
    this.requestUrl = requestUrl;
    this.requestBody = requestBody;
    this.responseBody = responseBody;
    this.result = result;
    this.tradeCode = tradeCode;
    this.requester = requester;
    this.receiver = receiver;
    this.orderSerialNo = orderSerialNo;
    this.policyNo = policyNo;
    this.orderNo = orderNo;
    try {
      this.alertIp = InetAddress.getLocalHost().toString();
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
    if(!ObjectUtils.isEmpty(alertTimes)) {
      this.alertTimes = alertTimes;
    }
  }
  //告警名称
  private String alertName;
  //告警来源
  private String alertSource = "电子保函";
  //地区
  private String alertArea;
  //错误类型
  private AlertType alertType;
  //错误编码
  private AlertName errorCode;
  //错误内容
  private String content;
  //错误唯一主键
  private String traceId;
  //发生时间
  private String orderSerialNo;
  //保单号
  private String policyNo;
  //业务流水号
  private String orderNo;
  //发生时间
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
  private Date alertTime = new Date();
  //发生次数（默认1）
  private Integer alertTimes = 0;
  //告警级别
  private AlertLevel alertLevel;
  //ip地址
  private String alertIp;
  //应用
  private ApplicationType application;
  //请求地址
  private String requestUrl;
  //请求体
  private String requestBody;
  //返回体
  private String responseBody;
  //返回结果
  private String result;
  //支付流水号
  private String tradeCode;
  //发起人
  private String requester;
  //接收人
  private String receiver;
  private String cityCode;
  private String cityName;


  public  String getJob(){
    String job = this.getOrderSerialNo();
    if(StringUtils.isEmpty(job)){
      job = this.getOrderNo();
    }
    if(StringUtils.isEmpty(job)){
      job = this.getPolicyNo();
    }
    if(StringUtils.isEmpty(job)){
      job = String.valueOf(System.currentTimeMillis());
    }
    job = job;
    return job;
  }


  public static void main(String[] args) {
    AlterDto alterDto = new AlterDto();
    Optional.ofNullable(alterDto).map(alterDto::getJob).orElse(new AlterDto());

  }

  private AlterDto getJob(AlterDto alterDto) {
    return alterDto;
  }
}
