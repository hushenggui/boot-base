package com.example.saasutil.enums;

public enum BusType {

  ORDER_REFUND("退费"),
  POLICY_REFUND("退保"),
  ORDER_CANCEL("取消");

  private String type;

  BusType(String type) {
  }

  public String getType() {
    return type;
  }
}
