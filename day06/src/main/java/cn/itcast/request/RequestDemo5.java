package cn.itcast.request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 请求转发，以及使用request域对象把数据带给转发资源
 * 请求转发特点：
 * 1、客户机只发一次请求，而服务端有多个资源调用
 * 2、浏览器地址栏不变化
 */

public class RequestDemo5 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //test1(request, response);
        //test2(request, response);
        test3(request, response);
    }


    //正常使用
    @SuppressWarnings("unused")
    private void test1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "aaaaaa";
        request.setAttribute("message", message);
        //request也可以实现转发
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    //细节1
    private void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        String message = "aaaaaa";
        request.setAttribute("message", message);

        //forward之前"不可以"关闭流，否则java.lang.IllegalStateException: Cannot forward after response has been committed
        PrintWriter write = response.getWriter();
        write.write("bbbbb");
        //write.close();
        //不关闭可以正常跳转，但是write里的数据会被清空，所以页面拿不到bbbbb
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    //细节2
    @SuppressWarnings("unused")
    private void test3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "aaaaaa";
        request.setAttribute("message", message);

        if (true) {
            //跳转后一定要return；结束后面的跳转，不然报错同上
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            //return;
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
