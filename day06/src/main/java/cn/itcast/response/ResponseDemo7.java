package cn.itcast.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 7、
 * 实现请求重定向
 * 特点：1、地址栏发生变化。2、浏览器发送俩次请求
 * 应用场景：登录成功后跳转（地址栏会变化提示用户）、显示购物车
 * 重定向少用
 */

public class ResponseDemo7 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.setStatus(302);
        //response.setHeader("location", "/day06/index.jsp");
        //这一句=上面俩句（菜鸟用法）
        response.sendRedirect("/day06/index.jsp");


        /**
         * 重定向是不会有这个问题的
         * PS:getOutputStream()和getWriter() 互斥（不能同时调用）否则报500
         * 第一个servlet（调用了getOutputStream()）转发到第二个servlet（调用了getWriter()）时同上
         */

        /**
         * getOutputStream()和getWriter()
         * 会自动关闭，所以不用手动关闭了
         */
    }
}
