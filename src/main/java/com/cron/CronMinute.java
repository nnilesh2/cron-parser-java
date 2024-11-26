package com.cron;

import com.validators.CronValidator;

public record CronMinute(String minute) implements CronValidator{

    private static final int MIN = 0;
    private static final int MAX = 59;

    @Override
    public boolean validate() {
        if (this.validate(minute, MIN, MAX)) {
            return true;
        }else{
            throw new IllegalArgumentException("Minute value should be withing range of 0-59");
        }
        
    }

}
