package com.example.saasutil.enums;


public enum WarnEmailNode {


    INS_POLICY_SUCCESS("保单缴纳成功回执","INS0013"),
    INS_REFUND_SUCESS("退保成功回执","INS0014"),
    INS_INVOICE_SUCESS("发票成功回执","INS0015"),
    ;

    private String name;
    private String code;

    WarnEmailNode(String name, String code) {
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
