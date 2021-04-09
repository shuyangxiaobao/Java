package cn.itcast.crawler.test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CrawlerFirst01 {

    public static void main(String[] args) throws Exception {
        //1. 打开浏览器,创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //2. 输入网址,发起get请求创建HttpGet对象
        HttpGet httpGet = new HttpGet("http://www.itcast.cn");

        //3.按回车，发起请求，返回响应，使用HttpClient对象发起请求
        CloseableHttpResponse response = httpClient.execute(httpGet);

        //4. 解析响应，获取数据
        //判断状态码是否是200
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = response.getEntity();
            String content = EntityUtils.toString(httpEntity, "utf8");

            System.out.println(content);
        }
    }

    @Test
    public void demo1() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault ();
        HttpGet httpGet = new HttpGet ( "http://www.itcast.cn" );
        CloseableHttpResponse response = httpClient.execute ( httpGet );
        if (response.getStatusLine ().getStatusCode () == 200){
            HttpEntity entity = response.getEntity ();
            String result = EntityUtils.toString ( entity, "utf8" );
            System.out.println (result);
            System.out.println (result.length ());
        }
    }


    @Test
    public void demo2() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault ();
        HttpGet httpGet = new HttpGet ( "http://itcast.cn" );
        CloseableHttpResponse response = httpClient.execute ( httpGet );
        if (response.getStatusLine ().getStatusCode () == 200){
            HttpEntity entity = response.getEntity ();
            String content = EntityUtils.toString ( entity, "utf8" );
            System.out.println (content);
            System.out.println (content.length ());
        }
    }
}
