package com.husg.template.mybatisplusbase.enums;

import lombok.Getter;

/**
 * description: 查询类型
 *
 * @author zhouxinlei
 * @since 2022-04-21 09:25:43
 */
@Getter
public enum QueryTypeEnum {
    /**
     * 查询类型
     */
    QUERY(10, "query", "查询"),
    SORT(20, "sort", "排序"),
    ;

    private final Integer id;
    private final String code;
    private final String name;

    QueryTypeEnum(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }
}
