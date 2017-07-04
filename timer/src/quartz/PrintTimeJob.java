package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

/**
 * Author joker
 * Created on 2017/7/4.
 * Description
 */
public class PrintTimeJob implements Job{
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("thread name:"+Thread.currentThread().getName()+",date:"+new Date());
        try {
            Thread.sleep(7 *1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
