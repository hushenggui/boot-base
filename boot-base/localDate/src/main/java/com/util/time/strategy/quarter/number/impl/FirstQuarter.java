package com.util.time.strategy.quarter.number.impl;

import com.util.time.enums.Quarter;
import com.util.time.strategy.quarter.number.QuarterNumberStrategy;

import java.time.LocalDate;

/**
 * 第一季度
 *
 */
public class FirstQuarter implements QuarterNumberStrategy {

    /**
     * 获取第一季度
     *
     * @param localDate 传入时间
     * @return 季度
     */
    @Override
    public Quarter getQuarterNumber(LocalDate localDate) {

        return Quarter.FIRST;
    }
}
