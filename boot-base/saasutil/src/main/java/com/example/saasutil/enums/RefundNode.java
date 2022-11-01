package com.example.saasutil.enums;

/**
 * 退保单节点
 */
public enum RefundNode {

  /**
   * 待审核
   */
  WAIT(0),
  /**
   * 待完善退费信息
   */
  FILL_ACCOUNT(1),
  /**
   * 调用保险公司接口异常
   */
  POLICY_REFUND_CALL_FAIL(2),
  /**
   * 审核未通过
   */
  POLICY_REFUND_NOTICE_FAIL(3),
  /**
   * 待退款
   */
  REFUND(4),
  /**
   * 保险公司已退款
   */
  REFUNDED(5),
  /**
   * 通知交易中接口调用失败
   */
  CENTER_CALL_FAIL(6),
  /**
   * 通知交易中心失败
   */
  CENTER_NOTICE_FAIL(7),
  /**
   * 退保完成
   */
  FINISH(8),
  /**
   * 通知交易中心退保成功
   */
  GGZY_REFUND_SUCCESS(9),

  /**
   * 通知交易中心退保失败
   */
  GGZY_REFUND_FAIL(10);
  ;

  RefundNode(Integer status) {
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
