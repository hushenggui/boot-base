package com.example.saasutil.enums;

/**
 * 支付状态
 */
public enum PaymentStatus {

  /**
   * 支付异常
   */
  CLOSE(0),
  /**
   * 待支付
   */
  PAY(1),
  /**
   * 已支付
   */
  PAYED(2),

  ;

  private Integer status;
  PaymentStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }
}
