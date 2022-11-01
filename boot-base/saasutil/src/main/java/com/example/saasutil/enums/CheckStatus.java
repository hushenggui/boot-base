package com.example.saasutil.enums;

/**
 * Created by sunwen on 2019/5/22.
 */
public enum CheckStatus {

    INIT("初始化","01"),
    WAIT("待审核","02"),
    SUCCESS("审核成功","03"),
    FAIL("审核失败","04");

    private String name;
    private String code;

    CheckStatus(String name, String code) {
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
