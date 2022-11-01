package com.example.saasutil.enums;

/**
 * 用户类型
 */
public enum UserType {
  //招标人
  TENDERER(0),
  //投标人,代理人
  BIDDERS(1),
  //企业用户
  ENTERPRISE(2),
  //理赔人
  CLAIM(3);

  private Integer type;

  UserType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }
}
