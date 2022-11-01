package com.example.saasutil.enums.parameter;

/**
 * 爬虫 - 参数模版
 *
 * @author ：MiHaiDong
 * @date ：Created in 2022/5/10 18:27
 */
public enum CRAWLERSParameter {

    //orderInfo
    ORDER_NO(new Parameter("orderInfo","orderNo","订单编号",true,false,true)),
    INS_CODE(new Parameter("orderInfo","orderNo","订单编号",false,false,true)),
    INS_NAME(new Parameter("orderInfo","orderNo","订单编号",false,false,true)),

    //bidSectionInfo.projectInfo
    PROJECT_NAME(new Parameter("bidSectionInfo.projectInfo","projectName","项目名称",false,false,true)),
    PROJECT_CODE(new Parameter("bidSectionInfo.projectInfo","projectCode","项目编号",false,false,false)),
    PROJECT_TYPE(new Parameter("bidSectionInfo.projectInfo","projectType","项目类型",false,false,true)),

    //bidSectionInfo
    BID_NAME(new Parameter("bidSectionInfo","bidName","标段名称",false,false,true)),
    BID_CODE(new Parameter("bidSectionInfo","bidCode","标段编号",false,false,true)),
    BID_START_DATE(new Parameter("bidSectionInfo","bidStartDate","开标时间",false,false,true)),
    BID_CLOSE_TIME(new Parameter("bidSectionInfo","bidCloseTime","保证金缴纳截止时间",false,false,true)),
    AMOUNT(new Parameter("bidSectionInfo","amount","标段金额",false,false,true)),
    TENDER_DAY(new Parameter("bidSectionInfo","tenderDay","保险期限",false,false,true)),

    //tendereeUserInfo
    TEND_NAME(new Parameter("tendereeUserInfo","name","招标人名称",false,false,true)),
    TEND_ADDRESS(new Parameter("tendereeUserInfo","address","招标人地址",false,false,true)),
    TEND_CREDIT_CODE(new Parameter("tendereeUserInfo","creditCode","招标人社会信用代码",false,false,true)),
    TEND_PHONE(new Parameter("tendereeUserInfo","phone","招标人联系电话",false,false,true)),

    //bidderUserInfo
    USER_NAME(new Parameter("bidderUserInfo","name","投标人",false,false,true)),
    USER_CREDIT_CODE(new Parameter("bidderUserInfo","creditCode","投标人统一信用代码",false,false,true)),
    USER_BIDDER_NATURE_NAME(new Parameter("bidderUserInfo","bidderNatureName","投标人类型",false,false,true)),
    USER_BIDDER_ADDRESS_CODE(new Parameter("bidderUserInfo","bidderAddressCode","投标人公司所在地编码",false,false,true)),
    USER_BIDDER_ADDRESS(new Parameter("bidderUserInfo","bidderAddress","投标人公司所在地",false,false,true)),

    //bidderUserInfo
    CONTACT(new Parameter("bidderUserInfo","contact","联系人",false,false,true)),
    CONTACT_PHONE(new Parameter("bidderUserInfo","phone","联系人手机号",false,false,true)),
    CONTACT_MOBILE_CAPTCHA(new Parameter("bidderUserInfo","mobileCaptcha","手机验证码",false,false,true))
    ;

    private Parameter parameter;

    CRAWLERSParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
}
