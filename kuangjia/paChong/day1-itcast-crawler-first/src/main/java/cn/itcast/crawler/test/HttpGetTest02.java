package cn.itcast.crawler.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class HttpGetTest02 {

    public static void main(String[] args) {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault ();

        //创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet ( "http://www.itcast.cn" );

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求，获取response
            response = httpClient.execute ( httpGet );

            //解析响应
            if (response.getStatusLine ().getStatusCode () == 200) {
                String content = EntityUtils.toString ( response.getEntity (), "utf8" );
                System.out.println ( content.length () );
                System.out.println ( content );
            }

        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            //关闭response
            try {
                response.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
            try {
                httpClient.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }
    }


    @Test
    public void demo1() {
        System.out.println ( "7890" );
        CloseableHttpClient httpClient = HttpClients.createDefault ();
        HttpGet httpGet = new HttpGet ( "http://www.itcast.cn" );
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute ( httpGet );
            if (response.getStatusLine ().getStatusCode () == 200){
                String result = EntityUtils.toString ( response.getEntity (), "utf-8" );
                System.out.println (result);
            }
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
            try {
                httpClient.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }

        }
    }

    @Test
    public  void demo2(){
        CloseableHttpClient httpClient = HttpClients.createDefault ();
        HttpGet httpGet = new HttpGet ( "http://itcast.cn.990" );

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute ( httpGet );
        } catch (IOException e) {
            e.printStackTrace ();
        }

        if (response.getStatusLine ().getStatusCode () == 200){
            HttpEntity entity = response.getEntity ();
            try {
                String content = EntityUtils.toString ( entity, "utf8" );
                System.out.println (content);
                System.out.println (content.length ());
            } catch (IOException e) {
                e.printStackTrace ();
            }
            try {
                response.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
            try {
                httpClient.close ();
            } catch (IOException e) {
                e.printStackTrace ();
            }
        }


    }
}
