package com.chltec.jfinaltest.controller;

import com.chltec.jfinaltest.cache.EhcacheDemo;
import com.chltec.jfinaltest.cache.RedisDemo;

/**
 * Author joker
 * Created on 2017/7/4.
 * Description
 */
public class IndexController extends BaseController{
    public void index(){
        respondSuccess();
    }

    public void cache(){
        String result = EhcacheDemo.execute();
        respond(result);
    }

    public void redis(){
        RedisDemo.execute();
        respondSuccess();
    }
}
