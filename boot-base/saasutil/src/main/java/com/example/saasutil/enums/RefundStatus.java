package com.example.saasutil.enums;

/**
 * 退保单状态
 */
public enum RefundStatus {
  /**
   * 待审核
   */
  WAIT(0),
  /**
   * 待完善退费信息,1、非网银的 2、有支付平台的由交易中心发起的
   */
  FILL_ACCOUNT(1),
  /**
   * 审核未通过
   */
  CHECK_FAIL(2),
  /**
   * 待退款
   */
  REFUND(3),
  /**
   * 退保完成
   */
  FINISH(4)
  ;

  Integer status;
  RefundStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }
}
