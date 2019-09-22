package cn.itcast;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
  servletContext域：
  1,是一个容器
  2,作用范围是应用程序范围
 */
public class ServletDemo8 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String value = (String) this.getServletContext().getAttribute("data");
		response.getOutputStream().write(value.getBytes());
	}

}
