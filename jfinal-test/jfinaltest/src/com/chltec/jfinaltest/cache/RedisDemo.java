package com.chltec.jfinaltest.cache;

import com.jfinal.plugin.ehcache.CacheKit;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;

/**
 * Author joker
 * Created on 2017/7/17.
 * Description
 */
public class RedisDemo {
    public static String execute(){
        Cache redisCache = Redis.use("redis");
        redisCache.set("name","joker");
        redisCache.expire("name",20);
        String name = redisCache.get("name");
        System.out.println("put redis name:"+name);

        try {
            Thread.sleep(30*1000);
            String name30s = redisCache.get("name");
            System.out.println("after 30s cache name:"+name30s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return name;
    }
}
