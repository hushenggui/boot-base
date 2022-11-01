package com.example.saasutil.enums;

/**
 *
 */
public enum ChainNode {

    /**
     * 投保
     */
    CHAIN_OO0(0),
    /**
     * 基本户对比失败
     */
    CHAIN_OO1(1),
    /**
     * 支付信息
     */
    CHAIN_OO2(2),

    /**
     * 投标人申请退保信息
     */
    CHAIN_OO3(3),

    /**
     *投标人申请发票信息
     */
    CHAIN_OO4(4),


    /**
     *电子保单理赔信息
     */
    CHAIN_OO5(5),

    /**
     *放弃保证保险
     */
    CHAIN_OO6(6),

    /**
     *投标人选择保险公司并记录保险信息
     */
    CHAIN_OO7(7),

    /**
     *还原保函
     */
    CHAIN_OO8(8),

    /**
     * 标段异常
     */
    CHAIN_OO9(9);

    private Integer node;

    ChainNode(Integer node) {
        this.node = node;
    }

    public Integer getNode() {
        return node;
    }

    public static String  getName(ChainNode node){
        switch (node){
            case CHAIN_OO0:
                return "订单生成";
            case CHAIN_OO1:
                return "基本户对比失败";
            case CHAIN_OO2:
                return "支付成功";
            case CHAIN_OO3:
                return "退保";
            case CHAIN_OO4:
                return "申请发票";
            case CHAIN_OO5:
                return "保单理赔";
            case CHAIN_OO6:
                return "放弃保证保险";
            case CHAIN_OO7:
                return "投保";
            case CHAIN_OO8:
                return "还原保函";
            case CHAIN_OO9:
                return "标段异常";
            default:
                return "";
        }
    }
}
