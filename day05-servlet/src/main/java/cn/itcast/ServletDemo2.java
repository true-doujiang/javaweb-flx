package cn.itcast;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//servlet继承HttpServlet  而 HttpServlet extends GenericServlet implements java.io.Serializable
public class ServletDemo2 extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String http_Method = request.getMethod(); //这个方法也是被封装过得
		System.out.println("请求方式为: " + http_Method); 
		
		//这个流被写进了response里
		response.getOutputStream().write("ServeltDemo2!!".getBytes());
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
