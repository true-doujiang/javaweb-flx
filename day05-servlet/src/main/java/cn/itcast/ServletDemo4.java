package cn.itcast;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//讲解细节: 7线程安全
public class ServletDemo4 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	int i = 0;  //这个变量会被共享
	 
	//子类在覆盖父类的方法，不能抛出比父类更多的异常(子类要比父类干更少的坏事)
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//int i = 0;  //这个变量不会被共享
		i++;
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(i);
		response.getOutputStream().write((i + "").getBytes());
	}


}
