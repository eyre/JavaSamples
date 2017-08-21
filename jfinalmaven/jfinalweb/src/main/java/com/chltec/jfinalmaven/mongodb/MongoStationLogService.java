package com.chltec.jfinalmaven.mongodb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chltec.jfinalmaven.ConfigUtil;
import com.cybermkd.mongo.kit.MongoQuery;
import com.cybermkd.mongo.kit.aggregation.MongoAccumulator;
import com.cybermkd.mongo.kit.aggregation.MongoAggregation;
import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Author joker
 * Created on 2017/7/18.
 * Description 使用mongodb存储的StationLog Service
 */
public class MongoStationLogService {
    private static final Logger logger = LoggerFactory.getLogger(MongoStationLogService.class);

    /**
     * 添加stationLog
     * @param stationLogBean stationLog实体
     */
    public static void addStationLog(StationLogBean stationLogBean){
        MongoQuery query=new MongoQuery();

//        boolean result = query.use(DBConstants.getStationLogTableNameOfDay(stationLogBean.getLog_time())).set(stationLogBean).save();
        boolean result = query.use(DBConstants.getStationLogTableNameOfDay(stationLogBean.getLog_time()))
                .set(stationLogBean)
//                .set("active_power", stationLogBean.getActive_power())
                .save();
        if(!result){
            logger.error("保存stationLog失败:"+stationLogBean.getStation_id()+","+stationLogBean.getLog_time());
        }
    }

    public static List<StationLogBean> queryStationLogsOfDay(String stationId, String ymdDay){
        MongoQuery query=new MongoQuery();
        List<StationLogBean> stationLogBeans = query.use(DBConstants.getStationLogTableNameOfDay(ymdDay)).eq("station_id",stationId).ascending("log_time").find(StationLogBean.class);
        return stationLogBeans;
    }

    /**
     * 获取根据条件筛选电站的实时功率之和的列表
     * @param agent_id 代理商id
     * @param province 省份
     * @param city  城市
     * @param district  区县
     * @return List<StationLogBean>
     */
    public static List<StationLogBean> getRealTimePower(int agent_id, String province,String city, String district){
        List<StationLogBean> totalStationLogBeanList = getBaseStationLogList();
        totalStationLogBeanList.forEach(stationLogBean -> {
            getTotalPowerOfTimeStamp(stationLogBean.getLog_time());
        });
        return totalStationLogBeanList;
    }

    /**
     * 获取某个时间点的总功率
     * @param timestamp timestamp
     * @return total_power
     */
    public static void getTotalPowerOfTimeStamp(Timestamp timestamp){
        logger.info("timestamp:"+timestamp);
        MongoQuery query=new MongoQuery();
        List<StationLogBean> stationLogBeans = query.use(DBConstants.getStationLogTableNameOfDay(timestamp)).eq("log_time",timestamp).find(StationLogBean.class);
//        logger.info("stationLogs:"+stationLogBeans);
        query.use(DBConstants.getStationLogTableNameOfDay(timestamp)).eq("log_time",timestamp);
        MongoAggregation aggregation=new MongoAggregation(query);
        List<JSONObject> jsonObject = aggregation
                .group("log_time",new MongoAccumulator().sum("total_power","$active_power")).aggregate();
        double total_power = jsonObject.get(0).getDouble("total_power");
        logger.info(JSON.toJSONString(jsonObject));

    }

    /**
     * 改变为标准日志时间格式(向前看齐)
     * @param timestamp timestamp
     * @return timestamp
     * 8:03:35 -->8:00:00
     * 8:21:35 -->8:20:00
     * 8:28:32 -->8:25:00
     * 8:58:32 -->8:55:00
     */
    public static Timestamp changeFloorLogTime(Timestamp timestamp){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp.getTime());
        int minute = calendar.get(Calendar.MINUTE);
        int floorMinute = (minute/5) *5;
        calendar.set(Calendar.MINUTE, floorMinute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 合并两个按log_time升序排序的List<StationLogBean>
     * @param stationLogBeanList1 List<StationLogBean>
     * @param stationLogBeanList2 List<StationLogBean>
     * @return List<StationLogBean>
     */
    public static List<StationLogBean> mergeStationLogBeanList(List<StationLogBean> stationLogBeanList1, List<StationLogBean> stationLogBeanList2){
        for(StationLogBean stationLogBeanItem : stationLogBeanList1){
            StationLogBean latestStationLogBean = findLatestStationLogBean(stationLogBeanItem,stationLogBeanList2);//寻找最接近的StationLogBean
            double sumPower = stationLogBeanItem.getActive_power();
            if(latestStationLogBean != null){
                sumPower += latestStationLogBean.getActive_power();
            }
            stationLogBeanItem.setActive_power(sumPower);
        }

        return stationLogBeanList1;
    }

    /**
     * 获取当前时间向前推8个小时的基础StationLogBeanList
     * @return List<StationLogBean>
     */
    public static List<StationLogBean> getBaseStationLogList(){
        List<StationLogBean> baseStationLogBeanList = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,now.get(Calendar.HOUR_OF_DAY)-14);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND,0);

        while (calendar.before(now)){
            StationLogBean stationLogBean = new StationLogBean();
            stationLogBean.setLog_time(new Timestamp(calendar.getTimeInMillis()));
            stationLogBean.setActive_power(0.0);
            baseStationLogBeanList.add(stationLogBean);

            calendar.add(Calendar.MINUTE, 20);
        }
        return baseStationLogBeanList;
    }

    /**
     * 获取几点到几点的基础StationLogList
     * @param start_hour 开始时间
     * @param end_hour 结束时间
     * @return List<StationLogBeam>
     */
    // TODO: 2017/7/21 添加哪天
    public static List<StationLogBean> getBaseStationLogList(Timestamp day, int start_hour, int end_hour){
        List<StationLogBean> baseStationLogList = new ArrayList<>();

        Calendar start = Calendar.getInstance();
        start.setTimeInMillis(day.getTime());
        start.set(Calendar.HOUR_OF_DAY,start_hour);
        start.set(Calendar.MINUTE, 0);
        start.set(Calendar.SECOND,0);

        Calendar end = Calendar.getInstance();
        end.setTimeInMillis(day.getTime());
        end.set(Calendar.HOUR_OF_DAY,end_hour);
        end.set(Calendar.MINUTE, 0);
        end.set(Calendar.SECOND,0);

        while (start.before(end)){
            StationLogBean stationLog = new StationLogBean();
            stationLog.setLog_time(new Timestamp(start.getTimeInMillis()));
            stationLog.setActive_power(0.0);
            baseStationLogList.add(stationLog);

            start.add(Calendar.MINUTE, 20);
        }
        return baseStationLogList;
    }

    /**
     * 在stationLogBeanList中寻找和stationLogBean中记录时间最接近的一个,且时间差小于20分钟
     * stationLogBeanList已按log_time升序排序
     * @param stationLogBean 参考stationLogBean
     * @param stationLogBeanList stationLogBeanList
     */
    private static StationLogBean findLatestStationLogBean(StationLogBean stationLogBean, List<StationLogBean> stationLogBeanList){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(stationLogBean.getLog_time().getTime());
        calendar.add(Calendar.MINUTE,-20);
        Timestamp logTimeMinus20 = new Timestamp(calendar.getTimeInMillis());

        for(int i=stationLogBeanList.size()-1;i>=0;i--){
            if(stationLogBeanList.get(i).getLog_time().before(stationLogBean.getLog_time())
                    && stationLogBeanList.get(i).getLog_time().after(logTimeMinus20)){
                return stationLogBeanList.get(i);
            }
        }
        return null;
    }

}
