package com.example.saasutil.enums;

/**
 * 保证金缴纳截止时间提示类型
 */
public enum BidCloseTimeTipType {
    //保证金缴纳截止时间之前
    BEFORE("before"),
    //超过保证金缴纳截止时间
    OVER("over"),
    //退保
    REFUND("refund");
    private String tipKey;

    BidCloseTimeTipType(String tipKey) {
        this.tipKey = tipKey;
    }

    public String getTipKey() {
        return tipKey;
    }

    public void setTipKey(String tipKey) {
        this.tipKey = tipKey;
    }

}
