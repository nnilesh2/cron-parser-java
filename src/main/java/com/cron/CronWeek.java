package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public class CronWeek implements CronValidator,CronPrinter{

    private String name;
    private String week;

    

    /**
     * @param name
     * @param week
     */
    public CronWeek(String name, String week) {
        this.name = name;
        this.week = week;
    }
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
     * @return the week
     */
    public String getWeek() {
        return week;
    }
    /**
     * @param week the week to set
     */
    public void setWeek(String week) {
        this.week = week;
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
