package com.example.saasutil.enums;

public enum GuaranteeTypeEnum {


  /**
   * 投标保函
   */
  TENDER_GUARANTEE("1"),
  /**
   * 履约保函
   */
  PERFORMANCE_GUARANTEE("2");

  String type;
  GuaranteeTypeEnum(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}
