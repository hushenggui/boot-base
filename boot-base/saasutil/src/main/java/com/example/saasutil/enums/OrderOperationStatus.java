package com.example.saasutil.enums;

/**
 * 客服订单状态
 */
public enum OrderOperationStatus {

  WAIT(0),
  PROCESSING(1),
  PAUSE(2),
  PROCESSED(3),
  CLOSE(4)
  ;

  Integer status;
  OrderOperationStatus(Integer status) {
    this.status = status;
  }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
