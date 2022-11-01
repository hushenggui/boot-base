package com.example.saasutil.enums;

/**
 * 标段审核状态
 */
public enum BidAuditStatus {

  /**
   * 待审核
   */
  WAIT(0),
  /**
   * 审核通过
   */
  SUCCESS(1),
  /**
   * 审核未通过
   */
  FAIL(2);
  private Integer status;

  BidAuditStatus(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }

  public static String getContemt(Integer status){
    switch (status){
      case 0:
        return "待审核";
      case 1:
        return "审核通过";
      case 2:
        return "审核未通过";
      default:
        return "未知状态";
    }
  }
}
