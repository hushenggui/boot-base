package com.example.saasutil.enums;

/**
 * 用友保单状态
 * Created by sunwen on 2019/9/4.
 */
public enum PolicyYongyouStatus {

    NOT_IN_FORCE("未生效","0"),
    EFFECT("有效","1"),
    INVALID("失效","2"),
    ;

    private String name;
    private String code;

    PolicyYongyouStatus(String name, String code) {
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
