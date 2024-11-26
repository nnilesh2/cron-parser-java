package com.print;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.parser.CronSpecialChars;

public interface  CronPrinter extends  CronSpecialChars{

    public static final String PRINT_FORMAT = "%-14s%s%n";

    public String print();

    public default String getPrintValue(String vals, int min, int max) {
        var printValList = new ArrayList<String>();
        for (String val : vals.split(",")) {
            if (isStarVal.test(val)) {
                printValList.addAll(IntStream.rangeClosed(min, max).mapToObj(String::valueOf).collect(Collectors.toList()));
            } else if (isHyphenVal.test(val)) {
                // If value contains '-' , then get its range  e.g 1-31
                var range = getRange(val,min, "-");
                printValList.addAll(IntStream.rangeClosed(range[0], range[1]).mapToObj(String::valueOf).collect(Collectors.toList()));
            } else if (isForwardSlashVal.test(val)) {
                // If value contains '/' then validate if its between range e.g. */12 , 
                var range = getRange(val,min, "/");
                // return the increamental values till reaches end val
                printValList.addAll(IntStream.rangeClosed(range[0], max).filter(i-> i % range[1]==0).mapToObj(String::valueOf).collect(Collectors.toList()));
            } else {
                // if its single value, return it as is
                printValList.add(val);
            }
        }
        return printValList.stream().collect(Collectors.joining(" "));
    }

}
