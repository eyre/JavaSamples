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
import java.util.Date;
import java.util.List;

/**
 * Author joker
 * Created on 2017/7/5.
 * Description 获取三晶服务器数据
 */
public class GetSJDatasJob implements Job{

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String device_id = "10095648";
        String start_date = "2017-07-06T07:00:00Z";
        String end_date = "2017-07-06T21:50:00Z";
        System.out.println("获取三晶服务器数据:"+new Date());
        String sjGetInverterUrl = String.format("https://api.saj-solar.com/device/inverter/data?device_id=%s&start_date=%s&end_date=%s&perpage=%s",
                device_id,start_date,end_date,1000);
//        String gmmUrl = "https://app.sz-zoomlight.com/";
        System.out.println(sjGetInverterUrl);

        try {

            OkHttpUtils
                    .get()
                    .url(sjGetInverterUrl)
                    .addHeader("token",SJConfig.access_token)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int i) {
                            e.printStackTrace();
                            System.out.println(i);
                        }

                        @Override
                        public void onResponse(String s, int i) {
                            System.out.println(s+",i:"+i);
                        }
                    });

//            if(SJConfig.access_token == null){
//                throw new RuntimeException("access_token 为空！");
//            }
//
//            Request request = new Request.Builder()
//                    .url(sjGetInverterUrl)
//                    .addHeader("token",SJConfig.access_token)
//                    .build();
//
//            if(okHttpClient == null){
//                throw new RuntimeException("获取OkHttpClient失败！");
//            }
//            Response response = okHttpClient.newCall(request).execute();
//            if (!response.isSuccessful()) {
//                throw new IOException("服务器端错误: " + response);
//            }
//
////            Headers responseHeaders = response.headers();
////            for (int i = 0; i < responseHeaders.size(); i++) {
////                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
////            }
//
//            String result = response.body().string();
////            JSONObject jsonObject = JSONObject.fromObject(result);
////            JSONObject data = jsonObject.getJSONObject("data");
////            SJConfig.access_token = data.getString("access_token");
//            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
