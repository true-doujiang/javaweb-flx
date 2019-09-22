package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//false 不需要创建session
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.removeAttribute("user");
		}
		//注销成功，跳到全局消息显示页面，显示注销成功，并控制页面过3s跳转到首页
		request.setAttribute("message", "注销成功！！浏览器将在5s后跳转到首页...<meta http-equiv='refresh' content='5;url="+request.getContextPath()+"/index.jsp'/>");
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
