package com.chltec.jfinalmaven;

import com.cybermkd.mongo.plugin.MongoJFinalPlugin;
import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

/**
 * Author joker
 * Created on 2017/7/27.
 * Description
 */
public class DemoConfig extends JFinalConfig{
    @Override
    public void configConstant(Constants constants) {

    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/",HelloController.class);
    }

    @Override
    public void configPlugin(Plugins plugins) {
        C3p0Plugin c3p0Plugin = new C3p0Plugin(ConfigUtil.get("jdbc.url"), ConfigUtil.get("jdbc.user"), ConfigUtil.get("jdbc.password"));
        plugins.add(c3p0Plugin);

        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0Plugin);
        plugins.add(activeRecordPlugin);

        configMongoDBPlugin(plugins);
    }

    private void configMongoDBPlugin(Plugins plugins){
        MongoJFinalPlugin mongoJFinalPlugin = new MongoJFinalPlugin();
        String mongoHost = ConfigUtil.get("mongo.host");
        int mongoPort = ConfigUtil.getInt("mongo.port");
        String mongoDbName = ConfigUtil.get("mongo.db");
        String username = ConfigUtil.get("mongo.user");
        String password = ConfigUtil.get("mongo.password");
        mongoJFinalPlugin.add(mongoHost,mongoPort);
        mongoJFinalPlugin.setDatabase(mongoDbName);
//        mongoJFinalPlugin.auth(username,password);
        plugins.add(mongoJFinalPlugin);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
