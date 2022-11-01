package com.example.saasutil.enums;


public enum SubjectType {
  /**
   * 企业
   */
  ENTERPRISE(0),
  /**
   * 个人
   */
  PERSON(1);

  private Integer type;

  SubjectType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }


}
