package com.example.saasutil.service.pay.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class PayNoticeRespDto<T> {
    public static String RESPONSE_SUCCESS = "00000000";
    public static String RESPONSE_FAIL = "00000001";
    /**
     * 状态码
     */
    private String code;

    private String custNo = "M0000002";
    private String platNo = "M0000002";
    private String sign;
    private String version = "1.0";

    /**
     * 响应内容
     */
    private T body;

    /**
     * 错误说明
     */
    private String message;

    /**
     * 请求时间
     */
    private String timestamp;
}
