package com.util.time.strategy.quarter.number.impl;

import com.util.time.enums.Quarter;
import com.util.time.strategy.quarter.number.QuarterNumberStrategy;

import java.time.LocalDate;

/**
 * 第三季度
 *
 */
public class ThirdQuarter implements QuarterNumberStrategy {

    /**
     * 获取第三季度
     *
     * @param localDate 传入时间
     * @return 季度
     */
    @Override
    public Quarter getQuarterNumber(LocalDate localDate) {

        return Quarter.THIRD;

    }
}
