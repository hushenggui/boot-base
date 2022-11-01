package com.example.saasutil.enums;

/**
 * 通知标识
 * Created by sunwen on 2019/7/4.
 */
public enum SubmitFlag {

    UNREVERT("未回调交易中心","0"),
    REVERT("已通知保险公司","1"),
    SUCCESS("已回调交易中心","2"),
    ;

    private String name;
    private String code;

    SubmitFlag(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
