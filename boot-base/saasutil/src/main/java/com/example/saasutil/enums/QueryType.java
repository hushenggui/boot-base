package com.example.saasutil.enums;

/**
 * @author solyutian
 * @date 2020/9/22 3:26 下午
 */
public enum QueryType {
    POLICY_LIST_QUERY_BY_BIDID("查询所有保单信息","1"),
    POLICY_QUERY("查询所有保单信息","2"),
    POLICY_SUM_QUERY_BY_TIME("查询所有保单信息","3")
    ;


    private String name;
    private String code;

    QueryType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
