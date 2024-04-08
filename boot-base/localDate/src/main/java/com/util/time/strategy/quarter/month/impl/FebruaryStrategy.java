package com.util.time.strategy.quarter.month.impl;

import com.util.time.strategy.quarter.month.QuarterStrategy;

public class FebruaryStrategy implements QuarterStrategy {

    @Override
    public Integer getInitMonth(int month) {

        if (month >= 2 && month <= 4){

            return 2;
        }

        return 0;
    }
}
