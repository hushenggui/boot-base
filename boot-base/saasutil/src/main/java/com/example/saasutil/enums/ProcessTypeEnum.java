package com.example.saasutil.enums;

/**
 * Created by yangbo on 2021/1/11.
 */
public enum ProcessTypeEnum {

    /**
     * 申请退费
     */
    APPLY_FOR_REFUND(0),

    /**
     * 已支付未出函
     */
    NOT_POLICY_BUT_PAY(1),

    /**
     * 修改工商信息
     */
    MOD_ENTERPRICE_INFO(2),

    /**
     * 修改基本户
     */
    MOD_BASIC_INFO(3),
    ;

    private Integer status;

    ProcessTypeEnum(Integer status) {
        this.status = status;
    }


}
