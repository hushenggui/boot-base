package com.util.time.factory;

import com.util.time.enums.Quarter;
import com.util.time.strategy.quarter.month.QuarterStrategy;
import com.util.time.strategy.quarter.number.QuarterNumberStrategy;
import com.util.time.strategy.week.Strategy;

import java.time.LocalDate;

public class Context {

    /**
     * 注入策略模式类
     */
    private Strategy strategy;

    /**
     * 注入季节策略模式类
     */
    private QuarterStrategy quarterStrategy;

    /**
     * 注入季节数策略模式类
     */
    private QuarterNumberStrategy quarterNumberStrategy;

    public Integer getWeekNumber(String dayOfWeek) {

        strategy = StrategyFactory.getInstance().creator(dayOfWeek);
        return strategy.getWeekNumber(dayOfWeek);
    }

    public String getWeekChineseName(int dayOfWeek) {
        strategy = ChineseWeekFactory.getInstance().creator(dayOfWeek);
        return strategy.getWeekChineseName(dayOfWeek);
    }

    public Integer getInitMonth(int month) {

        int start = 0;
        int temp = 0;

        if (month == 1) {
            start = 11;
            month = 13;
            temp = start - month;
        } else {
            quarterStrategy = QuarterFactory.getInstance().creator(String.valueOf(month));
            Integer initMonth = quarterStrategy.getInitMonth(month);
            temp = initMonth - month;
        }

        return temp;
    }

    public Quarter getQuarterNumber(LocalDate localDate) {

        quarterNumberStrategy = QuarterNumberFactory.getInstance().creator(localDate);

        return quarterNumberStrategy.getQuarterNumber(localDate);
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public QuarterStrategy getQuarterStrategy() {
        return quarterStrategy;
    }

    public void setQuarterStrategy(QuarterStrategy quarterStrategy) {
        this.quarterStrategy = quarterStrategy;
    }

    public QuarterNumberStrategy getQuarterNumberStrategy() {
        return quarterNumberStrategy;
    }

    public void setQuarterNumberStrategy(QuarterNumberStrategy quarterNumberStrategy) {
        this.quarterNumberStrategy = quarterNumberStrategy;
    }
}
