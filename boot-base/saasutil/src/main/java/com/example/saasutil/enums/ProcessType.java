package com.example.saasutil.enums;

/**
 * 问题类型
 */
public enum ProcessType {
  /**
   * 已支付，未出函   /  退保信息问题
   */
  PAID_NO_POLICY(0),
  /**
   * 发票问题   /  系统处理问题
   */
  INVOICE_APPLY(1),
  /**
   * 支付问题
   */
  PAYMENT(2),
  /**
   * 更换保险公司问题
   */
  REPLACE_INSURANCE(3),
  /**
   * 保费问题
   */
  POLICY_PREMIUM(4),
  /**
   * 变更地址问题
   */
  CHANGE_ADDRESS(5),
  /**
   * 重复支付，申请退费
   */
  REPEAT_PAY(6),
  /**
   * 变更跟进人
   */
  CHANGE_SERVICE(7),
  /**
   * 订单取消，申请退费
   */
  CANCEL_ORDER(8),
  /**
   * 非基本户，基本户匹配失败
   */
  BASIC_NOT_MATCH(9),
  ;

  Integer type;
  ProcessType(Integer type) {
    this.type = type;
  }
  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}
