package com.example.saasutil.enums;

/**
 * 理赔节点
 */
public enum PolicyClaimNode {

  /**
   * 已退保
   */
  CLOSE(0),
  /**
   * 等待理赔
   */
  WAIT(1),
  /**
   * 理赔接口调用失败
   */
  POLICY_CLAIM_CALL_FAIL(2),
  /**
   * 理赔受理失败
   */
  POLICY_CLAIM_NOTICE_FAIL(3),
  /**
   * 已理赔
   */
  CLAIM(4),

  /**
   * 处理中
   */
  CLAIM_DEALING(5),
  /**
   * 理赔完成
   */
  CLAIM_COMPLETED(6)
  ;

  PolicyClaimNode(Integer status) {
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
