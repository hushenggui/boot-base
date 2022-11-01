package com.example.saasutil.enums;

public enum PayTradeInfoStatus {
  WAIT(0),
  FINISH(1),
  SUSPICIOUS(2),
  FAIL(3)
  ;

  Integer status;
  PayTradeInfoStatus(Integer status) {
    this.status = status;
  }
  Integer getStatus() {
    return status;
  }
}
