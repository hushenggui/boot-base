package com.example.saasutil.enums;

import lombok.Getter;

/**
 * Created by yangbo on 2021/1/11.
 */
public enum WorkOrderEnum {

    /**
     * 异常支付
     */
    PAY_EXCEPTION(0, new ProcessTypeEnum[]{}),

    /**
     * 订单售后
     */
    ORDER_AFTER_SALES(1,
            new ProcessTypeEnum[]{ProcessTypeEnum.APPLY_FOR_REFUND, ProcessTypeEnum.NOT_POLICY_BUT_PAY}),

    /**
     * 企业信息
     */
    MOD_ENTERPRICE_INFO(2,
            new ProcessTypeEnum[]{ProcessTypeEnum.MOD_ENTERPRICE_INFO, ProcessTypeEnum.MOD_BASIC_INFO}),
    ;

    private Integer status;

    @Getter
    private ProcessTypeEnum[] processType;

    WorkOrderEnum(Integer status, ProcessTypeEnum[] processType) {
        this.status = status;
        this.processType = processType;
    }

}
