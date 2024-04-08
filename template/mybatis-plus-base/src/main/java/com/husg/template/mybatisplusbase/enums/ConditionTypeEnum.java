package com.husg.template.mybatisplusbase.enums;

import com.baomidou.mybatisplus.core.conditions.ISqlSegment;
import com.husg.template.mybatisplusbase.exception.ParamValidException;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description: 查询条件类型
 *
 * @author zhouxinlei
 * @since 2022-04-21 09:33:48
 */
@Getter
@AllArgsConstructor
public enum ConditionTypeEnum implements ISqlSegment {
    /**
     * 查询条件
     */
    EQ(10, "="),
    NEQ(11, "!="),
    IS_NULL(12, "IS NULL"),
    IN(20, "IN"),
    LIKE(30, "LIKE %{}%"),
    LIKE_LEFT(31, "LIKE %{}"),
    LIKE_RIGHT(32, "LIKE {}%"),
    GT(40, ">"),
    GE(41, ">="),
    LT(50, "<"),
    LE(51, "<="),

    ;

    private final Integer id;
    private final String keyword;

    public static ConditionTypeEnum convert(int id) {
        ConditionTypeEnum[] conditionTypeEnums = values();
        for (ConditionTypeEnum conditionTypeEnum : conditionTypeEnums) {
            if (conditionTypeEnum.getId().equals(id)) {
                return conditionTypeEnum;
            }
        }
        throw new ParamValidException("查询条件类型[".concat(String.valueOf(id)).concat("]输入不合法"));
    }

    @Override
    public String getSqlSegment() {
        return this.keyword;
    }
}
