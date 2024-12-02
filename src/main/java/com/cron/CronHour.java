package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public class CronHour implements CronValidator,CronPrinter{

    private String name ;
    private String hour;

    

    /**
     * @param name
     * @param hour
     */
    public CronHour(String name, String hour) {
        this.name = name;
        this.hour = hour;
    }

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
     * @return the hour
     */
    public String getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(String hour) {
        this.hour = hour;
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
