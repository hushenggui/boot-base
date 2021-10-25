package com.example.saasutil.vo;

import java.math.BigDecimal;
import lombok.Data;

/**
 * Created by suhao on 2019/11/7.
 */
@Data
public class GgzyPolicy {

    // 订单号
    private String orderNo;
    // 投标单位名称
    private String bidderName;
    // 投标人统一社会信用代码
    private String bidderCode;
    // 保证金金额 （元）
    private BigDecimal amount;
    // 企业基本账户
    private String enterpriseBasicNumber;
    // 授权码
    private String authorization;
    // 投标人联系人
    private String bidderLinkMan;
    // 投标人联系电话
    private String bidderLinkPhone;
    // 项目名称
    private String projectName;
    // 项目标段名称
    private String bidSectionName;
    // 项目标段编号
    private String bidSectionCode;
    // 招标人名称
    private String tendereeName;
    // 招标人统一社会信用证代码
    private String tendereeCode;
    // 招标人地址
    private String tendereeAddress;
    // 招标人联系人(或法人)名称
    private String tendereeContact;
    // 招标人联系人地址
    private String tendereeContactAddress;
    // 招标人联系人方式
    private String tendereeContactPhoneNumber;
    // 开标时间
    private String openTime;
    // 保证金关联截止时间
    private String closeTime;
    // 投标有效期
    private String bidtender;
}
