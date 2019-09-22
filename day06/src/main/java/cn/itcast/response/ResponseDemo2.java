package cn.itcast.response;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2、通过response的getWriter流输出文字数据，不能输出电影等二进制流
 */
public class ResponseDemo2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {

        test1(response);
        //test2(response);
    }

    //细节1
    @SuppressWarnings("unused")
    private void test1(HttpServletResponse response) throws IOException {
        String data = "中国q";

        //设置response使用的码表，以控制response以什么码表向浏览器输入数据,默认为ISO-8859-1(老外喜欢的码表)
        response.setCharacterEncoding("UTF-8");
        //指定浏览器以什么码表打开服务器发送的数据
        response.setHeader("Content-type", "text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.write(data);//
        out.write(65); //到页面就变成 A
    }

    //细节2
    private void test2(HttpServletResponse response) throws IOException {
        String data = "中国q";
        //该句代码等价于其后面两句,但是实际开发通常加上response.setCharacterEncoding("UTF-8")
        response.setContentType("text/html;charset=UTF-8");
        //response.setCharacterEncoding("UTF-8");
        //response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(data);//
    }
}
