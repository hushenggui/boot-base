package com.example.saasutil.enums;

/**
 * @author lijing
 * @project saas
 * @description 请求响应状态 - 太保
 * @date 2022/5/26
 **/
public enum TaiBaoReturnCode {
    ZDO103630002("ZDO103630002", "同一流水号/业务号/订单号只能录入一次"),
    INVOICE_UNGET("发票暂未生成，请稍候再试", "发票暂未生成，请稍候再试"),
    INVOICE_WAIT("11", "获取url成功"),
    ;


    private String code;
    private String message;

    TaiBaoReturnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
