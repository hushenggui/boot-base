package com.example.saasutil.enums;

public enum YongyouType {
  /**
   * 投保成功通知
   */
  YONGYOU_POLICY(0),
  /**
   * 退保成功通知
   */
  YONGYOU_QUIT_SUCCESS(1),
  /**
   * 批改成功通知
   */
  YONGYOU_REVERT(2),
  /**
   * 理赔成功通知
   */
  YONGYOU_CLAIM(3),
  /**
   * 退保申请
   */
  YONGYOU_QUIT(4);

  private Integer type;
  YongyouType(Integer type) {
    this.type = type;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}
