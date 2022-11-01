package com.example.saasutil.enums;

public enum SuccessOrFail {

  SUCCESS("0"),
  FAIL("500");

  private String value;

  SuccessOrFail(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
