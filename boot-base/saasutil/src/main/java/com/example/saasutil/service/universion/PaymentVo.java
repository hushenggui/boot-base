package com.example.saasutil.service.universion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: huacailiang
 * @date: 2020/3/30
 * @description:
 **/
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class PaymentVo  implements Serializable {
  /**
   * uuid
   */
  private String id;

  /**
   * 保额
   */
  private BigDecimal amount;

  /**
   * 保费
   */
  private BigDecimal premium;

  /**
   * 最低保费
   */
  private BigDecimal minPremium;

  /**
   * 费率
   */
  private BigDecimal insuranceRate;

  /**
   * 支付类型
   */
  private String type;

  /**
   * 订单编号
   * */
  private String serialNo;

  /**
   * 支付类型0保险公司支付 1基本户支付
   */
  private String systemType;

  /**
   * 实际支付账户
   */
  private String accountName;

  /**
   * 实际支付账号
   */
  private String bankAccount;

  /**
   * 支付时间
   */
  private Date payDate;

  /**
   * 支付银行
   */
  private String bankName;

  /**
   * 支付状态
   */
  private String status;

  /**
   * 支付节点
   */
  private String node;

  /**
   * 接口信息
   */
  private String message;

  /**
   * 是否是基本户
   */
  private Boolean basic;

  /**
   * 商品附言
   */
  private String goodsDescription;

  /**
   * 保险公司代码
   */
  private String insCode;

  /**
   * 保险公司名称
   */
  private String insName;

  /**
   * 支付流水号
   */
  private String dealCode;

  /**
   * 银准交易流水号
   */
  private String tradeCode;

  /**
   * 银行备注
   */
  private String memo;

  /**
   *  投保单号，保险公司提案编号
   */
  private String proposalNo;

  /**
   * 支付金额
   */
  private BigDecimal payAmount;
  /**
   * 交易金额
   */
  private BigDecimal dealAmount;
  /**
   * 支付链接
   */
  private String payUrl;

  /**
   * 手续费
   */
  private BigDecimal brokerage;

  /**
   * 费率表id
   */
  private String insuranceSetupId;

  /**
   * 退费原因
   */
  private String refundReason;

  /**
   * 退费时间
   */
  private Date refundDate;

  /**
   * 退费手续费
   */
  private BigDecimal refundBrokerage;

  /**
   * 退费金额
   */
  private BigDecimal refundAmount;

  /**
   * 退费类型 ORIGINAL("1", "原路返回"),  OPEN("2", "开放");
   */
  private String refundType;

  private Date createDate;

  private Date updateDate;

  /**
   * 0未删除1已删 除
   */
  private Boolean delete = Boolean.FALSE;

  /**
   * 行政区划
   */
  private String cityCode;


  /**
   * 订单编号
   */
  private String orderSerialNo;

  /**
   * 保单号
   */
  private String policyNo;


  /**
   * 支付平台状态
   */
  private String payStatus;

  /**
   * 应用名
   */
  private String application;

  /**
   * 行数，自增
   */
  private Integer rowId;
}
