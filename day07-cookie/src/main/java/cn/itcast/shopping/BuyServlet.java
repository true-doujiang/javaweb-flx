package cn.itcast.shopping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//2、完成购买
public class BuyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Book book = (Book) DB.getAll().get(id);  //得到用户想买的书

        HttpSession session = request.getSession(false);   //首页servlet已经创建session了

        /** 以cookie形式发sessionid，已解决关闭浏览器后，上次购买东西不在的问题 */
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(10 * 60); //10m
        cookie.setPath("/day07");
        response.addCookie(cookie);

        //从session中得到用户用于保存所有书的集合（购物车）
        List list = (List) session.getAttribute("list");
        if (list == null) {
            //第一次购买商品的时候要为改客户创建一个购物车
            list = new ArrayList();
            session.setAttribute("list", list);
        }
        list.add(book);

        //方法1,用转发，当用户刷新浏览器一次就又买一本书，刷新一次又买一本书
        //request.getRequestDispatcher("/servlet/ListCartServlet").forward(request, response);

        //方法2,所以要用重定向
        String webpath = request.getContextPath();  //  /day07
        //为了将sessionid带过去
        String url = response.encodeRedirectURL(webpath + "/servlet/ListCartServlet");
        System.out.println("BuyServlet: " + url);
        response.sendRedirect(url);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
