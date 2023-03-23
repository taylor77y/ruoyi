package com.ruoyi.system.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author Krson
 * @date 2022/8/17 17:14
 */
public class HttpUtils {

    static String ENCODING = "UTF-8";
    static String NAME = "Content-Type";
    static String VALUE = "application/json";
    static RequestConfig requestConfig;
    static {
        requestConfig = RequestConfig.custom().
                setConnectTimeout(180 * 1000).setConnectionRequestTimeout(180 * 1000)
                .setSocketTimeout(180 * 1000).setRedirectsEnabled(true).build();
    }

    public static String sendPost(String url,String jsonStr){

        CloseableHttpClient httpClient = getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        httpPost.setHeader(NAME, VALUE);
//        httpPost.setHeader("token","7065240bc3e14c3faefed130a4009128");
//        httpPost.setHeader("userId","5677774c9b3ef28ab7c8543359e50f54");
        try {
            httpPost.setEntity(new StringEntity(jsonStr, ContentType.create(NAME, ENCODING)));
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            return EntityUtils.toString(entity,ENCODING);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 信任全部https
     * @return CloseableHttpClient
     */
    private static CloseableHttpClient getHttpClient(){

        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null,new TrustStrategy(){
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
            return HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }
}
