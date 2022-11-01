package com.example.saasutil.enums;

/**
 * @author solyutian
 * @date 2020/9/23 5:31 下午
 */
public enum SuccessOrError {
    SUCCESS("Success"),
    ERROR("Error");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    SuccessOrError(String name) {
        this.name = name;
    }
}
