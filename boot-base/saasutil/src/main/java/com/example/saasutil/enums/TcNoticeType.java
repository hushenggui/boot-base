package com.example.saasutil.enums;

/**
 * 回执类型 1 投保 2 退保
 * @author: huacailiang
 * @date: 2020/5/20
 * @description:
 **/
public enum TcNoticeType {

  APPLY("1"),
  REFUND("2"),
  CANCEL("3")
  ;


  private String type;
  TcNoticeType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
