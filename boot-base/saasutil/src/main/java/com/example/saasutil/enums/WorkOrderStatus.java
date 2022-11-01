package com.example.saasutil.enums;

import lombok.Getter;

/**
 * Created by yangbo on 2021/1/13.
 * 工单处理状态
 */
public enum WorkOrderStatus {

    WAIT(0, "未处理"),

    HAVE(1, "已处理"),

    FAIL(2, "处理失败"),

    CLOSE(3, "已关闭"),

    ;
    private Integer status;

    @Getter
    private String message;

    WorkOrderStatus(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
