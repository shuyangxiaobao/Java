package cn.itcast.crawler.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HttpClientPoolTest06 {

    public static void main(String[] args) {
        //创建连接池管理器
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        cm.setMaxTotal(100);
        //设置每个主机的最大连接数
        cm.setDefaultMaxPerRoute(10);
        //使用连接池管理器发起请求
        doGet(cm);
        doGet(cm);
    }

    private static void doGet(PoolingHttpClientConnectionManager cm) {
        //不是每次创建新的HttpClient，而是从连接池中获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();

        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf8");

                System.out.println(content.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //不能关闭HttpClient，由连接池管理HttpClient
                //httpClient.close();
            }
        }
    }



@Test
    public void demo1(){
        PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager ();
        manager.setMaxTotal ( 100 );
        manager.setDefaultMaxPerRoute ( 10 );
        CloseableHttpClient httpClient = HttpClients.custom ().setConnectionManager ( manager ).build ();
        HttpGet httpGet = new HttpGet ( "http://www.itcast.cn" );

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute ( httpGet );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        if (response.getStatusLine ().getStatusCode () == 200) {
            HttpEntity entity = response.getEntity ();
            try {
                String content = EntityUtils.toString ( entity, "utf8" );
                System.out.println ( content );
                System.out.println ( content.length () );
            } catch (IOException e) {
                e.printStackTrace ();
            } finally {
                try {
                    response.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }



}


