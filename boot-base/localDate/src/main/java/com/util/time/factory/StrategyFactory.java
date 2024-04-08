package com.util.time.factory;

import com.util.time.enums.WeekOfDayEnum;
import com.util.time.strategy.week.Strategy;
import com.util.time.strategy.week.impl.*;

import java.util.HashMap;
import java.util.Map;

public class StrategyFactory {

    /**
     * 创建工厂实体类
     */
    private static StrategyFactory strategyFactory = new StrategyFactory();

    private static Map<String, Strategy> stringStrategyMap = new HashMap<>();

    public StrategyFactory() {
    }

    static {
        stringStrategyMap.put(WeekOfDayEnum.DAY_SUNDAY.weekDay(), new SundayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_MONDAY.weekDay(), new MondayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_TUESDAY.weekDay(), new TuesdayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_WEDNESDAY.weekDay(), new WednesdayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_THURSDAY.weekDay(), new ThursdayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_FRIDAY.weekDay(), new FridayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_SATURDAY.weekDay(), new SaturdayStrategy());
    }

    public Strategy creator(String weekOfDay) {
        return stringStrategyMap.get(weekOfDay);
    }

    public static StrategyFactory getInstance() {
        return strategyFactory;
    }
}
