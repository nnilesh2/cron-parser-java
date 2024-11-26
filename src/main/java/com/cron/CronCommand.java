package com.cron;

import java.util.Objects;

import com.print.CronPrinter;
import com.validators.CronValidator;

public record CronCommand(String name ,String command) implements CronValidator,CronPrinter {
    @Override
    public boolean validate() {
        if (Objects.nonNull(command) && !command.trim().equals("")) {
            return true;
        } else {
            throw new IllegalArgumentException("Cron command can not be null or blank");
        }
    }

    @Override
    public String print(){
        String prinString = String.format(PRINT_FORMAT, name, command);
        System.out.print(prinString);
        return prinString;
    }

}
