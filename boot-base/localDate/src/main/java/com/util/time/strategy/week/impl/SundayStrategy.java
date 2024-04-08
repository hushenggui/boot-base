package com.util.time.strategy.week.impl;

import com.util.time.enums.WeekOfDayEnum;
import com.util.time.strategy.week.Strategy;

/**
 * @author liuyangos8888
 */
public class SundayStrategy implements Strategy {


    /**
     * 返回周日对应的数字
     *
     * @param dayOfWeek 星期几
     * @return 对应的数字
     */
    @Override
    public Integer getWeekNumber(String dayOfWeek) {

        if (dayOfWeek.equals(WeekOfDayEnum.DAY_SUNDAY.weekDay())) {
            return WeekOfDayEnum.DAY_SUNDAY.number();
        }

        return 0;
    }

    /**
     * 数字返回周日
     *
     * @param dayOfWeek 数字（1-7）
     * @return 数字返回周日
     */
    @Override
    public String getWeekChineseName(Integer dayOfWeek) {
        if (dayOfWeek.equals(WeekOfDayEnum.DAY_SUNDAY.number())) {
            return WeekOfDayEnum.DAY_SUNDAY.weekDay();
        }

        return "输入的不是1-7的数字，不在合法星期范围内";
    }
}
