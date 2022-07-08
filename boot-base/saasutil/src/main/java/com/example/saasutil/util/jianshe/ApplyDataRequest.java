package com.example.saasutil.util.jianshe;

import java.math.BigDecimal;
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


    public static void main(String[] args) {
        BigDecimal ss = new BigDecimal("0.6").multiply(new BigDecimal("1000"));
        BigDecimal s1 = ss.divide(new BigDecimal("1000"));

        System.out.println(ss.longValue());
        System.out.println(s1);
    }
}
