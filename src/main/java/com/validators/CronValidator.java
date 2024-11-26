package com.validators;

import com.parser.CronSpecialChars;

public interface CronValidator extends CronSpecialChars {

    public boolean validate();

    public default boolean validate(String vals, int min, int max) {
        //If cron expression contains ',' , means it has multiple values, in this case vaidate all e.g. 1,2
        for (String val : vals.split(",")) {
            if (isStarVal.test(val)) {
                // if single '*' then its valid value and return true; e.g '*'
                return true;
            } else if (isHyphenVal.test(val)) {
                // If value contains '-' , then its range and validate the range value , e.g 1-31
                var range = getRange(val,min, "-");
                return isValidRange(range[0], range[1], min, max);
            } else if (isForwardSlashVal.test(val)) {
                // If value contains '/' then validate if its between range e.g. */12 , 
                var range = getRange(val,min, "/");
                return isValidRange(range[0], range[1], min, max);
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
