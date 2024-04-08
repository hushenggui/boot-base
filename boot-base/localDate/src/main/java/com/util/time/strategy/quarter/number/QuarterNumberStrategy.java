package com.util.time.strategy.quarter.number;


import com.util.time.enums.Quarter;

import java.time.LocalDate;

public interface QuarterNumberStrategy {

    /**
     * 获取月份初始值
     *
     * @param localDate 传入时间
     * @return 月份数
     */
    Quarter getQuarterNumber(LocalDate localDate);

}
