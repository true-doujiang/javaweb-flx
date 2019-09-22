package cn.itcast;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 讲解 ServletContext对象(接口)
 * 
 *  5、实现Servlet的转发。
 */
public class ServletDemo10 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String data="aaaa中国aaaaaa";
		//把数据传送到1.JSP(实际：不能通过context域，要通过request域)
		this.getServletContext().setAttribute("jspdata", data);
		//Servlet的转发
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/1.jsp");
		rd.forward(request, response);	
		
		//以后都是用request转发
		//request.getRequestDispatcher("/1.jsp").forward(request, response);
	}

}
