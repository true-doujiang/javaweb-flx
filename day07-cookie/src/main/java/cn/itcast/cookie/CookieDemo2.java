package cn.itcast.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//删除cookie
public class CookieDemo2 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //js也可以删除cookie

        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        cookie.setMaxAge(0);
        cookie.setPath("/day07");    //删除cookie时，path必须一致，否则不会删除
        response.addCookie(cookie);

        response.sendRedirect("/day07/index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
