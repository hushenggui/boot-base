package com.example.saasutil.service.pay.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"assoSerial","bankNo","channelAccountCode","channelCode","channelName","channelSerNo","createTime","feeAmount","openBranch",
        "oppAccount","oppAccountName","orderNo","payAccount","payAccountName","payAmount","payFinishTime","payNo","payStatus","remark","tradeAmount","tradeState","transCode"})
public class PaymentNoticeReq {

  //@ApiModelProperty(value = "交易码", example = "N000001")
  private String transCode;
  // 支付流水号
  //@ApiModelProperty(value = "支付流水号", example = "T0000000000001")
  private String payNo;

  //订单号
  //@ApiModelProperty(value = "订单号", example = "T0000000000001")
  private String orderNo;

  // 创建时间
  //@ApiModelProperty(value = "创建时间", example = "2020110311080000")
  private String createTime;
  // 支付渠道
  //@ApiModelProperty(value = "支付渠道", example = "3050001")
  private String channelCode;

  //@ApiModelProperty(value = "渠道账号编码", example = "3050001")
  private String channelAccountCode;
  // 支付渠道
  //@ApiModelProperty(value = "支付渠道", example = "民生银行")
  private String channelName;
  // 银行流水号
  //@ApiModelProperty(value = "银行流水号", example = "s00000000000001")
  private String channelSerNo;
  // 支付时间
  //@ApiModelProperty(value = "支付时间", example = "2020110311080000")
  private String payFinishTime;
  // 账簿名称
  //@ApiModelProperty(value = "账簿名称", example = "666666666666666666")
  private String payAccount;
  // 账簿账号
  //@ApiModelProperty(value = "账簿账号", example = "杭州工保科技")
  private String payAccountName;

  // 付款
  //@ApiModelProperty(value = "付款", example = "张三")
  private String oppAccountName;
  // 付款人账号
  //@ApiModelProperty(value = "付款人账号", example = "666666666666666")
  private String oppAccount;
  // 交易金额（元）
  //@ApiModelProperty(value = "交易金额（元）", example = "0.00")
  private BigDecimal payAmount;
  //@ApiModelProperty(value = "支付状态", example = "00")
  private String payStatus;
  //@ApiModelProperty(value = "支付备注", example = "XXXXXX")
  private String remark;
  //@ApiModelProperty(value = "手续费", example = "0.00")
  private BigDecimal feeAmount;
  //银行编号
  private String bankNo;
  //大额行号
  private String openBranch;

  private String assoSerial;

  private BigDecimal tradeAmount;

  /**交易状态（00待支付；01成功；02失败；03处理中；04关闭/取消）
   * WAIT 、SUCCESS、FAIL, PROCESSING, CLOSED*/
  private String tradeState;
}
