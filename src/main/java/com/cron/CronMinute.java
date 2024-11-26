package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public record CronMinute(String name ,String minute) implements CronValidator,CronPrinter{

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

    @Override
    public String print(){
        String prinString = String.format(PRINT_FORMAT, name, this.getPrintValue(minute, MIN, MAX));
        System.out.print(prinString);
        return prinString;
    }

}
