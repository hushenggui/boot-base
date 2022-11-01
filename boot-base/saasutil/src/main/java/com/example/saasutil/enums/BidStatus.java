package com.example.saasutil.enums;

/**
 * 是否开标
 * @Author OK
 * @Date 2022/5/13 16:44
 */
public enum BidStatus {

  /**
   * 未生效
   */
  NOT_ACTIVE(0),
  /**
   * 已生效
   */
  ACTIVE(1);

  Integer status;
  BidStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }
}
