package com.chltec.jfinaltest.config;

import com.chltec.jfinaltest.controller.IndexController;
import com.chltec.jfinaltest.quartz.TestJob;
import com.jfinal.config.*;
import com.jfinal.ext.plugin.cron.Cron4jPlugin;
import com.jfinal.ext.plugin.jms.JmsPlugin;
import com.jfinal.ext.plugin.quartz.QuartzPlugin;
import com.jfinal.ext.plugin.shiro.ShiroPlugin;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Author joker
 * Created on 2017/7/5.
 * Description
 */
public class TestJfinalConfig extends JFinalConfig{
    @Override
    public void configConstant(Constants constants) {
        PropKit.use("jdbc.properties");
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/",IndexController.class);
    }

    @Override
    public void configPlugin(Plugins plugins) {
//        C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"),
//                PropKit.get("user"),
//                PropKit.get("password"));
//        plugins.add(c3p0Plugin);
//
//        QuartzPlugin quartzPlugin = new QuartzPlugin("job");
//        plugins.add(quartzPlugin);

//        Cron4jPlugin cron4jPlugin = new Cron4jPlugin();
//        plugins.add(cron4jPlugin);
//
//        JmsPlugin jmsPlugin = new JmsPlugin();
//        plugins.add(jmsPlugin);

        //Ehcache plugin
        plugins.add(new EhCachePlugin(PathKit.getRootClassPath()+"/ehcache.xml"));
//        //Redis plugin
//        String redisHost = PropKit.use("redis.properties").get("redis.host");
//        int redisPort = PropKit.use("redis.properties").getInt("redis.port");
//        RedisPlugin redisPlugin = new RedisPlugin("redis",redisHost,redisPort);
//        plugins.add(redisPlugin);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }

    @Override
    public void afterJFinalStart() {
//        JobDetail jobDetail = JobBuilder.newJob(TestJob.class).withIdentity("printTimeJob","group1").build();
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("printTimeTrigger","group1")
//                .startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever()).build();
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        try {
//            Scheduler scheduler = schedulerFactory.getScheduler();
//            scheduler.start();
//
//            scheduler.scheduleJob(jobDetail, trigger);
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
    }
}
