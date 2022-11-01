package com.example.saasutil.enums;

/**
 * @author: huacailiang
 * @date: 2020/7/30
 * @description:
 **/
public enum OperatorInfoType {
  UPDATE_PROJECT_TYPE(0, "投保人选择项目类型", "交易平台未推送项目类型，用户投保时项目类型选择建设工程"),
  INSERT_TENDER_DAY(1, "投保人修改投标有效期", "交易平台推送投标有效期为%s天，用户投保时自行修改为%s天"),
  UPDATE_TENDER_DAY(2, "投保人修改投标有效期", "交易平台推送投标有效期为%s天，用户投保时自行修改为%s天"),
  APPLY_CLAIM(3, "申请理赔", "交易平台发起理赔申请"),
  POLICY(4, "交易中心发起投保申请", "交易中心发起投保申请"),
  QUIT_POLICY(5, "交易中心发起退保申请", "交易中心发起退保申请"),
  POLICY_REVERT(6, "交易中心发起项目还原", "交易中心发起项目还原"),
  WIN_BID(7, "交易中心同步中标企业", "交易中心同步中标企业"),
  PAY_NOTICE(8, "保险公司缴费成功回执", "保险公司缴费成功回执"),
  REFUND_NOTICE(9, "保险公司(担保公司)退保成功回执", "保险公司退保成功回执"),
  INSURE(10, "投标人页面点击立即投保按钮", "投标人页面点击立即投保按钮"),
  QUIT_POLICY_SELF(11, "投标人页面点击申请退保按钮", "投标人页面点击申请退保按钮"),
  INVOKE_INSURANCE_QUIT_POLICY(12, "调用保险公司退保接口", "调用保险公司退保接口"),
  INVOKE_GUARANTEE_QUIT_POLICY(13, "调用担保公司退保接口", "调用担保公司退保接口"),
  REVERT_NOTICE(14, "通知交易中心批改回执", "通知交易中心批改回执"),
  PAY_NOTICE_TO_INSURANCE(15, "通知保险公司缴费成功", "通知保险公司缴费成功"),
  PAY_NOTICE_TO_GUARANTE(16, "通知担保公司缴费成功", "通知担保公司缴费成功"),
  UPDATE_AMOUNT_AND_BID_CLOSE_TIME(17, "投保人修改保证金金额及缴费截止时间", "投标人修改保证金金额为%s，修改缴费截止时间为%s"),
  ;

  private Integer type;
  private String memo;
  private String text;

  OperatorInfoType(Integer type, String text, String memo) {
    this.type = type;
    this.text = text;
    this.memo = memo;
  }

  public Integer getType() {
    return type;
  }
  public String getMemo() {
    return memo;
  }
  public String getText() {
    return text;
  }
}
