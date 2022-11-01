package com.example.saasutil.enums;

/**
 * 保单状态
 */
public enum PolicyStatus {

  /**
   * 已退保
   */
  CLOSE(0),
  /**
   * 未生效
   */
  NOT_ACTIVE(1),
  /**
   * 已生效
   */
  ACTIVE(2),
  /**
   * 已过期
   */
  EXPIRE(3),

  ;

  Integer status;
  PolicyStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }
}
