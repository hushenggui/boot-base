package com.example.saasutil.util.jianshe;

import lombok.Data;

@Data
public class ApplyDataRequest {
    private String uniqueTrade;
    private String projectType;
    private String amount;
    private String bidCurrency;
    private String bidderNm;
    private String bidderUnique;
    private String bidderOrgNo;
    private String bidType;
}
