package com.cron;

import com.validators.CronValidator;

public record CronHour(String hour) implements CronValidator{

    private static final int MIN = 0;
    private static final int MAX = 23;

    @Override
    public boolean validate() {
        if (this.validate(hour, MIN, MAX)) {
            return true;
        }else{
            throw new IllegalArgumentException("Hour value should be withing range of 0-23");
        }
        
    }

}
