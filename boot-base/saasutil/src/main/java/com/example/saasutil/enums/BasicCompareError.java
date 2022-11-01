package com.example.saasutil.enums;

public enum BasicCompareError {

  REFUND_FAIL("无退费必要条件：开户行或支行信息"),
  BASIC_ACCOUNT_NAME_COMPARE_FAIL("基本户户名不匹配"),
  BASIC_BANK_ACCOUNT_COMPARE_FAIL("基本户账号不匹配"),
  PAY_TRADE_INFO_ORDER_STATUS_PAY_TIME_MEMO_COMPARE_FAIL("支付状态、支付时间、附言不匹配"),
  PAY_TRADE_INFO_ORDER_FINISH_AND_REFUND("交易订单已完成，重复支付，平台发起退费"),
  PAY_TRADE_INFO_ORDER_FINISH_AND_REFUND_FAIL("交易订单已完成，重复支付，平台发起退费，无退费必要条件：开户行或支行信息"),
  PAY_TRADE_INFO_ORDER_STATUS_PAY_TIME_ACCOUNT_PREMIUM_COMPARE_FAIL("支付状态、支付时间、付款人、金额不匹配"),
  PAY_TRADE_INFO_ORDER_MULTI_FAIL("多笔关联疑似交易订单"),
  NO_PAY_TRADE_INFO_ORDER_EMPTY("无关联支付交易订单"),
  PAY_PLATFORM_TRANSFER_FAIL("支付平台发起转账失败"),
  PAY_PLATFORM_REFUND_FAIL("支付平台发起转账失败"),
  NO_PAY_TRADE_INFO_ORDER_EMPTY_AND_REFUND("无关联支付交易订单，平台发起退费"),
  NOT_BASIC_AND_REFUND("基本户匹配失败，平台发起退费"),
  NOT_BASIC_AND_REFUND_FAIL("基本户匹配失败，平台发起退费，无退费必要条件：开户行或支行信息"),
  NO_PAY_TRADE_INFO_ORDER_EMPTY_AND_REFUND_FAIL("无关联支付交易订单，平台发起退费，无退费必要条件：开户行或支行信息"),
  ORDINARY_NAME_LIKE_AND_RELATION("一般户需求，户名、金额一致，多笔交易单"),
  ORDINARY_NAME_LIKE_AND_TRANSFER_FAIL("一般户需求，户名、金额一致，支付平台转账失败"),
  ORDINARY_NAME_NOT_LIKE_AND_REFUND("一般户需求，户名不一致平台发起退费"),
  ORDINARY_NAME_NOT_LIKE_AND_REFUND_FAIL("一般户需求，户名不一致发起退费，无退费必要条件：开户行或支行信息"),
  ;

  private String errorInfo;
  BasicCompareError(String errorInfo) {
    this.errorInfo = errorInfo;
  }

  public String getErrorInfo() {
    return errorInfo;
  }
}
