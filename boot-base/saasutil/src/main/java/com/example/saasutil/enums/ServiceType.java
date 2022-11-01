package com.example.saasutil.enums;

/**
 * 服务类型
 */
public enum ServiceType {
  /**
   * 支付问题
   */
  PAYMENT_QUESTION(0),
  /**
   * 退保问题
   */
  REFUND_QUESTION(1),
  /**
   * 订单问题
   */
  ORDER_QUESTION(2);

  Integer status;
  ServiceType(Integer status) {
    this.status = status;
  }
}
