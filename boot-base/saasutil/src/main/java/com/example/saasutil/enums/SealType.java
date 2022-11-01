package com.example.saasutil.enums;

/**
 * 签章类型
 */
public enum SealType {
    GONGBAOKEJI("1","工保科技（浙江）有限公司"),
    GONGBAOWANG("2","工保网保险经纪有限公司");

    private String name;
    private String code;

    SealType(String code, String name) {
        this.code = code;
        this.name = name;
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
