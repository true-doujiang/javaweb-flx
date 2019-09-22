package cn.itcast.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//网站首页：可以实现显示用户上次访问时间
public class CookieDemo1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.write("这是网站首页！！<br/><br/>");
        out.write("<a href='/day07/servlet/CookieDemo2'>清除上次访问时间</a><br><br>");
        out.write("您上次访问时间是：");

        //获得用户的时间cookie
        Cookie cookies[] = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            System.out.println(cookie.getName());

            if (cookie.getName().equals("lastAccessTime")) {
                Long time = Long.parseLong(cookie.getValue());
                System.out.println("maxAge=" + cookie.getMaxAge());
                Date d = new Date(time);
                out.write(d.toLocaleString());
            }
        }

        //设置cookie
        //给用户以cookie的形式送最新的时间
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(1 * 30 * 24 * 3600);  //30天过期
        cookie.setPath("/day07");         //再访问这个路径的时候我才会带这个cookie,别的路径不会带这个cookie。
        response.addCookie(cookie);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
