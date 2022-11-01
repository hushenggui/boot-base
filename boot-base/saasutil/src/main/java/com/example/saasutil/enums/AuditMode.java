package com.example.saasutil.enums;

public enum AuditMode {

  //普通模式
  GERENAL("0"),
  //先审核后支付
  AUDIT_BEFORE("1"),
  //先支付后审核
  AUDIT_AFTER("2");

  private String name;

  AuditMode(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
