package com.example.saasutil.enums;

public enum RefundType {
  /**
   * 系统退保
   */
  SYSTEM(0),
  /**
   * 用户自主发起退保
   */
  USER(1)
  ;

  Integer type;
  RefundType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }
}
