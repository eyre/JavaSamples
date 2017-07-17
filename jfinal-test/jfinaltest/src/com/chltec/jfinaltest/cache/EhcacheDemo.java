package com.chltec.jfinaltest.cache;

import com.jfinal.plugin.ehcache.CacheKit;

/**
 * Author joker
 * Created on 2017/7/17.
 * Description
 */
public class EhcacheDemo {
    public static String execute(){
        CacheKit.put("cache","name","joker");
        String name = CacheKit.get("cache","name");
        System.out.println("put cache name:"+name);

        try {
            Thread.sleep(30*1000);
            String name30s = CacheKit.get("cache","name");
            System.out.println("after 30s cache name:"+name30s);

            Thread.sleep(63*1000);
            String name60s = CacheKit.get("cache","name");
            System.out.println("after 63s cache name:"+name60s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return name;
    }
}
