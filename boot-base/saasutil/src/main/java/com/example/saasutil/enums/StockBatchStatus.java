package com.example.saasutil.enums;

/**
 * 发票节点
 */
public enum StockBatchStatus {

  /**
   * 未售完
   */
  NOT_SELL_OUT(0),
  /**
   * 已售完
   */
  SELL_OUT(1);

  StockBatchStatus(Integer status) {
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
