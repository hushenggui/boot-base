package com.example.saasutil.enums;



/**
 * 支付方式 0：微信 1：支付宝 2：网银 3:线下
 */
public enum PayType {
    /**
     * 微信支付
     */
    WEIXIN(0),
    /**
     * 支付宝支付
     */
    ZHIFUBAO(1),
    /**
     * 网银支付
     */
    WANGYIN(2),
    /**
     * 线下支付
     */
    OFFLINE(3)
    ;

    private Integer code;
    PayType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static PayType getValue(int code) {
        for (PayType pay : values()) {
            if (pay.getCode() == code) {
                return pay;
            }
        }
        return null;
    }

}
