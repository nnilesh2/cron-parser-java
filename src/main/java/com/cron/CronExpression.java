package com.cron;

import com.validators.CronValidator;

public record CronExpression(String[] args) implements CronValidator{

    @Override
    public boolean validate() {
        // check the argumen lenght , if not present then exit
        if (args.length != 1) {
            throw new IllegalArgumentException("No cron expression provided");
        }
        String[] cronStrings = args[0].split(" ",6);
        var minute = new CronMinute(cronStrings[0]);
        var cronHour =  new CronHour(cronStrings[1]);
        var cronDay=            new CronDay(cronStrings[2]);
        var  cronMonth = new CronMonth(cronStrings[3]);
        var cronWeek= new CronWeek(cronStrings[4]);
        var cronCommand =  new CronCommand(cronStrings[5]);

        return minute.validate() 
        && cronHour.validate() 
        && cronDay.validate() 
        && cronMonth.validate() 
        && cronWeek.validate() 
        && cronCommand.validate();
    }

    public void print(){

    }
}