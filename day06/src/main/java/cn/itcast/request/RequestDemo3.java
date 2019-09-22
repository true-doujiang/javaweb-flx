package cn.itcast.request;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import cn.itcast.FormUser;


public class RequestDemo3 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //从http://localhost:8088/day06/form.html 提交数据

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String[]> parameterMap = request.getParameterMap();
        FormUser formUser = new FormUser();
        try {
            BeanUtils.populate(formUser, parameterMap);//数组类型的属性也可以填充
            System.out.println(formUser);
        } catch (Exception e) {
            e.printStackTrace();
        }


        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String city = request.getParameter("city");

        System.out.println("username=" + username + "password=" + password + "gender=" + gender + "city=" + city);

        String[] likes = request.getParameterValues("likes");
        for (int i = 0; likes != null && i < likes.length; i++) {//数据一定要先检查再使用
            System.out.println(likes[i]);
        }

        //图片暂时没有获取，超出今天课程

        String beizhu = request.getParameter("description");
        String id = request.getParameter("id");

        System.out.println("beizhu=" + beizhu);
        System.out.println("id=" + id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
