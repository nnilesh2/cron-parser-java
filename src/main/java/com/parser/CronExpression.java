package com.parser;

import com.cron.CronCommand;
import com.cron.CronDay;
import com.cron.CronHour;
import com.cron.CronMinute;
import com.cron.CronMonth;
import com.cron.CronWeek;

public class CronExpression{

    private String[] args;
    private CronMinute cronMinute;
    private final  CronHour cronHour;
    private CronDay cronDay;
    private CronMonth cronMonth;
    private CronWeek cronWeek;
    private CronCommand cronCommand;

    public CronExpression (String[] args){
        this.args=args;
        String[] cronStrings = getCronString();
        this.cronMinute = new CronMinute("minute",cronStrings[0]);
        this.cronHour =  new CronHour("hour",cronStrings[1]);
        this.cronDay=            new CronDay("day of month",cronStrings[2]);
        this. cronMonth = new CronMonth("month",cronStrings[3]);
        this.cronWeek= new CronWeek("day of week",cronStrings[4]);
        this.cronCommand =  new CronCommand("command",cronStrings[5]);
    }
    
    public boolean validate() {
        return cronMinute.validate() 
        && cronHour.validate() 
        && cronDay.validate() 
        && cronMonth.validate() 
        && cronWeek.validate() 
        && cronCommand.validate();
    }

    public String print(){
        var minuteString = cronMinute.print();
       var hourString = cronHour.print(); 
       var dayString =  cronDay.print();
        var monthString = cronMonth.print(); 
        var weekString = cronWeek.print(); 
        var commandString = cronCommand.print();
        return  minuteString+hourString+dayString+monthString+weekString+commandString;
    }

    private String[] getCronString() throws IllegalArgumentException {
        // check the argumen lenght , if not present then exit
        if (this.args.length != 1) {
            throw new IllegalArgumentException("No cron expression provided");
        }
        String[] cronStrings = this.args[0].split(" ",6);
        return cronStrings;
    }
}