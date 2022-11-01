package com.example.saasutil.enums;

public enum SmsSignName {

  GONG_BAO_NET("工保网经纪"),
  GONG_BAO_TECH("工保科技"),
  ELECTRON_GUARANTEE_SERVICE_PLATFORM("电子保函服务平台")
  ;

  private String signName;

  SmsSignName(String signName) {
    this.signName = signName;
  }

  public String getSignName() {
    return signName;
  }
}
