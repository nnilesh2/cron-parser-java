package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public record CronHour(String name ,String hour) implements CronValidator,CronPrinter{

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

    @Override
    public String print(){
        String prinString = String.format(PRINT_FORMAT, name, this.getPrintValue(hour, MIN, MAX));
        System.out.print(prinString);
        return prinString;
    }

}
