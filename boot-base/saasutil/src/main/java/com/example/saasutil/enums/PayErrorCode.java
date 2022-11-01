package com.example.saasutil.enums;

/**
 * Created by sunwen on 2019/11/7.
 */
public enum PayErrorCode {

    SUCCESS("操作成功","200"),
    ILLEGAL("非法访问","401"),
    PURVIEW("没有权限","403"),
    NULL("你请求的路径不存在","404"),
    FAIL("操作失败","500"),
    ERROR("系统异常","5000"),
    CHECK_ERROR("请求参数校验异常","5001"),
    ANALYSIS_ERROE("请求参数解析异常","5002"),
    TYPE_ERROR("HTTP Media 类型异常","5003"),
    NO_METHOD("没有method参数，或method参数为空","5004"),
    NO_ORDER("订单号不存在","5005"),
    NO_VALID_RESULT_OF_BASE_ACCOUNT("基本户校验结果不存在","5005"),
    NO_POLICY("保单不存在","5006"),
    UPDATE_FAIL("支付成功数据更新失败","5007"),

    REPEAT_PUSH("重复的推送","4000");

    private String name;
    private String code;

    PayErrorCode(String name, String code) {
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
