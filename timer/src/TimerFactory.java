import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import quartz.PrintTimeJob;
import timer.TimerManager;

import java.util.Date;
import java.util.TimerTask;

/**
 * Author joker
 * Created on 2017/7/4.
 * Description
 */
public class TimerFactory {
    public void runTimerTask(){
        TimerManager.getInstance().runTimeTask(new TimerTask() {
            @Override
            public void run() {
                System.out.println("thread name:"+Thread.currentThread().getName()+",date:"+new Date());
                try {
                    Thread.sleep(7 *1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                throw new RuntimeException();
            }
        }, 3*1000);

        TimerManager.getInstance().runTimeTask(new TimerTask() {
            @Override
            public void run() {
                System.out.println("thread name:"+Thread.currentThread().getName()+",date2:"+new Date());
                try {
                    Thread.sleep(10 *1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 3*1000);
//        try {
//            Thread.sleep(60 *1000);
//            TimerManager.getInstance().cancel();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void runQuartzTask(){
        JobDetail jobDetail = JobBuilder.newJob(PrintTimeJob.class).withIdentity("printTimeJob","group1").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("printTimeTrigger","group1")
                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();

            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
