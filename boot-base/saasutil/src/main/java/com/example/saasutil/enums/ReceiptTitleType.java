package com.example.saasutil.enums;

/**
 * @param
 * @author 胡胜归
 * @Description: 发票抬头类型
 */
public enum ReceiptTitleType {

    /**
     * 企业
     */
    COMPANY(0),

    /**
     * 个人
     */
    PERSONAL(1),
    ;

    private Integer code;

    ReceiptTitleType(Integer code) {
        this.code = code;
    }
}
