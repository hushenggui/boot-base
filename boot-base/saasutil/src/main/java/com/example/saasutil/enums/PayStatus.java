package com.example.saasutil.enums;

/**
 * Created by AnthonyPark on 2018/9/5.
 */
public enum PayStatus {
    INIT("INIT","初始状态"),
    NOTPAY("NOTPAY","未支付"),
    SUCCESS("SUCCESS","支付成功"),
    PAYERROR("PAYERROR","支付失败(其他原因)"),
    CLOSED("CLOSED","交易已关闭"),
    REVERSE("REVERSE","过期交易关闭"),;

    PayStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;
    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
