package com.example.saasutil.enums;

public enum GuaranteePolicyStatus {

    NONE("0","未出单"),
    CHECK("1","未批改"),
    CHECKING("2","批改中"),
    CHECKED("3","已批改");

    private String code;
    private String name;

    GuaranteePolicyStatus(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getValue(String code) {
        for (GuaranteePolicyStatus status : values()) {
            if (status == null) {
                continue;
            }
            if (status.getCode().equals(code)) {
                return status.getName();
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

}
