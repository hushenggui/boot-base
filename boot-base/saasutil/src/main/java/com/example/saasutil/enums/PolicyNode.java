package com.example.saasutil.enums;

/**
 * 保单程序节点
 */
public enum PolicyNode {

  /**
   * 已退保
   */
  CLOSE(0),
  /**
   * 保险公司已出单待通知交易中心
   */
  NOT_ACTIVE(1),
  /**
   * 待批改（还原）
   */
  WAIT_REVERT(2),
  /**
   * 调用还原接口失败
   */
  POLICY_REVERT_CALL_FAIL(3),
  /**
   * 保险公司批改（还原）失败
   */
  POLICY_REVERT_NOTICE_FAIL(4),
  /**
   * 保险公司批改（还原）成功
   */
  ACTIVE(5),
  /**
   * 已过期
   */
  EXPIRE(6),

  /**
   * 公共资源投保通知成功
   */
  GGZY_INSURE_SUCCESS(7),

  /**
   * 公共资源批改通知成功
   */
  GGZY_REVERT_SUCCESS(8),

  /**
   * 公共资源退保通知成功
   */
  GGZY_REFUDN_SUCCESS(9),


  /**
   * 公共资源投保通知失败
   */
  GGZY_INSURE_FAIL(10),

  /**
   * 公共资源批改通知失败
   */
  GGZY_REVERT_FAIL(11),

  /**
   * 公共资源退保通知失败
   */
  GGZY_REFUDN_FAIL(12);

  ;

  PolicyNode(Integer status) {
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
