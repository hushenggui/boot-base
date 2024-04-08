package com.util.time.strategy.quarter.number.impl;

import com.util.time.enums.Quarter;
import com.util.time.strategy.quarter.number.QuarterNumberStrategy;

import java.time.LocalDate;

/**
 * 第四季度
 *
 */
public class FourthQuarter implements QuarterNumberStrategy {

    /**
     * 获取第四季度
     *
     * @param localDate 传入时间
     * @return
     */
    @Override
    public Quarter getQuarterNumber(LocalDate localDate) {

        return Quarter.FOURTH;

    }
}
