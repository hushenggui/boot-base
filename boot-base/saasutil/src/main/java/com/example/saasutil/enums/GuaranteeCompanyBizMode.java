package com.example.saasutil.enums;

/**
 * @author 吕林杰
 * @date 2021/11/25 13:39
 **/
public enum GuaranteeCompanyBizMode {
  //工保直连担保公司
  GB_TO_GC("1"),
  //周投保
  ZTB("2");

  private String bizMode;

  GuaranteeCompanyBizMode(String bizMode) {
    this.bizMode = bizMode;
  }

  public String getBizMode() {
    return bizMode;
  }

  public void setBizMode(String bizMode) {
    this.bizMode = bizMode;
  }

  public static GuaranteeCompanyBizMode getByBizCode(String bizMode) {
    for (GuaranteeCompanyBizMode guaranteeCompanyBizMode : GuaranteeCompanyBizMode.values()) {
      if (guaranteeCompanyBizMode.getBizMode().equals(bizMode)) {
        return guaranteeCompanyBizMode;
      }
    }
    return null;
  }
}
