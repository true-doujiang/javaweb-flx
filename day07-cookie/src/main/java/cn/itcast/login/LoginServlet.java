package cn.itcast.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从 http://localhost:8088/day07/login.html 登录

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = DB.find(username, password);  //html
        if (user == null) {
            out.write("用户名或密码有误！！");
            return;
        }

        request.getSession().setAttribute("user", user);   //用户登陆成功,向用户session中存一个登陆标记
        response.sendRedirect("/day07/index.jsp");    //重定向到网站首页
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

class DB {
    private static List<User> list = new ArrayList<User>();

    static {
        list.add(new User("aaa", "123"));
        list.add(new User("bbb", "123"));
        list.add(new User("ccc", "123"));
    }

    //查找用户
    public static User find(String username, String password) {
        for (User user : list) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}


