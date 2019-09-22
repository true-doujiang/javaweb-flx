package cn.itcast.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo9 extends HttpServlet {

    /**
     * 必须从 http://localhost:8088/day06/index2.jsp 访问
     */
    private static final long serialVersionUID = 1L;

    //防盗链
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先取头
        String referer = request.getHeader("referer");

        //referer==null && !referer.startsWith("http://localhost")
        if (referer == null && !referer.startsWith("http://localhost")) {
            response.sendRedirect("/day06/index2.jsp");//用重定向url会变化，让用户知道跳到首页
            return;
        }
        response.getOutputStream().write("凤姐日记........凤姐日记!!".getBytes("UTF-8"));
    }


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
