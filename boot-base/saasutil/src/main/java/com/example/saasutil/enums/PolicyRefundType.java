package com.example.saasutil.enums;

/**
 * 退保类型
 */
public enum PolicyRefundType {
  /**
   * 批退
   */
  BATCH_REFUND(0),
  /**
   * 批增
   */
  BATCH_PLUS(1),
  /**
   * 批减
   */
  BATCH_MINUS(2);

  Integer type;
  PolicyRefundType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }
}
