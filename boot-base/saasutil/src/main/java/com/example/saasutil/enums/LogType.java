package com.example.saasutil.enums;

/**
 * @Description: 日志类型
 */
public enum LogType {

  /**
   * 订单日志
   */
  ORDER(0),

  /**
   * 保单日志
   */
  POLICY(1),

  /**
   * 批改单日志
   */
  REFUND(2),

  /**
   * 发票日志
   */
  RECEIPT(3),

  /**
   * 理赔日志
   */
  CLAIM(4),

  /**
   * 询问日志
   */
  QUERY(5),
  /**
   * 数据链日志
   */
  CHAIN(6),
  ;
  private Integer type;

  LogType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }
}