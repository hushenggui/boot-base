package com.example.saasutil.enums;

/**
 *
 */
public enum InvoiceType {

    /**
     * 保费发票
     */
    POLICY(0),
    /**
     * 服务费发票
     */
    SERVICE(1);

    private Integer type;

    InvoiceType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }
}
