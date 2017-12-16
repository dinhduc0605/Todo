package com.ducnd.todo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nguyendinhduc on 15/12/2017.
 */

public class DateUtil {
    public static final String DATE_FORMAT_1 = "dd-MM-yyyy HH:mm";
    public static String formatDate(Date date, String formatType){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatType);
        return simpleDateFormat.format(date);
    }
}
