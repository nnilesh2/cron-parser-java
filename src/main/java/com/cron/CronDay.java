package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public record CronDay(String name ,String day) implements CronValidator,CronPrinter {

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

    @Override
    public String print(){
        String prinString = String.format(PRINT_FORMAT, name, this.getPrintValue(day, MIN, MAX));
        System.out.print(prinString);
        return prinString;
    }


}
