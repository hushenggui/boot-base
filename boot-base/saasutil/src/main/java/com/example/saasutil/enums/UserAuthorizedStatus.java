package com.example.saasutil.enums;

/**
 *
 */
public enum UserAuthorizedStatus {
  //待审核
  WAIT(0),
  //审核通过
  PASS(1),
  //审核失败
  FAILED(2),
  //已过期
  EXPIRED(3),
  //已失效
  FAILURE(4)
  ;

  private Integer status;

  UserAuthorizedStatus(Integer status) {
    this.status = status;
  }
}
