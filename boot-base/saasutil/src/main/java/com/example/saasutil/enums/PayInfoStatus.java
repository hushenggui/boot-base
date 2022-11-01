package com.example.saasutil.enums;

public enum PayInfoStatus {
  WAIT(0),
  FINISH(1)
  ;

  Integer status;
  PayInfoStatus(Integer status) {
    this.status = status;
  }
  Integer getStatus() {
    return status;
  }
}
