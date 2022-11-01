package com.example.saasutil.service.xian.bean;

import lombok.Data;

@Data
public class GuangLianDaUpdatePolicyBean {

    private String status;

    private String guaranteePath;

    private long guaranteeAmt;

    private String guaranteeDate;

    private String termStartDate;

    private String termEndDate;

    private String guaranteeId;
}
