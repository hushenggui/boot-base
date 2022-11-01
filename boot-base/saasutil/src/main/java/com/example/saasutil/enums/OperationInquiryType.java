package com.example.saasutil.enums;

/**
 * 操作询问类型
 */
public enum OperationInquiryType {
    POLICY("1", "投保询问"),
    REFUND("2", "退保询问"),
    POLICY_AND_BIDDERINFO("3", "投保询问的同时校验投保人信息"),
    CREATE_ORDER("4", "创建订单"),
    QUERY_ORDER("5", "查询订单"),
    PAY_WAIT("6", "待付款"),
    QUERY_ENTERPRISE_INFO("7", "查询企业信息"),
    QUERY_BID_SECTION_INFO("8", "查询可投保的标段信息"),
    BID_CONFIRM_NOTICE("9", "确认投保标段回执交易中心"),
    BID_MODIFY_OPENTIME("10","查询交易中心是否修改了开标时间"),
    QUERY_ALL_BID_SECTION_INFO_PAGE("11", "分页查询所有的标段信息"),
    ;

    String code;
    String name;

    OperationInquiryType(String code, String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static OperationInquiryType explain(String code){
        for (OperationInquiryType b : OperationInquiryType.values()){
            if (b.getCode().equals(code)){
                return b;
            }
        }
        return null;
    }
}
