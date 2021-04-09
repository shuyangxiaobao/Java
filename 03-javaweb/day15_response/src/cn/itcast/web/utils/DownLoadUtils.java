package cn.itcast.web.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;


public class DownLoadUtils {

    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        System.out.println (agent+"🍺");
        if (agent.contains("MSIE")) {
            // IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // 火狐浏览器
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] decodeArr = decoder.decode ( filename.getBytes ( "utf-8" ) );

            String a = decodeArr.toString ();
            filename = "=?utf-8?B?" + a + "?=";
        } else {
            // 其它浏览器
            filename = URLEncoder.encode(filename, "utf-8");

//            filename = URLEncoder.encode (  )
            System.out.println ("filename:"+filename);
//            filename = URLEncoder.encode(filename, "gbk");

        }
        return filename;
    }
}
