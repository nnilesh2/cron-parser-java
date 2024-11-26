package com.cron;

import java.util.Objects;

import com.validators.CronValidator;

public record CronCommand(String command) implements CronValidator {

    @Override
    public boolean validate() {
        if (Objects.nonNull(command) && !command.trim().equals("")) {
            return true;
        } else {
            throw new IllegalArgumentException("Cron command can not be null or blank");
        }
    }

}
