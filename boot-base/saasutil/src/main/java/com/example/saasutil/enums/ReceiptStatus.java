package com.example.saasutil.enums;

/**
 * 退保原因（交易中心发起） Created by sunwen on 2019/4/4.
 */
public enum ReceiptStatus {

  /**
   * 待开票
   */
  WAIT(0),
  /**
   * 已申请
   */
  ACCEPT(1),
  /**
   * 已开票
   */
  SUCCESS(2);

  private Integer status;

  ReceiptStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }
}
