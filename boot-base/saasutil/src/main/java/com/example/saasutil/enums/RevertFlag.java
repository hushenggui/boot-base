package com.example.saasutil.enums;

/**
 * 还原标识
 * Created by sunwen on 2019/4/4.
 */
public enum RevertFlag {

    UNREVERT("未批改","0"),
    REVERT("批改中","1"),
    SUCCESS("批改成功","2"),
    ;

    private String name;
    private String code;

    RevertFlag(String name, String code) {
        this.name = name;
        this.code = code;
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
