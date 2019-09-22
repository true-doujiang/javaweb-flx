package cn.itcast.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 显示商品详细信息的servlet
 */
public class CookieDemo4 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //1.根据用户带过来的id号，显示商品的详细信息
        String id = request.getParameter("id");
        Book book = (Book) DB.getAll().get(id);

        out.write("您要查看的书的详细信息如下：<br/>");
        out.write("ID&nbsp;&nbsp;&nbsp;书名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作者&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;描述<br>");
        out.write(book.getId() + "&nbsp;&nbsp;&nbsp;");
        out.write(book.getName() + "&nbsp;&nbsp;&nbsp;");
        out.write(book.getAuthor() + "&nbsp;&nbsp;&nbsp;");
        out.write(book.getDescription() + "&nbsp;&nbsp;&nbsp;");

        //2.给用户回送包含当前商品id的cookie
        String bookHistory = makeHistory(request, id);    //  3_2

        Cookie cookie = new Cookie("bookHistory", bookHistory);
        cookie.setMaxAge(600);// 10分钟   一般设置一个月比较合适
        cookie.setPath("/day07");
        response.addCookie(cookie);
    }

    private String makeHistory(HttpServletRequest request, String id) {

        //  4种情况分析
        //  bookHistory=null      1    bookHistory=1
        //  bookHistory=3_1_5     1    bookHistory=1_3_5
        //  bookHistory=3_2_5     1    bookHistory=1_3_2
        //  bookHistory=3_2       1    bookHistory=1_3_2

        String bookHistory = null;
        Cookie cookies[] = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if (cookies[i].getName().equals("bookHistory")) {
                bookHistory = cookies[i].getValue();
            }
        }

        //  bookHistory=null      1    bookHistory=1
        if (bookHistory == null) {
            return id;
        }

        //Java的集合类得好好研究研究****
        List<String> arraylist = Arrays.asList(bookHistory.split("\\_")); //[3,4]
        LinkedList<String> list = new LinkedList<String>(arraylist);      //再将集合转成LinkedList，方便使用它的工具函数

        //首先检查包不包含
        if (list.contains(id)) {
            //  bookHistory=3_1_5     1    bookHistory=1_3_5
            list.remove(id);
            list.addFirst(id);
        } else {
            if (list.size() >= 3) {
                //  bookHistory=3_2_5     1    bookHistory=1_3_2
                list.removeLast();
                list.addFirst(id);
            } else {
                //  bookHistory=3_2       1    bookHistory=1_3_2
                list.addFirst(id);
            }
        }

        StringBuffer sb = new StringBuffer();  //2_3_4
        for (String lid : list) {
            sb.append(lid + "_");
        }
        //删除最后多出的_
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
