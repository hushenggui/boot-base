package com.example.saasutil.enums;

/**
 *
 * @author yumingxing
 */
public enum TbWhiteOpenStatus {
  //白名单
  WHITE(0),
  //黑名单
  BLACK(1)
  ;

  private Integer tbStatus;

  TbWhiteOpenStatus(Integer tbStatus) {
    this.tbStatus = tbStatus;
  }
}
