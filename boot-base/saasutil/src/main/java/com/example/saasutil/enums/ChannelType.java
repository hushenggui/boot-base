package com.example.saasutil.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author linxinlei
 * @project saas
 * @description 渠道类型
 * @date 2022/6/23
 **/
@Getter
@AllArgsConstructor
public enum ChannelType {
  INSURANCE(0, "保险公司"),
  GUARANTEE(1, "担保"),
  BANK(2, "银行"),
  TRADE_CENTER(9, "交易中心")
  ;
  final int type;
  final String name;

}
