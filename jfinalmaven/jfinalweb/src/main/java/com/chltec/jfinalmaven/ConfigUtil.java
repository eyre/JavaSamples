package com.chltec.jfinalmaven;

import com.jfinal.kit.PropKit;

/**
 * Author joker
 * Created on 2017/7/20.
 * Description 获取配置
 */
public class ConfigUtil {
    private static String getConfigFileName(){
        String env = PropKit.use("env.properties").get("env");
        return "config_"+env+".properties";
    }

    public static String get(String key){
        return PropKit.use(getConfigFileName()).get(key);
    }

    public static Integer getInt(String key){
        return PropKit.use(getConfigFileName()).getInt(key);
    }

    public static Long getLong(String key){
        return PropKit.use(getConfigFileName()).getLong(key);
    }

    public static Boolean getBoolean(String key){
        return PropKit.use(getConfigFileName()).getBoolean(key);
    }
}
