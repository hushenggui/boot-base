package com.example.common.enums;

public enum DateFinalFormat {

    YYYY_MM_dd("yyyy-MM-dd"),
    YYYY_M_dd("yyyy-M-dd"),
    YYYY_MM_d("yyyy-MM-d"),
    YYYY_M_d("yyyy-M-d"),
    YYYY_MM_dd_HH("yyyy-MM-dd HH"),
    YYYY_MM_dd_HH_mm("yyyy-MM-dd HH:mm"),
    YYYY_MM_dd_HH_mm_ss("yyyy-MM-dd HH:mm:ss"),
    YYYY_MM_dd_HH_mm_ss_SSSS("yyyy-MM-dd HH:mm:ss:SSSS"),
    YYYYMMddHHmmss("yyyyMMddHHmmss"),
    YYYYMMddHHmmssSSSS("yyyyMMddHHmmssSSSS"),
    YYYY_MM("yyyy-MM"),
    MM("MM"),
    YYYY("yyyy"),
    YYYY__MM__dd_HH_mm_ss("yyyy/MM/dd HH:mm:ss"),
    HHmm("HHmm"),
    YYYY__MM__dd("yyyy/MM/dd"),
    dd("dd"),
    HHmmss("HHmmss"),
    YYYYMMdd("yyyyMMdd"),
    YYYYMMddHH("yyyyMMddHH"),
    YYYYMMdd_HH("yyyyMMdd HH"),
    HH("HH")
    ;

    DateFinalFormat() {
    }

    DateFinalFormat(String code) {
        this.code = code;
    }

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}