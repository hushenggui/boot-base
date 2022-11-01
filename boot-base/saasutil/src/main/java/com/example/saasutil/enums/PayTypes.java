package com.example.saasutil.enums;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.util.CollectionUtils;

/**
 * 支付方式 0：微信 1：支付宝 2：网银 3:线下
 */
public enum PayTypes {
    /**
     * 微信支付
     */
    WECHATPAY(0),
    /**
     * 支付宝支付
     */
    ALIPAY(1),
    /**
     * 网银支付
     */
    UNIONPAY(2),
    /**
     * 线下支付
     */
    OFFLINE(3)
    ;

    private Integer code;
    PayTypes(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static PayTypes getValue(int code) {
        for (PayTypes pay : values()) {
            if (pay.getCode() == code) {
                return pay;
            }
        }
        return null;
    }


    public static PayTypes  getPayTypes(PayType payType){
        List<PayTypes> list = Arrays.asList(PayTypes.values());
        List<PayTypes> newList = list.stream().filter(payTypes -> {
            return payTypes.getCode() == payType.getCode();
        }).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(newList)){
            return PayTypes.OFFLINE;
        }
        return newList.stream().findFirst().get();
    }

}
