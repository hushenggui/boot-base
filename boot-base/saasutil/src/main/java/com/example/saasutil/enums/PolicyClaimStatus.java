package com.example.saasutil.enums;

/**
 * 理赔状态
 */
public enum PolicyClaimStatus {

  /**
   * 已退保
   */
  CLOSE(0),
  /**
   * 等待理赔
   */
  WAIT(1),
  /**
   * 已理赔
   */
  CLAIM(2),
  /**
   * 受理失败
   */
  CLAIM_FAIL(3),
  /**
   * 处理中
   */
  CLAIM_DEALING(4),
  /**
   * 理赔完成
   */
  CLAIM_COMPLETED(5)
  ;

  Integer status;
  PolicyClaimStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }
}
