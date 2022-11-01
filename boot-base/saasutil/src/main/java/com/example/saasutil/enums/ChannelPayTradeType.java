package com.example.saasutil.enums;

/**
 * @program: saas
 * @description:
 * @author: hushenggui
 * @create: 2021-09-10 16:55
 **/
public enum ChannelPayTradeType {

  /**
   *支付
   */
  PAY("支付"),
  /**
   * 退费
   */
  REFUND("退费");

  private String type;

  ChannelPayTradeType(String type){
    this.type = type;
  }
}
