package timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Author joker
 * Created on 2017-02-21.
 * Description
 */
public class TimerManager {
    private TimerManager(){
        timer = new Timer();
    }

    private static TimerManager instance = new TimerManager();

    public static TimerManager getInstance(){
        return instance;
    }

    private Timer timer;
    //时间间隔(一天)
    public static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

    public static final long PERIOD_FIVE_MINUTE=5 * 60 * 1000;//三晶采集器数据5分钟获取一次
    public static final long PERIOD_TWO_HOUR=2 * 60 * 60 * 1000;//三晶采集器两小时获取一次token


    /**
     * Author joker
     * Date 2017-02-21 21:32
     * Description 周期TimerTask
     * Params hour,执行时间
     * Params task,执行任务
     * Params period,执行周期
     */
    public void runTimeTask(int hour, int minute, int second, TimerTask task, long period){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        Date date=calendar.getTime(); //第一次执行定时任务的时间
        //如果第一次执行定时任务的时间 小于当前的时间
        //此时要在 第一次执行定时任务的时间加一天，以便此任务在下个时间点执行。如果不加一天，任务会立即执行。
        if (date.before(new Date())) {
            date = addDay(date, 1);
        }
        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。
        timer.schedule(task,date,period);
    }

    public void runTimeTask(TimerTask timerTask, long period){
        timer.schedule(timerTask,new Date(), period);
    }

    public void cancel(){
        timer.cancel();
    }

    // 增加或减少天数
    public Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.DAY_OF_MONTH, num);
        return startDT.getTime();
    }

}
