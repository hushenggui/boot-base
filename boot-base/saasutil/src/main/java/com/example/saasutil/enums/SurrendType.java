package com.example.saasutil.enums;

/**
 * 退保原因（交易中心发起）
 * Created by sunwen on 2019/4/4.
 */
public enum SurrendType {

    BIDDERS("流标","1"),
    STOP("终止","2"),
    SUSPEND("暂停(中止)","3"),
    CANCEL("作废","4");

    private String name;
    private String code;

    SurrendType(String name, String code) {
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
