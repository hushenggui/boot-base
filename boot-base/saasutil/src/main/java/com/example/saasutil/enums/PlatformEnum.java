package com.example.saasutil.enums;

/**
 * Created by yangbo on 2021/1/11.
 */
public enum PlatformEnum {

    /**
     * 电子保函
     */
    ELEC(0),

    /**
     * 工保网
     */
    NET(1),

    /**
     * 工保盾
     */
    DUN(2),
    ;
    private Integer status;

    PlatformEnum(Integer status) {
        this.status = status;
    }
}
