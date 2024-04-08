package com.util.time.factory;

import com.util.time.enums.WeekOfDayEnum;
import com.util.time.strategy.week.Strategy;
import com.util.time.strategy.week.impl.FridayStrategy;
import com.util.time.strategy.week.impl.MondayStrategy;
import com.util.time.strategy.week.impl.SaturdayStrategy;
import com.util.time.strategy.week.impl.SundayStrategy;
import com.util.time.strategy.week.impl.ThursdayStrategy;
import com.util.time.strategy.week.impl.TuesdayStrategy;
import com.util.time.strategy.week.impl.WednesdayStrategy;
import java.util.HashMap;
import java.util.Map;

public class ChineseWeekFactory {

    /**
     * 创建工厂实体类
     */
    private static ChineseWeekFactory chineseWeekFactory = new ChineseWeekFactory();

    private static Map<Integer, Strategy> stringStrategyMap = new HashMap<>();

    public ChineseWeekFactory() {
    }

    static {
        stringStrategyMap.put(WeekOfDayEnum.DAY_SUNDAY.number(), new SundayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_MONDAY.number(), new MondayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_TUESDAY.number(), new TuesdayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_WEDNESDAY.number(), new WednesdayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_THURSDAY.number(), new ThursdayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_FRIDAY.number(), new FridayStrategy());
        stringStrategyMap.put(WeekOfDayEnum.DAY_SATURDAY.number(), new SaturdayStrategy());
    }

    public Strategy creator(int dayOfWeek) {
        return stringStrategyMap.get(dayOfWeek);
    }

    public static ChineseWeekFactory getInstance() {
        return chineseWeekFactory;
    }
}
