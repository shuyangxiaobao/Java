package cn.itcast.crawler.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.parser.Entity;
import java.io.IOException;

public class HttpPostTest04 {

    public static void main(String[] args)  {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建HttpPost对象，设置url访问地址
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");

        CloseableHttpResponse response = null;
        try {
            //使用HttpClient发起请求，获取response
             response = httpClient.execute(httpPost);

            //解析响应
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf8");
                System.out.println(content.length());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭response
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Test
    public void demo1(){
        CloseableHttpClient httpClient = HttpClients.createDefault ();
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute ( httpPost );
        } catch (IOException e) {
            e.printStackTrace ();
        }

        if (response.getStatusLine ().getStatusCode () == 200){
            HttpEntity entity = response.getEntity ();
            String content = null;
            try {
                content = EntityUtils.toString ( entity, "utf8" );
                System.out.println (content);
                System.out.println (content.length ());
            } catch (IOException e) {
                e.printStackTrace ();
            } finally {
                if (response != null){
                    try {
                        response.close ();
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
                if (httpClient != null){
                    try {
                        httpClient.close ();
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
            }


        }


    }
}
