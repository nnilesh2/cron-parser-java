package com.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class CronParserTest {


    @Test
    public void test_cron_validator_success() {

        String[] args = {"*/15 0 1,15 * 1-5 /usr/bin/find"};
        CronExpression cronExpression = new CronExpression(args);
        boolean isValid = cronExpression.validate();
        assertTrue(isValid);
    }

    @Test
    public void test_cron_print() {
        var expectedPrintString = "minute        0 15 30 45\nhour          0\nday of month  1 15\nmonth         1 2 3 4 5 6 7 8 9 10 11 12\nday of week   1 2 3 4 5\ncommand       /usr/bin/find\n";
        String[] args = {"*/15 0 1,15 * 1-5 /usr/bin/find"};
        CronExpression cronExpression = new CronExpression(args);
        var actualPrintString = cronExpression.print();
        assertEquals(expectedPrintString, actualPrintString);
    }

    @Test
    public void test_cron_arg_failure() {

        String[] args = {};
        var exception = assertThrows(IllegalArgumentException.class, ()-> new CronExpression(args));
        assertTrue(exception.getMessage().equals("No cron expression provided"));
    }

    @Test
    public void test_cron_validator_minute_failure() {
        String[] args = {"*/61 0 1,15 * 1-5 /usr/bin/find"};
        CronExpression cronExpression = new CronExpression(args);
        var exception = assertThrows(IllegalArgumentException.class, ()-> cronExpression.validate());
        assertTrue(exception.getMessage().equals("Minute value should be withing range of 0-59"));
    }

    @Test
    public void test_cron_validator_hour_failure() {
        String[] args = {"*/15 25 1,15 * 1-5 /usr/bin/find"};
        CronExpression cronExpression = new CronExpression(args);
        var exception = assertThrows(IllegalArgumentException.class, ()-> cronExpression.validate());
        assertTrue(exception.getMessage().equals("Hour value should be withing range of 0-23"));
    }

    @Test
    public void test_cron_validator_day_failure() {
        String[] args = {"*/15 0 32,15 * 1-5 /usr/bin/find"};
        CronExpression cronExpression = new CronExpression(args);
        var exception = assertThrows(IllegalArgumentException.class, ()-> cronExpression.validate());
        assertTrue(exception.getMessage().equals("Day value should be withing range of 1-31"));
    }

    @Test
    public void test_cron_validator_month_failure() {
        String[] args = {"*/15 0 1,15 13 1-5 /usr/bin/find"};
        CronExpression cronExpression = new CronExpression(args);
        var exception = assertThrows(IllegalArgumentException.class, ()-> cronExpression.validate());
        assertTrue(exception.getMessage().equals("Monht value should be withing range of 1-12"));
    }

    @Test
    public void test_cron_validator_week_failure() {
        String[] args = {"*/15 0 1,15 * 1-8 /usr/bin/find"};
        CronExpression cronExpression = new CronExpression(args);
        var exception = assertThrows(IllegalArgumentException.class, ()-> cronExpression.validate());
        assertTrue(exception.getMessage().equals("Week value should be withing range of 0-7"));
    }

    @Test
    public void test_cron_validator_command_failure() {
        String[] args = {"*/15 0 1,15 * 1-5  "};
        CronExpression cronExpression = new CronExpression(args);
        var exception = assertThrows(IllegalArgumentException.class, ()-> cronExpression.validate());
        assertTrue(exception.getMessage().equals("Cron command can not be null or blank"));
    }
}
