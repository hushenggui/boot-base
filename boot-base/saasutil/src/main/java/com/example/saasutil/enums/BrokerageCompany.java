package com.example.saasutil.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BrokerageCompany {
  //东方大地
  DONG_FANG_DA_DI(0),
  //祁安
  QI_AN(1),
  //最会保
  ZUI_HUI(2);

  Integer company;
  BrokerageCompany(Integer company) {
    this.company = company;
  }
  Integer getCompany() {
    return company;
  }

  public static BrokerageCompany getCompany(String company) {
    List<BrokerageCompany> values = Arrays.asList(BrokerageCompany.values());
    List<BrokerageCompany> types = values.stream()
        .filter(channelInfo -> channelInfo.toString().equals(company)).collect(Collectors.toList());
    return types.stream().findFirst().get();
  }

  public static BrokerageCompany getCompany(PayTradeInfoChannel payTradeInfoChannel) {
    if(PayTradeInfoChannel.VISASTANDARDS == payTradeInfoChannel || PayTradeInfoChannel.WZCB == payTradeInfoChannel) {
      return BrokerageCompany.DONG_FANG_DA_DI;
    } else {
      return BrokerageCompany.QI_AN;
    }
  }

  public static String getBrokerageCompany(BrokerageCompany brokerageCompany) {
   if(BrokerageCompany.DONG_FANG_DA_DI == brokerageCompany) {
      return "东方大地（武汉）保险经纪有限公司";
   } else if(BrokerageCompany.QI_AN == brokerageCompany) {
      return "工保网保险经纪有限公司";
   } else if(BrokerageCompany.ZUI_HUI == brokerageCompany) {
     return "最会保保险经纪有限公司";
   } else {
     return "工保网保险经纪有限公司";
   }
  }

  public static void main(String[] args) {
    System.out.println(BrokerageCompany.QI_AN.toString());
  }
}
