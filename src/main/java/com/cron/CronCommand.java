package com.cron;

import java.util.Objects;

import com.print.CronPrinter;
import com.validators.CronValidator;

public class CronCommand implements CronValidator,CronPrinter {

    private String name;
    private String command;

    

    /**
     * @param name
     * @param command
     */
    public CronCommand(String name, String command) {
        this.name = name;
        this.command = command;
    }

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
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command the command to set
     */
    public void setCommand(String command) {
        this.command = command;
    }

    

}
