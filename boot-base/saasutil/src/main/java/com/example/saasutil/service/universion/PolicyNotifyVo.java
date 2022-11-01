package com.example.saasutil.service.universion;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: saas
 * @description: 保单回执vo
 * @author: hushenggui
 * @create: 2021-09-13 15:47
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PolicyNotifyVo implements Serializable {
  private static final long serialVersionUID = 1575081757675577509L;

  /**
   * 订单编号
   */
  private String orderId;

  /**
   * 保单号
   */
  private String policyNo;

  /**
   * 附件id
   */
  private String fileId;

  /**
   * 状态
   */
  private String type;

  /**
   * 承包单位
   */
  private String company;

  /**
   * 承保单位联系方式
   */
  private String comPhone;

  /**
   * 保险期限
   */
  private String insurTime;

  /**
   * 状态
   */
  private String status;

  /**
   * 实际支付金额
   */
  private BigDecimal premium;
  /**
   * 备注
   */
  private String remark;

  /**
   * 银行账号
   */
  private String accNo;

  /**
   * 银行账户
   */
  private String accName;

  /**
   * 银行名称
   */
  private String bankName;

  /**
   * 支付类型
   */
  private String payType;

  /**
   * 支付时间
   */
  private String payTime;

  /**
   * 银行流水号
   */
  private String payId;

  /**
   * 提案编号/预 投保单号
   */
  private String proposalNo;

}
