package com.example.saasutil.enums;



/**
 * 接口模板编号
 * Created by AnthonyPark on 2018/8/25.
 */
public enum TemplateType {
    APPLY_POLICY("INS001"),
    POLICY_REVERT("INS002"),
    QUIT_POLICY("INS003"),
    POLICY_CLAIM("INS004"),
    POLICY_INVOICE("INS005"),
    APPLYTOKEN("INS006"),
    PAY_NOTICE("INS008"),
    PAYURL("INS009"),
    PAYACCOUNTS("INS010"),
    PAYREVERT("INS011"),
    UPDATE_POLICY_NO("INS012"),
    //对比失败通知支付平台是否是基本户
    NOTICE_PAY_IS_BASIC("INS013"),
    //支付信息查询
    QUERY_PAY_INFO("INS014"),
    //客服选择异常单操作逻辑，通知支付平台
    OPERATION_PAY_STATUS("INS015"),
    CANCELLATION("INS016"),
    QUERY_INVOICE_INFO("INS017"),
    QUERY_REFUND_INFO("INS018"),
    QUERY_CLAIM_INFO("INS019"),

    //保单缴纳成功回执
    INS_POLICY_SUCCESS("INS020"),
    //退保成功回执
    INS_REFUND_SUCESS("INS021"),
    //发票成功回执
    INS_INVOICE_SUCESS("INS022"),
    //保单下载,
    POLICY_DOWNLOAD("INS023"),
    //保险公司还原回执
    INS_REVERT_SUCCESS("INS024"),
    RECEIPT_NOTICE("INS024"),
    REFUND_NOTICE("INS025"),
    GET_FILE_URL("INS026"),
    //通知担保公司项目异常
    CUSTOM_NOTICE("INS027"),

    // 保险公司投保资料审核
    POLICY_FILE_REVIEW("INS028"),
    // 保险公司投保资料审核回执
    POLICY_FILE_REVIEW_NOTICE("INS029"),
    // 缴纳回执转发
    PAY_NOTICE_FORWARD("INS030"),

    //韶关人保投保
    APPLY_POLICY_RB("INS001_RB"),
    POLICY_REVERT_RB("INS002_RB"),
    POLICY_INVOICE_RB("INS005_RB"),
    APPLY_POLICY_PA("INS001_PA"),
    POLICY_REVERT_PA("INS002_PA"),
    POLICY_INVOICE_PA("INS005_PA"),

    //个人主体
    APPLY_POLICY_PERSON("INS028"),
    //企业主体
    APPLY_POLICY_ENTERPRISE("INS029"),
    ;

    private String code;

    TemplateType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
