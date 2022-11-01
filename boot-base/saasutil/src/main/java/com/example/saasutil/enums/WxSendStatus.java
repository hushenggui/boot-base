package com.example.saasutil.enums;

public enum WxSendStatus {
  /**
   * 失败
   */
  FAIL(0),
  /**
   * 成功
   */
  SUCCESS(1),
  /**
   * 发送中
   */
  SENDING(2);

  WxSendStatus(Integer status) {
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
