package com.example.saasutil.util.jianshe;

import lombok.Data;

@Data
public class PushDataRequest {
    private String projUnique;
    private String regionCode;
    private String projectType;
    private String closeTime;
    private String bidOpenTime;
    private String amount;
    private String projNm;
    private String sectionNm;
    private String ownerNm;
    private String ownerOrgNO;
    private String serialNOS;
    private String state;
}
