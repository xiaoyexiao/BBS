package com.library.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：Vizzk
 * @description：TODO
 * @date ：2021/4/1 16:27
 */
public class Util {
    //获取date到今天相隔天数
    public static int getDaysTtilNow(Date date){
        Date today = new Date();
        long days = (today.getTime() - date.getTime())/(24*60*60*1000);
        return (int)days;
    }

    public static int getRestDay(Date date,int rest){
        return rest - getDaysTtilNow(date);
    }

    public static String getDeadline(String date,int rest) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(df.parse(date));
        cal.add(Calendar.DAY_OF_MONTH, rest);
        return df.format(cal.getTime());
    }
}
