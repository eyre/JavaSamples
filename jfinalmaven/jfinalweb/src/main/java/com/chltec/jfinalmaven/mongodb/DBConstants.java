package com.chltec.jfinalmaven.mongodb;

import com.chltec.jfinalmaven.common.utils.DateUtils;

import java.sql.Timestamp;

/**
 * Author joker
 * Created on 2017/7/14.
 * Description
 */
public class DBConstants {

    public static final String TABLE_STATION_LOG_NAME = "station_logs";

    public static String getStationLogTableNameOfDay(String ymdDay){
        return TABLE_STATION_LOG_NAME+"-"+ ymdDay;
    }

    public static String getStationLogTableNameOfDay(Timestamp day){
        return TABLE_STATION_LOG_NAME+"-"+ DateUtils.getYMDOfTimeStamp(day);
    }
}
