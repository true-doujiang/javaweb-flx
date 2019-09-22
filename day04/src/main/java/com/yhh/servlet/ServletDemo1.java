package com.yhh.servlet;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 以下全是测试的response头
         */

        //test1(request, response);
        test2(request, response);
        //test3(request,response);
        //test4(request,response);
        //test5(request,response);
    }

    //location和302实现请求重定向 		eg：用户登录后重定向到网站首页
    public void test1(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(302);//客户端跳转加工程名
        response.setHeader("location", "/day04/1.html");
    }

    //数据压缩
    public void test2(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String data = "中国中国中国中国中国美国abcdabcdabcdabcdabcdabcdabcda" +
                "bcdabcdabcdabcdabcdabcdabcdabcda" +
                "bcdabcdabcdabcdabcdabcdabcdabcdabcda" +
                "bcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcda" +
                "bcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcda" +
                "bcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
                "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
                "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
                "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
                "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
                "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
                "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
                "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
                "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcda" +
                "bcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd" +
                "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcda" +
                "bcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdab";

        //getBytes() 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中
        System.out.println("原始数据的大小为：" + data.getBytes().length);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();  //GZIPInputStream(InputStream in)  int len = gzip.read(byte[] buf)
        GZIPOutputStream gout = new GZIPOutputStream(buffer); //buffer   //查sunAPI
        gout.write(data.getBytes("UTF-8"));
        gout.close(); //包装流没装满的话是不会往顶层流里写的，关闭就肯定会写的
        //得到压缩后的数据
        byte g[] = buffer.toByteArray();
        System.out.println("压缩数据的大小为：" + g.length);

        //1、直接输出
        response.setHeader("content-Type", "text/html;charset=UTF-8");
        //response.setHeader("Content-Encoding", "gzip");    //告诉浏览器数据压缩格式,不加这个头的话浏览器不知道怎么办的
        //告诉浏览器数据的长度 ,不加这个头也可以, 就算是用socket下载，也是我这里告诉它多少字节它就下载多少个自己
        //response.setHeader("Content-Length", g.length + "");
        //response.getOutputStream().write(g);
        response.getOutputStream().write(data.getBytes("UTF-8"));

        //2、下载
        //response.setHeader("content-disposition", "attachment;filename=xxx.txt");
        //response.getOutputStream().write(data.getBytes());

    }

    //通过content-type头字段，控制浏览器以哪种方式打开数据
    public void test3(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //C:\apache-tomcat-6.0.20\conf\web.xml
        response.setHeader("content-type", "image/bmp");
        //也可以使用下载方式
        //response.setHeader("content-disposition", "attachment;filename=xxx.jpg");
        InputStream in = this.getServletContext().getResourceAsStream("/1.jpg");  //request.getSession().getServletContext().getResourceAsStream("path");
        System.out.println(this.getServletContext().getRealPath(""));
        byte buffer[] = new byte[10];
        int len = 0;
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            System.out.println("len=" + len); //10... 7
            out.write(buffer, 0, len);
        }

    }

    //指定浏览器定时刷新 refresh
    public void test4(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("refresh", "15;url='http://www.sina.com'");  //15s后跳转到指定的url 注意单引号
        //response.setHeader("refresh", "5");  //5s刷新一次
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("3s后我就要跳转了.......");
    }

    //指定浏览器下载
    public void test5(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setHeader("content-disposition", "attachment;filename=xxx.jpg");
        InputStream in = this.getServletContext().getResourceAsStream("/2.jpg");
        byte buffer[] = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
