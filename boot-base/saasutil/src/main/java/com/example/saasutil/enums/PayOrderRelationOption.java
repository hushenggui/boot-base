package com.example.saasutil.enums;

public enum PayOrderRelationOption {
  IS_BASIC(0),
  NOT_BASIC(1),
  REFUND(2),
  REFUND_WITH_BANK_CODE(3),
  REFUND_EXCHANGE(5);

  Integer option;
  PayOrderRelationOption(Integer option) {
    this.option = option;
  }
  Integer getOption() {
    return option;
  }
}
