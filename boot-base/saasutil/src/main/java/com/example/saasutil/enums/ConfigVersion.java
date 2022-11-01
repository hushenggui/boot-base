package com.example.saasutil.enums;

/**
 * @author: huacailiang
 * @date: 2021/12/14
 * @description:
 **/
public enum ConfigVersion {
  V1("老版本", "V1"),
  V2("新版本", "V2"),
  V3("新版本带对象", "V3");

  private String name;
  private String code;

  ConfigVersion(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }
}
