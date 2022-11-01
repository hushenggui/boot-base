package com.example.saasutil.enums;

import org.springframework.util.ObjectUtils;

public enum RequestType {
  GONGBAO,
  BAOXIAN,
  DANBAO,
  BANK,
  INSURANCE_BID,
  GUARANTEE_BID,
  BANK_BID;

  public static RequestType convertGuaranteeTypeToRequestType(GuaranteeType type){
    if (ObjectUtils.isEmpty(type)){
      return null;
    }

    switch (type){
      case GUARANTEE:
        return INSURANCE_BID;
      case COMPANY:
        return GUARANTEE_BID;
      case BANK:
        return BANK_BID;
      default:
        return null;
    }
  }
}
