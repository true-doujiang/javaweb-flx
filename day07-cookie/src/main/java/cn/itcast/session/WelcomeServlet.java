package cn.itcast.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页，当浏览器禁用cookie时的解决方案: response.encodeURL("/day07/servlet/SessionDemo1");
 * 但是，致命缺陷：
 * 这种写给浏览器的cookie都是会话级别的，关闭浏览器后sessionID(cookie)就没了。
 */
public class WelcomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /**
         既可以根据cookie里获取session，也可以从超链接后面的sessionid获取session  */
        request.getSession();
        /**
         * encodeURL() 会自动的在后面字符串后面添加sessionid，但是这里的sessionid一旦浏览器关闭了也就没了，
         * 这个方法比较智能，当发现你的浏览器带着cookie请求时，他就不给在后面加sessionid了
         */
        String url1 = response.encodeURL("/day07/servlet/SessionDemo1");
        String url2 = response.encodeURL("/day07/servlet/SessionDemo2");
        System.out.println(response.encodeURL("输出的sessionID是="));//这里要看浏览器有木有禁用cookie了
        //System.out.println(url1);
        //System.out.println(url2);
        out.write("<a href='" + url1 + "'>购买</a><br>");
        out.write("<a href='" + url2 + "'>结账</a><br>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
