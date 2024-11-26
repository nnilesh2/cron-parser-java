package com.validators;

public interface CronValidator {

    public boolean validate();

    public default boolean validate(String vals, int min, int max) {
        //If cron expression contains ',' , means it has multiple values, in this case vaidate all
        for (String val : vals.split(",")) {
            if ("*".equals(val)) {
                // if single '*' then its valid value and return true; e.g '*'
                return true;
            } else if (val.contains("-")) {
                // If value contains '-' , then its range and validate the range value , e.g 1-31
                String[] range = val.split("-");
                int start = Integer.parseInt(range[0]);
                int end = Integer.parseInt(range[1]);
                return isValidRange(start, end, min, max);
            } else if (val.contains("/")) {
                // If value contains '/' then validate if its between range e.g. */12 , 
                String[] range = val.split("/");
                int start = range[0].equals("*") ? min : Integer.parseInt(range[0]);
                int end = Integer.parseInt(range[1]);
                return isValidRange(start, end, min, max);
            } else {
                // if its single value, then it must be within range of valida values
                int singleValue = Integer.parseInt(val);
                return validateSingleValue(singleValue, min, max);
            }
        }
        
        return false;
    }

    private boolean validateSingleValue(int singleValue, int min, int max) {
        return singleValue >= min && singleValue <= max;
    }

    private boolean isValidRange(int start, int end, int min, int max) {
        return start >= min && end <= max && start < end;
    }

}
