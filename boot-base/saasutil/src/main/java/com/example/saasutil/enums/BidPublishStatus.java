package com.example.saasutil.enums;

/**
 * 发布状态枚举
 * @Author OK
 * @Date 2022/5/13 17:07
 */
public enum BidPublishStatus {

  /**
   * 待发布
   */
  NOT_PUBLISH(0),
  /**
   * 已发布
   */
  PUBLISH(1);

  Integer status;
  BidPublishStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }
}
