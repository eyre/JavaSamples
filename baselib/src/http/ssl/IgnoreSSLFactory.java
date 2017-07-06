package http.ssl;

import http.HttpConfig;
import okhttp3.OkHttpClient;

import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * Author joker
 * Created on 2017/7/6.
 * Description
 */
public class IgnoreSSLFactory {
    private static final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
        @Override
        public void checkClientTrusted(
                java.security.cert.X509Certificate[] chain,
                String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(
                java.security.cert.X509Certificate[] chain,
                String authType) throws CertificateException {
        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }};

    private static OkHttpClient okHttpClient;

    public static OkHttpClient getIgnoreSSLHttpClient(){
        if(okHttpClient == null) {
            // Install the all-trusting trust manager
            final SSLContext sslContext;
            try {
                sslContext = SSLContext.getInstance("SSL");
                sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
                okHttpClient = new OkHttpClient().newBuilder().sslSocketFactory(sslContext.getSocketFactory())
                        .hostnameVerifier(new HostnameVerifier() {
                            @Override
                            public boolean verify(String s, SSLSession sslSession) {
                                return true;
                            }
                        })
                        .connectTimeout(HttpConfig.SECONDS_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                        .build();
                return okHttpClient;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            return null;
        }else {
            return okHttpClient;
        }
    }

}
