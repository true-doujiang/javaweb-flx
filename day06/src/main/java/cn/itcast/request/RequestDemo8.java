package cn.itcast.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//使用include实现页面包含  没什么鸟用   后面讲jsp的时候还会讲解动态引入、静态引入
public class RequestDemo8 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //动态引入

        request.getRequestDispatcher("/public/head.jsp").include(request, response);
        //response.getOutputStream().write("kkkkkk".getBytes());
        response.getWriter().write("<br>hahaha<br>");
        request.getRequestDispatcher("/public/foot.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
