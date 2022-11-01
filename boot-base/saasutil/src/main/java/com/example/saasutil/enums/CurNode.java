package com.example.saasutil.enums;



/**
 * Created by AnthonyPark on 2018/8/25.
 */
public enum CurNode {

    //未提交
    UNSUBMIT(1),
    //已提交
    SUBMIT(2),
    //待支付
    PAY(3),
    //已支付
    PAIED(4),
    //信息还原
    INFO_ADD(5),
    //暂停、中止
    STOP(6),
    //完成
    POLICY(7),
    //退保
    SURRENDER(8),
    //退保成功
    REVERTSUCCESS(9),
    //驳回
    REJECT(-1),
    //注销
    CANCLE(0);

    private Integer node;

    CurNode(Integer node) {
        this.node = node;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }
}
