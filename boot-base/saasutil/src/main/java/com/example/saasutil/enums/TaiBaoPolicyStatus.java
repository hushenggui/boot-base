package com.example.saasutil.enums;

public enum TaiBaoPolicyStatus {
  POLICY_UNPAY(1, "待支付"),
  POLICY_SUCESS(2, "已生效"),

  ;
  private Integer code;
  private String message;

  TaiBaoPolicyStatus(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
