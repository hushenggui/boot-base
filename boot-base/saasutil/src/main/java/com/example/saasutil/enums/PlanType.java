package com.example.saasutil.enums;

/**
 * 发票类型
 * Created by sunwen on 2019/4/4.
 */
public enum PlanType {

    AMOUNT_TYPE("保额匹配方案","1"),
    WEIGHT_TYPE("权重匹配方案","2"),
    TEST_TYPE("测试方案","3"),
    ;

    private String name;
    private String code;

    PlanType(String name, String code) {
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
