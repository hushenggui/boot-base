package com.example.saasutil.enums;

public enum AuditStatus {

  WAIT("待审核"),
  SUCCESS("审核成功"),
  FAIL("审核失败");

  private String name;

  AuditStatus(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
