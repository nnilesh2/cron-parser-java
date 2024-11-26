package com.print;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.parser.CronSpecialChars;

public interface  CronPrinter extends  CronSpecialChars{

    public static final String PRINT_FORMAT = "%-14s%s%n";

    public String print();

    public default String getPrintValue(String vals, int min, int max) {
        for (String val : vals.split(",")) {
            if (isStarVal.test(val)) {
                return IntStream.rangeClosed(min, max).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            } else if (isHyphenVal.test(val)) {
                // If value contains '-' , then get its range  e.g 1-31
                var range = getRange(val,min, "-");
                return IntStream.rangeClosed(range[0], range[1]).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            } else if (isForwardSlashVal.test(val)) {
                // If value contains '/' then validate if its between range e.g. */12 , 
                var range = getRange(val,min, "/");
                // return the increamental values till reaches end val
                return IntStream.rangeClosed(range[0], max).filter(i-> i % range[1]==0).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            } else {
                // if its single value, return it as is
               return val;
            }
        }
        return "";
    }

}
