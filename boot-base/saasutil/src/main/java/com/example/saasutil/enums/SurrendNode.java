package com.example.saasutil.enums;

/**
 * 退保原因（交易中心发起）
 * Created by sunwen on 2019/4/4.
 */
public enum SurrendNode {

    UNACCEPT("未受理",0),
    ACCEPT("已受理",1),
    SUCCESS("退保成功",2),
    FAIL("退保失败",3),
    ;

    private String name;
    private Integer code;

    SurrendNode(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
