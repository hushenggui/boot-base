package com.example.saasutil.enums;

public enum PaymentNode {

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
  /**
   * 保单接口调用失败
   */
  POLICY_CALL_FAIL(3),
  /**
   * 保单缴费通知保险公司审核失败
   */
  POLICY_NOTICE_FAIL(4),
  /**
   * 保单缴费通知成功
   */
  POLICY_NOTICE_SUCCESS(5),

  ;

  PaymentNode(Integer status) {
    this.status = status;
  }

  Integer status;
  public Integer getStatus() {
    return status;
  }
  public void setStatus() {
    this.status = status;
  }
}
