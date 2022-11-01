package com.example.saasutil.enums;

/**
 * 保单状态
 */
public enum UnderwriteType {


  AUTO("自动"),

  MANUAL("人工"),

  ;

  String name;
  UnderwriteType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
