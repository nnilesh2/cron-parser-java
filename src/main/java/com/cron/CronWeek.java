package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public record CronWeek(String name ,String week) implements CronValidator,CronPrinter{

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
    @Override
    public String print(){
        String prinString = String.format(PRINT_FORMAT, name, this.getPrintValue(week, MIN, MAX));
        System.out.print(prinString);
        return prinString;
    }

}
