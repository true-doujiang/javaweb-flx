package cn.itcast.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 6、控制浏览器缓存
 */
public class ResponseDemo6 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("证明我被访问几次");
        //从index2.jsp访问我
        //第二次再从index2.jsp 访问就从缓存里拿数据了
        String data = "aaaaa";
        //当前时间 + 你要缓存的时间（1h）   //当浏览器在一小时内再访问，都是从浏览器的缓存里那数据
        response.setDateHeader("expires", System.currentTimeMillis() + 3600 * 1000);
        //response.setHeader("expires", (System.currentTimeMillis()+60*1000)+""); //这个不可以
        response.getWriter().write(data);
    }
}
