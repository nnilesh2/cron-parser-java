package com.cron;

import com.validators.CronValidator;

public record CronWeek(String week) implements CronValidator{

    private static final int MIN = 0;
    private static final int MAX = 7;

    @Override
    public boolean validate() {
        if (this.validate(week, MIN, MAX)) {
            return true;
        }else{
            throw new IllegalArgumentException("Week value should be withing range of 0-7");
        }
        
    }

}
