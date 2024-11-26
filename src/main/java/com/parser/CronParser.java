package com.parser;

import com.cron.CronExpression;

public class CronParser {

    public static void main(String[] args) {
        try {
            CronExpression cronExpression = new CronExpression(args);
            //validate cron expression
            cronExpression.validate();

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

}
