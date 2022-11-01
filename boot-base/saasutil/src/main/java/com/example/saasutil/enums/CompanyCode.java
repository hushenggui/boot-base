package com.example.saasutil.enums;

/**
 * Created by sunwen on 2019/10/30.
 */
public enum CompanyCode {
    TIANAN("913503047640812425","00002"),
    YATAI("91350300683079378B","00003"),
    YONGCHENG("913503006784860167","00012"),
    HUAAN("913503027617866182","00013");


    private String name;
    private String code;

    CompanyCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static String getCompanyCodeByCode(String code){
        for(CompanyCode c : CompanyCode.values()){
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
        System.out.println(getCompanyCodeByCode("00002"));
    }
}
