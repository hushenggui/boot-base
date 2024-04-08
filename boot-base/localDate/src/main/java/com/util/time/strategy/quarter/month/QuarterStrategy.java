package com.util.time.strategy.quarter.month;

public interface QuarterStrategy {

    /**
     * 获取月份初始值
     *
     * @param month 月份
     * @return 月份数
     */
    Integer getInitMonth(int month);

}
