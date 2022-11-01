package com.example.saasutil.enums;

public enum SystemType {
  /**
   * 保险公司支付
   */
  INSURANCE_PAY(0),
  /**
   * 支付平台支付
   */
  PAY_PLATFORM(1);

  private Integer type;
  SystemType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}
