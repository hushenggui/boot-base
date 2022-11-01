package com.example.saasutil.enums;

/**
 * Created by sunwen on 2019/2/27.
 */
public enum  BusCode {

    POLICY("生成业务流水号","GGZY001"),
    PAYNOTICE("生成业务流水号","GGZY002"),
    DATEMAINTAIN("项目流标/暂停(中止)/终止","GGZY003"),
    POLICYREVERT("还原保单","GGZY004"),
    CLAIM("理赔申请","GGZY005"),
    SIGN("验签","GGZY006"),
    QUERY("投保/退保查询","GGZY007"),
    UPLOADFILE("上传文件","GGZY009"),
    PUBLICKEY("获取秘钥数据","GGZY010"),
    CHECK("标段信息校验","GGZY011"),
    INVOICE("发票申请","GGZY012"),
    POLICY_SUCCESS("投保成功回执","GGZY013"),
    REFUND_SUCESS("退保成功回执","GGZY014"),
    INVOICE_SUCESS("发票成功回执","GGZY015"),
    REVERT_SUCCESS("项目还原回执","GGZY016"),
    OPERATION_INQUIRY("投保/退保操作询问","GGZY017"),
    CHECK_BIDDER_INFO("投保人信息校验","GGZY018"),
    TRANSACTION_FEE_QUERY("查询交易服务费", "GGZY019"),
    ENTERPRISE_INFO("查询企业信息","GGZY020"),
    BID_SECTION_INFO("查询可投保标段信息","GGZY021"),
    BID_CONFIRM_NOTICE("确认投保标段回执交易中心","GGZY022"),
    CANCEL_SUCCESS("放弃保证保险回执", "GGZY023"),
    POLICY_QUIT_APPLY("交易中心退保申请", "GGZY024"),
    QUERY_ENTERPRISE_INFO("查询企业信息", "GGZY025"),
    SIGNUP_QUERY("查询是否报名","GGZY026"),
    QUERY_PAY_INFO("查询保证金缴纳情况", "GGZY027"),
    POLICY_CLAIM_TOKEN("交易中心申请理赔token", "GGZY028"),
    BID_SECTION_INFO_BY_BIDCODE("根据标段编号查询标段信息", "GGZY029"),
    APPLY_NOTICE("交易中心投保通知","TC00001"),
    REVERT_NOTICE("交易中心还原通知","TC00002"),
    REFUND_NOTICE("交易中心退保通知","TC00003"),
    CANCEL_NOTICE("交易中心取消通知","TC00004"),
    INVOICE_NOTICE("交易中心发票通知","TC00005"),
    POLICY_FILE_UPLOAD_NOTICE("交易中心保单文件上传通知","TC00006"),
    POLICY_FILE_UPLOAD_SUCCESS_NOTICE("交易中心保单文件上传成功通知","TC00007"),
    POLICY_FILE_UPLOAD_PUBLICYKEY("交易中心保单文件上传成功通知加密key和iv的密钥","TC00008"),
    POLICY_CLAIM_NOTICE("交易中心理赔通知","TC00009"),
    REVERT_AGAIN_NOTICE("交易中心重新开具保函申请通知","TC00010"),
    VERIFICATION_NOTICE("交易中心保函声明通知","TC00011"),
    APPLY_AGAIN_NOTICE("交易中心重新开具保函申请通知","TC00012"),
    CLOUD_BANK_INFO("查询工保云银行信息","CLOUD00001"),
    NOTICE_PAY_URL("交易中心支付链接通知","GGZY029"),
    NOTIFY_SUCCESS("投保/批改/退保/取消回执", "GGZY030"),
    ;

    private String name;
    private String code;

    BusCode(String name, String code) {
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
