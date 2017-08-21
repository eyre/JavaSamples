package com.chltec.jfinalmaven;

import com.alibaba.fastjson.JSONObject;
import com.chltec.jfinalmaven.common.utils.DateUtils;
import com.chltec.jfinalmaven.mongodb.DBConstants;
import com.chltec.jfinalmaven.mongodb.MongoStationLogService;
import com.chltec.jfinalmaven.mongodb.StationLogBean;
import com.cybermkd.mongo.kit.MongoQuery;
import com.cybermkd.mongo.kit.aggregation.MongoAccumulator;
import com.cybermkd.mongo.kit.aggregation.MongoAggregation;
import com.jfinal.core.Controller;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 * Author joker
 * Created on 2017/7/27.
 * Description
 */
public class HelloController extends Controller{
    public void index(){
        renderText("hello world");
    }

    public void mongo(){
        renderJson(MongoStationLogService.queryStationLogsOfDay("15020G1722CN16740","2017-08-11"));
    }

    public void realtime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017,Calendar.AUGUST,13,7,40, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        MongoStationLogService.getTotalPowerOfTimeStamp(new Timestamp(calendar.getTimeInMillis()));

//        MongoQuery query=new MongoQuery();
//        query.use("test");
//        MongoAggregation aggregation=new MongoAggregation(query);
//        List<JSONObject> jsonObject = aggregation
//                .group("item",new MongoAccumulator()
//                                .sum("sum_price","$price")
//                                .avg("avg_price","$price")
//                                .max("max_price","$price")
//                ).aggregate();
        renderJson();
    }

    public void addlog(){
        StationLogBean stationLogBean = new StationLogBean();
        stationLogBean.setActive_power(2.5);
        stationLogBean.setTotal_energy(33.5);
        stationLogBean.setStation_id("111");
        stationLogBean.setLog_time(MongoStationLogService.changeFloorLogTime(DateUtils.getNowTimeStamp()));
        MongoStationLogService.addStationLog(stationLogBean);
        renderJson();
    }
}
