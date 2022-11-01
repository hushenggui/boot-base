package com.example.saasutil.enums;

public enum ConfigKeys {
  /**
   * 平台编码
   */
  PROFIT_PAY_PLATFORM_PLAT_NO("profit.pay-platform.platNo"),
  /**
   * 商户号
   */
  PROFIT_PAY_PLATFORM_CUST_NO("profit.pay-platform.custNo"),
  /**
   * 渠道路由
   */
  TRADE_CENTER_ROUTER_CHANNEL("tradeCenter.router.channel"),
  /**
   * 显示企业认证名称
   */
  FRONT_CONFIG_CERTIFY_ENTERPRISE_NAME("front.config.certifyEnterpriseName"),
  /**
   * 显示统一社会信用证代码
   */
  FRONT_CONFIG_CERTIFY_SOCIAL_CREDIT_CODE("front.config.certifySocialCreditCode"),
  /**
   * 是否嵌入式电子保函
   */
  FRONT_CONFIG_IS_EMBEDDED("front.config.isEmbedded"),
  //是否推送kafka日志
  KAFKA_LOG_SEND("kafka.log.send"),
  /**
   * 是否基本户
   */
  FRONT_CONFIG_IS_BASIC("front.config.isBasic"),

  /**
   * 是否展示基本户信息
   */
  SHOW_BASIC_INFO("front.config.showBasicInfo"),
  ;

  private String key;
  ConfigKeys(String key) {
   this.key = key;
  }

  public String getKey() {
    return key;
  }
}
