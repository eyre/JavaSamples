package http;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.https.HttpsUtils;
import config.SJConfig;
import http.ssl.IgnoreSSLFactory;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Author joker
 * Created on 2017/7/6.
 * Description
 */
public class HttpUtils {


    public void getSjToken() throws IOException{
        String sjTokenUrl = String.format("https://api.saj-solar.com/accessToken?client_id=%s&client_secret=%s&grant_type=%s",
                SJConfig.client_id,SJConfig.client_secret,SJConfig.grant_type);
//        String gmmUrl = "https://app.sz-zoomlight.com/";

//        OkHttpClient client = new OkHttpClient();

//        HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(null, null, null);
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
//                //其他配置
//                .build();
//        OkHttpUtils.initClient(okHttpClient);

        OkHttpClient okHttpClient = IgnoreSSLFactory.getIgnoreSSLHttpClient();

        Request request = new Request.Builder()
                .url(sjTokenUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        System.out.println(response.body().string());
    }
}
