package com.xiaobao.controller;


import com.sun.jersey.api.client.Client;

import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(path = "/fileupload3")

//    http://localhost:80/springmvc_day02_02_fileupload_picture_war/


    public String fileupload3(HttpServletRequest request, MultipartFile upload) throws IOException {

        System.out.println("跨服务器文件上传...");
        // 定义上传文件服务器路径
        String path = "http://localhost:8088/springmvc_day02_02_fileupload_picture_war/uploads/";

        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;

        // 创建客户端的对象
        Client client = Client.create();

        System.out.println (path + filename);

        // 和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        // 上传文件
        webResource.put(upload.getBytes());
        return "success";
    }


    @RequestMapping(path = "/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        String path = request.getSession ().getServletContext ().getRealPath ( "/uploads/" );
        File file = new File ( path );
        if (!file.exists ()){
            file.mkdir ();
        }
        String filename = upload.getOriginalFilename ();
        String  uuid = UUID.randomUUID ().toString ().replace ( "-", "" );
        filename =  uuid + "_"+filename;
        upload.transferTo ( new File ( path,filename ) );
        System.out.println (path);
        return "success";
    }


    @RequestMapping(value = "/test")
    public String test(){
        return "success";
    }

}
