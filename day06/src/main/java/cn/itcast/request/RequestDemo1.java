package cn.itcast.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * URI爸爸  news/1.html			用的多             URI全球资源统一定位符，可以表示任意一个资源
     * URL仔     http://www.sina.com/news/1.html  URL用于表示互联网上的一个资源
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //URI应用场景:1、用在权限设置上  2、统计某个资源的访问次数
        System.out.println(request.getRequestURI());    //   /day06/servlet/requestDemo1  知道了你要方位的URI那我就知道了你要访问的URL
        System.out.println(request.getRequestURL());    //   http://localhost:8080/day06/servlet/requestDemo1

        //http://localhost:8088/day06/servlet/requestDemo1?name=yhh&password=123
        System.out.println(request.getQueryString());//name=yhh&password=123
        System.out.println(request.getRemoteAddr());//127.0.0.1 返回发送请求客户机的ip地址
        System.out.println(request.getRemoteHost());//返回127.0.0.1，因为没有在DNS中注册,若注册了则返回主机名
        System.out.println(request.getRemotePort());//访问我程序的客户端程序使用的端口号49300 不固定
        System.out.println(request.getMethod());    //GET ,在表单里可为POST
    }

}
