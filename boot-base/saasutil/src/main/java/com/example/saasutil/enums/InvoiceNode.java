package com.example.saasutil.enums;

/**
 * 发票节点
 */
public enum InvoiceNode {

  /**
   * 已作废
   */
  CLOSE(0),
  /**
   * 未开票
   */
  NO(1),
  /**
   * 申请开票接口异常
   */
  APPLY_CALL_FAIL(2),
  /**
   * 开票申请失败
   */
  APPLY_NOTICE_FAIL(3),
  /**
   * 红票接口异常
   */
  RED_APPLY_FAIL(4),
  /**
   * 红票申请失败
   */
  RED_NOTICE_FAIL(5),
  /**
   * 申请成功
   */
  ACCEPT(6),
  /**
   * 已开票
   */
  HAVE(7);

  InvoiceNode(Integer status) {
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
