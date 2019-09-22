package cn.itcast.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo4 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 访问：  http://localhost:8088/day06/form3.html
         * 浏览器以什么码表提交的中文数据，要看浏览器当前使用的是什么码表
         * request.getParameter("username");老外喜欢iso-8859-1码表，所以默认按这个码表取数据
         *
         * 修改服务器也可以解决乱码，不建议使用,但是我的已经改成UTF-8了
         */
        //test1(request);
        //test2(request);
        test3(request, response);
    }


    @SuppressWarnings("unused")
    private void test3(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException {
        //解决POST乱码(只对POST方式有效)
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        //上面2句= String username = "中国";  所以别被吓到了，不会有乱码滴

        response.setCharacterEncoding("gb2312");
        response.setContentType("text/html;charset=gb2312");
        response.getWriter().write(username);
    }


    @SuppressWarnings("unused")
    private void test2(HttpServletRequest request) throws UnsupportedEncodingException {

        //解决POST乱码(只对POST方式有效)
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        System.out.println(username);
    }

    //实验未成功
    private void test1(HttpServletRequest request) throws UnsupportedEncodingException {

        String username = request.getParameter("username");
        System.out.println(username); //这里反而不乱吗
        //解决Get方式提交的乱码（手动解决）
        username = new String(username.getBytes("UTF-8"), "UTF-8");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("POST提交方式");
        doGet(req, resp);
    }
}
