package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public class CronDay implements CronValidator,CronPrinter {

    private String name;
    private String day;

    

    /**
     * @param name
     * @param day
     */
    public CronDay(String name, String day) {
        this.name = name;
        this.day = day;
    }

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
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
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
