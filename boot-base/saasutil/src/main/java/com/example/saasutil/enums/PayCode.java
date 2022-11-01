package com.example.saasutil.enums;

/**
 * Created by sunwen on 2019/11/7.
 */
public enum PayCode {

    PUBLICKEY("PAY001"),
    PRIVATEKEY("PAY002");

    private String code;

    PayCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
