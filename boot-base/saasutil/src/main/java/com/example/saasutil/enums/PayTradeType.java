package com.example.saasutil.enums;

public enum PayTradeType {
  //转入
  IN(0),
  //转出
  OUT(1),
  //退费
  REFUND(2),
  //退汇 转入
  REEXCHANGE(3),
  //退汇 转出 保险
  REEXCHANGE_INS(4),
  //退汇 转出 用户
  REEXCHANGE_USER(5),
  PROFIT_SHARING(6),
  ;
  Integer status;
  PayTradeType(Integer status) {
    this.status = status;
  }
  Integer getStatus() {
    return status;
  }
}
