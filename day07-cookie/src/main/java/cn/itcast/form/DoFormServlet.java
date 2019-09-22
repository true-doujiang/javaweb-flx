package cn.itcast.form;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//2、处理表单提交请求    和struts的token做法是一样一样的
public class DoFormServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        boolean b = isToken(request);  //判断用户是否是重复提交
        if (b == true) {
            System.out.println("请不要重复提交");
            out.write("请不要重复提交 ！");
            return;
        }
        //提交成功后把服务器里的token删掉
        request.getSession().removeAttribute("token");
        System.out.println("处理用户提交请求！！");
        out.write("恭喜！登录成功！");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 验证token是否有效
     */
    private boolean isToken(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        if (client_token == null) {    //不带token也任务是重复提交
            return true;
        }

        String server_token = (String) request.getSession().getAttribute("token");
        if (server_token == null) { //服务器里没有token了也认为是重复提交
            return true;
        }
        if (!client_token.equals(server_token)) {
            return true;    //服务器里的token和带过来的token不一样也任务是重复提交
        }
        return false;
    }
}
