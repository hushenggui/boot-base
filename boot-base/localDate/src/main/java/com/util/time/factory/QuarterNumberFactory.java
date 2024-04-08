package com.util.time.factory;

import com.util.time.strategy.quarter.number.QuarterNumberStrategy;
import com.util.time.strategy.quarter.number.impl.FirstQuarter;
import com.util.time.strategy.quarter.number.impl.FourthQuarter;
import com.util.time.strategy.quarter.number.impl.SecondQuarter;
import com.util.time.strategy.quarter.number.impl.ThirdQuarter;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;

/**
 * 季度工厂
 */
public class QuarterNumberFactory {

    /**
     * 创建工厂实体类
     */
    private static QuarterNumberFactory quarterFactory = new QuarterNumberFactory();

    private static Map<Integer, QuarterNumberStrategy> stringStrategyMap = new HashMap<>();

    private QuarterNumberFactory() {
    }

    static {
        stringStrategyMap.put(1, new FirstQuarter());
        stringStrategyMap.put(2, new FirstQuarter());
        stringStrategyMap.put(3, new FirstQuarter());
        stringStrategyMap.put(4, new SecondQuarter());
        stringStrategyMap.put(5, new SecondQuarter());
        stringStrategyMap.put(6, new SecondQuarter());
        stringStrategyMap.put(7, new ThirdQuarter());
        stringStrategyMap.put(8, new ThirdQuarter());
        stringStrategyMap.put(9, new ThirdQuarter());
        stringStrategyMap.put(10, new FourthQuarter());
        stringStrategyMap.put(11, new FourthQuarter());
        stringStrategyMap.put(12, new FourthQuarter());

    }

    public QuarterNumberStrategy creator(LocalDate localDate) {

        Month month = localDate.getMonth();

        int value = month.getValue();

        return stringStrategyMap.get(value);
    }

    public static QuarterNumberFactory getInstance() {
        return quarterFactory;
    }
}
