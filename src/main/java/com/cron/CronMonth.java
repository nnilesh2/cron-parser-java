package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public record CronMonth(String name ,String month) implements CronValidator,CronPrinter{

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

    @Override
    public String print(){
        String prinString = String.format(PRINT_FORMAT, name, this.getPrintValue(month, MIN, MAX));
        System.out.print(prinString);
        return prinString;
    }

}
