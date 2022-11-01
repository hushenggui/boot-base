package com.example.saasutil.enums;

/**
 * Created by sunwen on 2019/10/30.
 */
public enum CompanyName {
    TIANAN("天安财产保险股份有限公司莆田中心支公司","00002"),
    YATAI("亚太财产保险有限公司莆田中心支公司","00003"),
    YONGCHENG("永诚财产保险股份有限公司莆田中心支公司","00012"),
    HUAAN("华安财产保险股份有限公司莆田中心支公司","00013");


    private String name;
    private String code;

    CompanyName(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static String getCompanyNameByCode(String code){
        for(CompanyName c : CompanyName.values()){
            if(c.getCode().equals(code)){
                return c.getName();
            }
        }
        return null;
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

    public static void main(String[] args) {
        System.out.println(getCompanyNameByCode("00002"));
    }
}
