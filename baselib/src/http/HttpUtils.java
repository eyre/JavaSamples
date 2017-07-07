package http;

import com.zhy.http.okhttp.OkHttpUtils;
import http.ssl.IgnoreSSLFactory;
import okhttp3.OkHttpClient;

/**
 * Author joker
 * Created on 2017/7/6.
 * Description
 */
public class HttpUtils {

    public static void init(){
        OkHttpClient okHttpClient = IgnoreSSLFactory.getIgnoreSSLHttpClient();
        OkHttpUtils.initClient(okHttpClient);
    }

}
