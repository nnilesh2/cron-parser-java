package com.cron;

import com.validators.CronValidator;

public record CronMonth(String month) implements CronValidator{

    private static final int MIN = 1;
    private static final int MAX = 12;

    @Override
    public boolean validate() {
        if (this.validate(month, MIN, MAX)) {
            return true;
        }else{
            throw new IllegalArgumentException("Monht value should be withing range of 1-12");
        }
        
    }

}
