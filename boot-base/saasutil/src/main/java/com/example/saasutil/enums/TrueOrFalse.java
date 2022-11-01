package com.example.saasutil.enums;

/**
 * Created by sunwen on 2019/1/24.
 */
public enum  TrueOrFalse {

    TRUE("true"),
    FALSE("false");

    private String value;

    TrueOrFalse(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
