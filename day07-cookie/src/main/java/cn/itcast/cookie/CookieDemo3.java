package cn.itcast.cookie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页servlet
 * 1.显示网站所有商品
 * 2.显示用户曾经浏览过的商品
 */
public class CookieDemo3 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //1.显示网站所有商品
        out.write("本网站有如下书籍：<br><br>");
        Set<Map.Entry<String, Book>> set = DB.getAll().entrySet();
        for (Map.Entry<String, Book> me : set) {
            Book book = me.getValue();
            out.write("<a href='/day07/servlet/CookieDemo4?id=" + book.getId() + "' target='_blank'>" + book.getName() + "</a><br/>");
        }


        //2.显示用户曾经浏览过的商品
        out.write("<br/>您曾经浏览过的商品:<br/>");
        Cookie cookies[] = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            System.out.println(cookie.getName() + "=" + cookie.getValue());

            if (cookie.getName().equals("bookHistory")) {
                String bookHistory = cookie.getValue();  //  2_3_1
                String ids[] = bookHistory.split("\\_");  //[2,3]
                for (String id : ids) {
                    Book book = (Book) DB.getAll().get(id);
                    out.write(book.getName() + "<br/>");
                }
            }
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


class DB {

    //用Map方便搜索		hashMap存的话，顺序就乱了,所以用LinkedHashMap顺序不会乱。
    private static Map<String, Book> map = new LinkedHashMap<String, Book>();

    static {
        map.put("1", new Book("1", "javaweb开发", "老张", "一本好书"));
        map.put("2", new Book("2", "spring开发", "老黎", "一本好书"));
        map.put("3", new Book("3", "hibernate开发", "老佟", "一本好书"));
        map.put("4", new Book("4", "struts开发", "老毕", "一本好书"));
        map.put("5", new Book("5", "ajax开发", "老张", "一本好书"));
    }

    public static Map<String, Book> getAll() {
        return map;
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Book {

    private String id;
    private String name;
    private String author;
    private String description;

}
