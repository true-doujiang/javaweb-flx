package cn.itcast.response;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 5、控制浏览器定时刷新
 */
public class ResponseDemo5 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            test1(response);
            //test2(response);
            //test3(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //实际开发用
    private void test3(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
        //用meta标签模仿http请求控制跳转
        String message = "<meta http-equiv='refresh' content='5;url=/day06/index.jsp'>登录成功，将在10秒后跳转，如果没有，请点<a href=''>超链接</a>";
        this.getServletContext().setAttribute("message", message);
        this.getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    }

    //实际开发不用
    @SuppressWarnings("unused")
    private void test2(HttpServletResponse response) throws IOException {
        //假设这是一个用于处理登录的servlet
        //假设程序运行到此，用户登录成功了，3s后跳转到网站首页面
        response.setHeader("refresh", "3;url='/day06/index.jsp'");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write("登录成功，将在3秒后跳转，如果没有，请点<a href=''>超链接</a>");
    }

    @SuppressWarnings("unused")
    private void test1(HttpServletResponse response) throws IOException {

        response.setHeader("refresh", "5");

        String data = new Random().nextInt(100000) + "";
        response.getWriter().write(data);
    }

}
