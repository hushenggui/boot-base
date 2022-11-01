package com.example.saasutil.service.xian.bean;

public enum GuangLianDaPolicyStatus {
    /**
     * 待提交
     */
    wait("01"),
    /**
     * 待支付
     */
    PAY_WAIT("02"),
    /**
     * 待风控审核
     */
    CHECK_WAIT("03"),
    /**
     * 待出函
     */
    ISSUE_WAIT("04"),
    /**
     * 出函
     */
    ISSUE("05"),
    /**
     * 已支付
     */
    PASS("06"),
    /**
     * 取消
     */
     CANCEL("07")
    ;

    GuangLianDaPolicyStatus(String status) {
        this.status = status;
    }

    String status;
    public String getStatus() {
        return status;
    }
    public void setStatus() {
        this.status = status;
    }
}
