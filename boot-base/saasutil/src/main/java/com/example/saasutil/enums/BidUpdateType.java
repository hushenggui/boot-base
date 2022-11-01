package com.example.saasutil.enums;

public enum BidUpdateType {
  /**
   * 更新投标有效期
   */
  TENDER_DAY(0),
  /**
   * 更新项目类型
   */
  PROJECT_TYPE(1);

  private Integer type;

  BidUpdateType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }
}
