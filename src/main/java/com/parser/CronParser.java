package com.parser;

public class CronParser {

    public static void main(String[] args) {
        try {
            CronExpression cronExpression = new CronExpression(args);
            //validate cron expression
            cronExpression.validate();
            cronExpression.print();

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

}
