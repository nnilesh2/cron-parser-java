package com.parser;

import java.util.function.Predicate;

public interface  CronSpecialChars {

    Predicate<String> isStarVal = val->"*".equals(val);

    Predicate<String> isHyphenVal = val -> val.contains("-");

    Predicate<String> isForwardSlashVal = val -> val.contains("/");

    public default  int[] getRange(String value,int min, String splitBy){
        String[] range = value.split(splitBy);
        int start = range[0].equals("*") ? min : Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);
        return new int[] {start,end};
    }

}
