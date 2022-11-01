package com.example.saasutil.enums;

/**
 * 发票状态
 */
public enum InvoiceStatus {

  /**
   * 已作废
   */
  CLOSE(0),
  /**
   * 未开票
   */
  NO(1),
  /**
   * 已开票
   */
  HAVE(2),
  ;

  private Integer status;
  InvoiceStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }
}
