package com.example.saasutil.enums;

/**
 * 订单程序节点
 */
public enum OrderNode {

  /**
   * 已关闭
   */
  CLOSE(0),
  /**
   * 待投保
   */
  ORDER_WAIT(1),

  /**
   * 待风控审核
   */
  RISK_CHECK(2),
  /**
   * 风控接口调用失败
   */
  RISK_CALL_FAIL(3),
  /**
   * 风控审核失败
   */
  RISK_CHECK_NOTICE_FAIL(4),
  /**
   * 保险公司接口调用失败
   */
  INSURANCE_CHECK_CALL_FAIL(5),
  /**
   * 保险审核失败
   */
  INSURANCE_CHECK_NOTICE_FAIL(6),
  /**
   * 风控回执成功待保险审核
   */
  INSURANCE_CHECK(7),
  /**
   * 待支付
   */
  PAY_WAIT(8),
  /**
   * 用户发起支付，链接无法访问
   */
  PAY_CALL_FAIL(9),
  /**
   * 保单缴纳回执
   */
  PAY_NOTICE_FAIL(10),
  /**
   * 已支付/非基本户已支付附带保单信息
   */
  PAY_SUCCESS(11),
  /**
   * 已完成，已开标
   */
  FINISH(12),

  ;

  OrderNode(Integer status) {
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
