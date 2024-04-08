package com.util.time.strategy.quarter.month.impl;

import com.util.time.strategy.quarter.month.QuarterStrategy;

public class JanuaryStrategy implements QuarterStrategy {

    @Override
    public Integer getInitMonth(int month) {

        if (month == 1){
            return 11;
        }
        return 0;
    }
}
