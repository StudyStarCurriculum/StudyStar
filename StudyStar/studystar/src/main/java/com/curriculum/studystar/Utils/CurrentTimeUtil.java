package com.curriculum.studystar.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeUtil {
    public static String getCurrnetTime() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        return f.format(date);
    }
}
