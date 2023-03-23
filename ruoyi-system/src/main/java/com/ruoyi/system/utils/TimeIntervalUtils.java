package com.ruoyi.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间区间工具类
 *
 * @author Krson
 * @date 2022/4/9 17:14
 */
public class TimeIntervalUtils {

    static final SimpleDateFormat hoursFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
    static final SimpleDateFormat daysFormat = new SimpleDateFormat("yyyy-MM-01 00:00:00");
    static final SimpleDateFormat monthsFormat = new SimpleDateFormat("yyyy-01-01 00:00:00");

    /**
     * 当天的小时时间集
     *
     * @return
     * @throws ParseException
     */
    public static List<Date> ofHours() throws ParseException {
        List<Date> list = new ArrayList<>();
        Date now = new Date();
        String s = hoursFormat.format(now);
        Date date = hoursFormat.parse(s);
        list.add(date);
        for (int i = 0; i < 23; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.HOUR, 1);
            date = cal.getTime();
            list.add(date);
        }
        return list;
    }

    /**
     * 当月的天数时间集
     *
     * @return
     * @throws ParseException
     */
    public static List<Date> ofDays() throws ParseException {
        List<Date> list = new ArrayList<>();
        Date now = new Date();
        String s = daysFormat.format(now);
        Date date = daysFormat.parse(s);
        list.add(date);
        int size = getMonthOfDay();
        for (int i = 0; i < size - 1; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_WEEK, 1);
            date = cal.getTime();
            list.add(date);
        }
        return list;
    }

    /**
     * 一年的月份时间集合
     *
     * @return
     * @throws ParseException
     */
    public static List<Date> ofMonths() throws ParseException {
        List<Date> list = new ArrayList<>();
        Date now = new Date();
        String s = monthsFormat.format(now);
        Date date = monthsFormat.parse(s);
        list.add(date);
        for (int i = 0; i < 11; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, 1);
            date = cal.getTime();
            list.add(date);
        }
        return list;
    }

    /**
     * 两个时间区间中的天数集合
     */
    public static List<Date> ofTwoDaysList(String startTime,String endTime) throws ParseException {
        List<Date> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse(startTime);
        Date endDate = sdf.parse(endTime);
        Calendar calendar = Calendar.getInstance();
        while (startDate.getTime() <= endDate.getTime()){
            list.add(startDate);
            calendar.setTime(startDate);
            calendar.add(Calendar.DATE,1);
            startDate = calendar.getTime();
        }
        return list;
    }
    //小时
    public static List<String> getHoursName(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            list.add(i + "点");
        }
        return list;
    }
    //天数
    public static List<String> getDaysName(){
        List<String> list = new ArrayList<>();
        int size = getMonthOfDay();
        for (int i = 0; i < size; i++) {
            list.add((i+1) + "号");
        }
        return list;
    }
    //月份
    public static List<String> getMonthsName(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add((i+1) + "月");
        }
        return list;
    }


    /**
     * 获取当月的台天数
     *
     * @return
     */
    private static int getMonthOfDay() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
}
