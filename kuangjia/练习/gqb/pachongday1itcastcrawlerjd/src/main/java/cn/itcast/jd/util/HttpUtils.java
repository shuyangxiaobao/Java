package cn.itcast.jd.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils {

    private PoolingHttpClientConnectionManager manager;


    public HttpUtils() {
        this.manager = new PoolingHttpClientConnectionManager ();
        this.manager.setMaxTotal ( 100 );
        this.manager.setDefaultMaxPerRoute ( 10 );
    }

    public String doGetHtml(String url) {
        CloseableHttpClient httpClient = HttpClients.custom ().setConnectionManager ( this.manager ).build ();
        HttpGet httpGet = new HttpGet ( url );

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute ( httpGet );
        } catch (IOException e) {
            e.printStackTrace ();
        }

        if (response.getStatusLine ().getStatusCode () == 200) {
            HttpEntity entity = response.getEntity ();
            String content = null;
            try {
                content = EntityUtils.toString ( entity, "utf8" );
            } catch (IOException e) {
                e.printStackTrace ();
            } finally {
                if (response != null) {
                    try {
                        response.close ();
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
            }
            return content;
        }
        return "";
    }


    public String doGetImage(String url) {
        CloseableHttpClient httpClient = HttpClients.custom ().setConnectionManager ( this.manager ).build ();
        HttpGet httpGet = new HttpGet ( url );

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute ( httpGet );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        if (response.getStatusLine ().getStatusCode () == 200) {
            HttpEntity entity = response.getEntity ();

        }
        return "";
    }

}
