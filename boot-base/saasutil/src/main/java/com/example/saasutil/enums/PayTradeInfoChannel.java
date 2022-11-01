package com.example.saasutil.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PayTradeInfoChannel {
  //民生银行
  CMBC(0),
  //招商银行
  CMB(1),
  //银准科技
  VISASTANDARDS(2),
  //银准科技 新支付
  WZCB(3),
  //工商银行 模拟渠道
  ICBC(4),
  //
  SPABANK(5),
  ;
  Integer channel;
  PayTradeInfoChannel(Integer channel) {
    this.channel = channel;
  }
  Integer getChannel() {
    return channel;
  }

  public static PayTradeInfoChannel getChannel(String channel) {
    List<PayTradeInfoChannel> values = Arrays.asList(PayTradeInfoChannel.values());
    List<PayTradeInfoChannel> types = values.stream()
        .filter(channelInfo -> channelInfo.toString().equals(channel)).collect(Collectors.toList());
    return types.stream().findFirst().get();
  }

  public static String getChannelByBankCode(String channel) {
    switch (channel) {
      //305	CMBC	中国民生银行
      case "305" : return PayTradeInfoChannel.CMBC.name();
      //307	SPABANK	平安银行
      default: return PayTradeInfoChannel.SPABANK.name();
    }
  }

  public static void main(String[] args) {
    System.out.println(PayTradeInfoChannel.CMB.toString());
  }
}
