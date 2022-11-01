package com.example.saasutil.enums;

public enum PayRefundType {

    /**
     * 1 原路返回
     * 2 开放
     * 3 其他原因
     */
    ORIGINAL(0),
    OPEN(1),
    OTHER(2),
    ;

    private Integer code;

    public static PayRefundType getExamType(String code) {
        if("1".equals(code)) {
            return PayRefundType.ORIGINAL;
        } else if("2".equals(code)) {

        }
        return null;
    }

    PayRefundType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}