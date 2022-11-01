package com.example.saasutil.enums;

/**
 * 商品状态
 */
public enum GoodsStatus {

  /**
   * 在售
   */
  ONLINE(0),
  /**
   * 停售
   */
  OFFLINE(1);

  GoodsStatus(Integer status) {
    this.status = status;
  }

  Integer status;

  public Integer getStatus() {
    return status;
  }

  public void setStatus() {
    this.status = status;
  }
}
