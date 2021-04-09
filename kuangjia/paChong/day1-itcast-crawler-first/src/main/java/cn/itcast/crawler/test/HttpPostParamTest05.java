package cn.itcast.crawler.test;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class HttpPostParamTest05 {

    public static void main(String[] args) throws Exception {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建HttpPost对象，设置url访问地址
        HttpPost httpPost = new HttpPost("http://yun.itheima.com/search");

        //声明List集合，封装表单中的参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //设置请求地址是：http://yun.itheima.com/search?keys=Java
        params.add(new BasicNameValuePair("keys","Java"));

        //创建表单的Entity对象,第一个参数就是封装好的表单数据，第二个参数就是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params,"utf8");

        //设置表单的Entity对象到Post请求中
        httpPost.setEntity(formEntity);

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
    public void demo1() {
        CloseableHttpClient httpClient = HttpClients.createDefault ();
        HttpPost httpPost = new HttpPost ( "http://yun.itheima.com/search" );
        ArrayList<NameValuePair> params = new ArrayList<NameValuePair> ();
        params.add ( new BasicNameValuePair("keys","Java") );
        UrlEncodedFormEntity formEntity = null;
        try {
            formEntity = new UrlEncodedFormEntity ( params, "utf-8" );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace ();
        }
        httpPost.setEntity ( formEntity );
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute ( httpPost );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        if (response.getStatusLine ().getStatusCode () == 200){
            String content = null;
            try {
                content = EntityUtils.toString ( response.getEntity (), "utf8" );
                System.out.println (content);
            } catch (IOException e) {
                e.printStackTrace ();
            }finally {
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

    @Test
    public void demo2(){
        CloseableHttpClient client = HttpClients.createDefault ();
        HttpPost httpPost = new HttpPost ( "http://yun.itheima.com/search" );

        ArrayList<NameValuePair> list = new ArrayList<NameValuePair> ();
        BasicNameValuePair pair = new BasicNameValuePair ( "keys", "java" );
        list.add ( pair );
        UrlEncodedFormEntity entity = null;
        try {
            entity = new UrlEncodedFormEntity ( list );
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace ();
        }
        httpPost.setEntity ( entity );

        CloseableHttpResponse response = null;
        try {
            response = client.execute ( httpPost );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        if (response.getStatusLine ().getStatusCode () == 200){
            HttpEntity entity1 = response.getEntity ();
            String content = null;
            try {
                content = EntityUtils.toString ( entity1, "utf8" );
            } catch (IOException e) {
                e.printStackTrace ();
            }
            System.out.println (content);
            System.out.println (content.length ());
            if (response != null){
                try {
                    response.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            if (client != null){
                try {
                    client.close ();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }
    }




}
