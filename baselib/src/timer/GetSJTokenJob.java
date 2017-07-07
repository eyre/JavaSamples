package timer;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;
import config.SJConfig;
import http.ssl.IgnoreSSLFactory;
import net.sf.json.JSONObject;
import okhttp3.*;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.IOException;

/**
 * Author joker
 * Created on 2017/7/5.
 * Description 获取三晶服务器token
 */
public class GetSJTokenJob implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String sjTokenUrl = String.format("https://api.saj-solar.com/accessToken?client_id=%s&client_secret=%s&grant_type=%s",
                SJConfig.client_id, SJConfig.client_secret, SJConfig.grant_type);
        System.out.println("获取三晶Token:" + sjTokenUrl);

        OkHttpUtils.get()
                .url(sjTokenUrl)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int i) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onResponse(String result, int i) {
                        JSONObject jsonObject = JSONObject.fromObject(result);
                        JSONObject data = jsonObject.getJSONObject("data");
                        SJConfig.access_token = data.getString("access_token");
                        System.out.println("access token:" + SJConfig.access_token);
                    }
                });

    }
}
