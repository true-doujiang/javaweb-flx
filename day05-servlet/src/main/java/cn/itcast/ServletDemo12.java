package cn.itcast;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.dao.UserDao;

/**
 * servlet调用其它程序，在其它程序中如何去读取配置文件,通过类装载器
 */
public class ServletDemo12 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDao user = new UserDao();
		user.update();
	}
}
