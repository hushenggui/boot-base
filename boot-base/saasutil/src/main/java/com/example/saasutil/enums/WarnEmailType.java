package com.example.saasutil.enums;

/**
 *
 */
public enum WarnEmailType {

    /**
     * 保险公司
     */
    INSURANCE(0),
    /**
     * 交易中心
     */
    TRADE(1),

    //支付平台
    PAYMENT(2);

    private Integer type;

    WarnEmailType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
