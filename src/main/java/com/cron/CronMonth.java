package com.cron;

import com.print.CronPrinter;
import com.validators.CronValidator;

public class CronMonth implements CronValidator,CronPrinter{

    private String name;
    private String month;

    

    /**
     * @param name
     * @param month
     */
    public CronMonth(String name, String month) {
        this.name = name;
        this.month = month;
    }

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
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
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
