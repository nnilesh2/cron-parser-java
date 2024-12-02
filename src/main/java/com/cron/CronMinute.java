package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public class CronMinute implements CronValidator,CronPrinter{

    private String name;
    private String minute;

    

    /**
     * @param name
     * @param minute
     */
    public CronMinute(String name, String minute) {
        this.name = name;
        this.minute = minute;
    }

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

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the minute
     */
    public String getMinute() {
        return minute;
    }

    /**
     * @param minute the minute to set
     */
    public void setMinute(String minute) {
        this.minute = minute;
    }

    /**
     * @return the min
     */
    public static int getMin() {
        return MIN;
    }

    /**
     * @return the max
     */
    public static int getMax() {
        return MAX;
    }
    

}
