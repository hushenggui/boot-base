package com.example.saasutil.enums;

/**
 * @author linxinlei
 * @project saas
 * @description 请求响应状态 - 太保
 * @date 2022/5/18
 **/
public enum TaiBaoResponseStatus {
    SUCCESS("000000", "成功"),
    FAIL("111111", "失败"),
    ;


    private String code;
    private String message;

    TaiBaoResponseStatus(String code, String message) {
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
