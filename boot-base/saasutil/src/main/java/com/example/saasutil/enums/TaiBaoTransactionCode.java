package com.example.saasutil.enums;

/**
 * @author linxinlei
 * @project saas
 * @description 请求业务交易码 - 太保
 * @date 2022/5/19
 **/
public enum TaiBaoTransactionCode {

    POLICY_APPLY("107001", "投保申请"),
    POLICY_QUERY("107002", "投保查询"),
    POLICY_DOWN("107003", "保单下载"),
    QUIT_APPLY("107004", "退保申请"),
    INVOICE_DOWN("108006", "发票下载"),
    POLICY_REVERT("107010", "保单批改"),
    INVOICE_APPLY("108009", "发票申请"),
    ;

    private String code;
    private String desc;
    TaiBaoTransactionCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
