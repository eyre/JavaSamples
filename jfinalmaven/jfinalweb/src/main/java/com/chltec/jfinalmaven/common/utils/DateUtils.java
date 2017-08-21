package com.chltec.jfinalmaven.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具
 *
 * @author malongbo
 */
public final class DateUtils {


    /**
     * 获得当前时间
     * 格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String getNowTime() {
        Date nowday = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 精确到秒
        String time = sdf.format(nowday);
        return time;
    }

    /**
     * 获取当前系统时间滴答ms
     *
     * @return long
     */
    public static Long getNowTimeMills() {
        return System.currentTimeMillis();
    }

    /**
     * 获取当前系统时间戳
     *
     * @return timestamp
     */
    public static Timestamp getNowTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }

    public static String getCurrentYear() {
        return getLocalDate().getYear() + "";
    }

    public static int getCurrentMonthOfYear(){
        return getLocalDate().getMonthValue();
    }

    public static int getCurrentDayOfMonth(){
        return getLocalDate().getDayOfMonth();
    }

    public static String getCurrentYM() {
        StringBuilder builder = new StringBuilder();
        LocalDate localDate = getLocalDate();
        builder.append(localDate.getYear() + "");
        builder.append("-");
        builder.append((localDate.getMonthValue() + ""));
        return builder.toString();
    }

    public static String getCurrentYMD() {
        StringBuilder builder = new StringBuilder();
        LocalDate localDate = getLocalDate();
        builder.append(localDate.getYear() + "");
        builder.append("-");
        builder.append((localDate.getMonthValue() + ""));
        builder.append("-");
        builder.append(localDate.getDayOfMonth() + "");
        return builder.toString();
    }

    /**
     * 获取当天0点时间戳
     *
     * @return timestamp
     */
    public static Timestamp getTodayTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取当天23点59分时间戳
     *
     * @return timestamp
     */
    public static Timestamp getTodayEndTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DAY_OF_MONTH,1);

        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取当月第一天0点时间戳
     *
     * @return timestamp
     */
    public static Timestamp getMonthTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取当年第一月第一天0点时间戳
     *
     * @return timestamp
     */
    public static Timestamp getYearTimeStamp() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * timestamp add day
     *
     * @return timestamp
     */
    public static Timestamp addDay(Timestamp timestamp, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.add(Calendar.DAY_OF_MONTH, value);

        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * timestamp sub day
     *
     * @return timestamp
     */
    public static Timestamp subDay(Timestamp timestamp, int value) {
        return addDay(timestamp, 0 - value);
    }

    public static Long getNowDateTime() {
        return new Date().getTime() / 1000;
//        return new Date().getTime()/1000;
    }

    /**
     * timestamp add day
     *
     * @return timestamp
     */
    public static Timestamp addMonth(Timestamp timestamp, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.add(Calendar.MONTH, value);

        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * timestamp add day
     *
     * @return timestamp
     */
    public static Timestamp addYear(Timestamp timestamp, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.add(Calendar.YEAR, value);

        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * timestamp add hour
     *
     * @return timestamp
     */
    public static Timestamp addHour(Timestamp timestamp, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.add(Calendar.HOUR_OF_DAY, value);

        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * timestamp add MINUTE
     *
     * @return timestamp
     */
    public static Timestamp addMinute(Timestamp timestamp, int value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.add(Calendar.MINUTE, value);

        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp subMinute(Timestamp timestamp, int value) {
        return addMinute(timestamp, 0-value);
    }

    /**
     * 自定义日期格式
     *
     * @param format
     * @return
     */
    public static String getNowTime(String format) {
        Date nowday = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);// 精确到秒
        String time = sdf.format(nowday);
        return time;
    }

    /**
     * 将时间字符转成Unix时间戳
     *
     * @param timeStr
     * @return
     * @throws ParseException
     */
    public static Long getTime(String timeStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 精确到秒
        Date date = sdf.parse(timeStr);
        return date.getTime() / 1000;
    }

    /**
     * 将Unix时间戳转成时间字符
     *
     * @param timestamp
     * @return
     */
    public static String getTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 精确到秒
        Date date = new Date(timestamp * 1000);
        return sdf.format(date);
    }

    /**
     * 获取半年后的时间
     * 时间字符格式为：yyyy-MM-dd HH:mm:ss
     *
     * @return 时间字符串
     */
    public static String getHalfYearLaterTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 精确到秒

        Calendar calendar = Calendar.getInstance();
        int currMonth = calendar.get(Calendar.MONTH) + 1;

        if (currMonth >= 1 && currMonth <= 6) {
            calendar.add(Calendar.MONTH, 6);
        } else {
            calendar.add(Calendar.YEAR, 1);
            calendar.set(Calendar.MONTH, currMonth - 6 - 1);
        }

        return sdf.format(calendar.getTime());
    }

    /**
     * Author joker
     * Date 2017-02-21 11:54
     * Description 获取timestamp月初时间
     */
    public static Timestamp getMonthStartOfTimestamp(Timestamp timestamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * Author joker
     * Date 2017-02-21 11:54
     * Description 获取timestamp月底时间
     */
    public static Timestamp getMonthEndOfTimestamp(Timestamp timestamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH)+1);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * Author joker
     * Date 2017-02-21 11:54
     * Description 获取timestamp月初时间
     */
    public static Timestamp getYearStartOfTimestamp(Timestamp timestamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * Author joker
     * Date 2017-02-21 11:54
     * Description 获取timestamp月底时间
     */
    public static Timestamp getYearEndOfTimestamp(Timestamp timestamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        calendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR)+1);
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * Author joker
     * Date 2017-02-23 16:22
     * Description 获取年字符串
     */
    public static String getYearOfTimeStamp(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        return calendar.get(Calendar.YEAR)+"";
    }

    /**
     * Author joker
     * Date 2017-02-23 16:22
     * Description 获取年-月字符串
     */
    public static String getYMOfTimeStamp(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        int month = calendar.get(Calendar.MONTH)+1;
        String monthStr = month<10?"0"+month:""+month;
        return calendar.get(Calendar.YEAR)+"-"+monthStr;
    }

    /**
     * Author joker
     * Date 2017-02-23 16:22
     * Description 获取年-月-日字符串
     */
    public static String getYMDOfTimeStamp(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        int month = calendar.get(Calendar.MONTH)+1;
        String monthStr = month<10?"0"+month:""+month;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String dayStr = day<10?"0"+day:""+day;

        return calendar.get(Calendar.YEAR)+"-"+monthStr+"-"+dayStr;
    }

    public static Timestamp getTimeStampOfYMD(String ymdTime) {
        String []ymdArray = ymdTime.split("-");
        int year = Integer.parseInt(ymdArray[0]);
        int month = Integer.parseInt(ymdArray[1]);
        int day = Integer.parseInt(ymdArray[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * Author joker
     * Date 2017-02-23 16:22
     * Description 获取时分字符串
     */
    public static String getHMOfTimeStamp(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        String hourStr = hour<10?"0"+hour:""+hour;
        int minute = calendar.get(Calendar.MINUTE);
        String minuteStr = minute<10?"0"+minute:""+minute;

        return hourStr+":"+minuteStr;
    }

    /**
     * Author joker
     * Date 2017/7/12 下午9:24
     * Description 获取当月指定日的timestamp
     */
    public static Timestamp getDayOfMonthTimeStamp(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return new Timestamp(calendar.getTimeInMillis());
    }
}
