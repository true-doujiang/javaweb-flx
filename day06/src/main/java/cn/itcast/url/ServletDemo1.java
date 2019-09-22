package cn.itcast.url;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 1、上来先写  /
         * 2、看url是给谁用的那么/就代表谁（服务器或者浏览器）
         */

        //给服务器用  /代表当前应用
        //给浏览器用  /代表网站，网站下有多个应用
        request.getRequestDispatcher("/form1.html").include(request, response);
        //显然是给浏览器用的
        response.sendRedirect("/day06/form1.html");
        this.getServletContext().getRealPath("/form1.html");
        this.getServletContext().getResourceAsStream("/fomr1.html");

        /**
         * 在html、jsp中/显然代表网站
         <a href="/day06/form.html">xx</a>

         <form action="/day06/form.html">
         </form>
         */

        /**
         * url用正斜杠/     http://localhost:8088/day06/servlet/requestDemo8
         * 本地目录用反斜杠\  E:\迅雷下载\JavaWeb-方立勋\911\day06资料
         *
         */
    }

}
