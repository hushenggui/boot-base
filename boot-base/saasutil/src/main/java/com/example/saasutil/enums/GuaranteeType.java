package com.example.saasutil.enums;

import java.util.Optional;

public enum GuaranteeType {

  NONE(0),
  /**
   * 保证保险
   */
  GUARANTEE(1),
  /**
   * 担保公司
   */
  COMPANY(2),
  /**
   * 银行
   */
  BANK(3)
  ;

  Integer status;
  GuaranteeType(Integer status) {
    this.status = status;
  }

  public Integer getStatus() {
    return status;
  }

  public static String getName(GuaranteeType guaranteeType) {
    if(GUARANTEE == guaranteeType) {
      return "保证保险";
    } else if(COMPANY == guaranteeType) {
      return "担保保函";
    } else if(BANK == guaranteeType) {
      return "银行保函";
    } else {
      return "保证保险";
    }
  }

  public static String getType(GuaranteeType guaranteeType) {
    if(GUARANTEE == guaranteeType) {
      return "1";
    } else if(COMPANY == guaranteeType) {
      return "2";
    } else if(BANK == guaranteeType) {
      return "3";
    } else {
      return "1";
    }
  }

  public static String getName(String  type) {
    if(type == "1") {
      return "保证保险";
    } else if(type == "2") {
      return "担保保函";
    } else if(type == "3") {
      return "银行保函";
    } else {
      return "保证保险";
    }
  }

  public static GuaranteeType valueOfType(Integer type) {
    for (GuaranteeType value : GuaranteeType.values()) {
      if (value.status.equals(type)) {
        return value;
      }
    }
    return null;
  }

}
