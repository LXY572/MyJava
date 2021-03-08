package com.kuang.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import sun.security.util.Length;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

@Controller
public class FileUploadController {

    //文件上传：流
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //1.获得文件名
        String filename = file.getOriginalFilename();
        if ("".equals(filename)){
            return "文件不存在";
        }
        //2.上传文件保存路径
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //3.上传文件
        InputStream is = file.getInputStream();
        FileOutputStream os = new FileOutputStream(new File(realPath, filename));

        int len = 0;
        byte[] buffer =  new byte[1024];

        while ((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
            os.flush();
        }

        //4.关闭流
        os.close();
        is.close();
        return "上传完毕";
    }

    //文件上传：CommonsMultipartFile
    @RequestMapping(value = "/upload2")
    @ResponseBody
    public String upload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        //上传文件保存路径
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }

        //transferTo：将文件写入到磁盘，参数就是一个文件
        file.transferTo(new File(realPath+"/"+file.getOriginalFilename()));

        return "上传完毕";
    }

    //下载实现
    /*
    //设置响应头
    1.读取本地文件
    2.写出文件
    3.执行操作
    4.关闭流
     */
    @RequestMapping(value = "/download")
    public String download(HttpServletResponse response) throws IOException {

        //要下载的图片路径：,服务器有没有强，一般下载都有自己公司的图床，地址；
        String path = "https://blog.kuangstudy.com/usr/themes/handsome/usr/img/sj/";
        String filename = "5.jpg";

        //设置响应头信息；【固定的不用记，保存即可】
        response.reset(); //让页面不缓存
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");//二进制流传输数据
        response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(filename,"UTF-8"));

        File file = new File(path,filename);

        //输入流
        FileInputStream input = new FileInputStream(file);
        //输出流
        ServletOutputStream out = response.getOutputStream();

        //执行操作
        int len = 0;
        byte[] buffer = new byte[1024];

        while ((len = input.read(buffer))!=-1){
            out.write(buffer,0,len);
            out.flush();
        }

        out.close();
        input.close();

        return null;

    }



}
