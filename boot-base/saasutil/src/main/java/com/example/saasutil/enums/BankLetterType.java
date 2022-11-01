package com.example.saasutil.enums;

/**
 * 银行开函类型
 */
public enum BankLetterType {
  /**
   * 直开式
   */
  DIRECT_DRIVE("1"),

  /**
   * 分离式
   */
  SEPARATE("2");

  private String type;

  BankLetterType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public static BankLetterType convertToEnum(String type){
    switch (type){
      case "1":
        return BankLetterType.DIRECT_DRIVE;
      case "2":
        return BankLetterType.SEPARATE;
      default:
        return BankLetterType.DIRECT_DRIVE;
    }
  }
}
