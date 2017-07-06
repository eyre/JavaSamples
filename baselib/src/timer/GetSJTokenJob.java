package timer;

import config.SJConfig;
import http.ssl.IgnoreSSLFactory;
import net.sf.json.JSONObject;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
        System.out.println("获取三晶Token:");
        String sjTokenUrl = String.format("https://api.saj-solar.com/accessToken?client_id=%s&client_secret=%s&grant_type=%s",
                SJConfig.client_id,SJConfig.client_secret,SJConfig.grant_type);
//        String gmmUrl = "https://app.sz-zoomlight.com/";
        System.out.println(sjTokenUrl);

        OkHttpClient okHttpClient = IgnoreSSLFactory.getIgnoreSSLHttpClient();

        Request request = new Request.Builder()
                .url(sjTokenUrl)
                .build();

        try {
            if(okHttpClient == null){
                throw new RuntimeException("获取OkHttpClient失败！");
            }
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("服务器端错误: " + response);
            }

            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }

            String result = response.body().string();
            JSONObject jsonObject = JSONObject.fromObject(result);
            JSONObject data = jsonObject.getJSONObject("data");
            SJConfig.access_token = data.getString("access_token");
            System.out.println("access token:"+SJConfig.access_token);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
