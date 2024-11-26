package com.cron;

import com.validators.CronValidator;

public record CronDay(String day) implements CronValidator {

    private static final int MIN = 1;
    private static final int MAX = 31;

    @Override
    public boolean validate() {
        if (this.validate(day, MIN, MAX)) {
            return true;
        }else{
            throw new IllegalArgumentException("Day value should be withing range of 1-31");
        }
        
    }

}
