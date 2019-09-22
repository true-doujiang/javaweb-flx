package cn.itcast.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//购买servlet
public class SessionDemo1 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//访问  http://localhost:8088/day07/session.jsp   用jsp访问会默认创建cookie：JSESSIONID=BC1BCABEC01AE95A779397B6ABF02D46
		//访问  http://localhost:8088/day07/session.html
		//IE浏览器不会拒绝localhost的cookie，所以改成127.0.0.1测试禁用cookie的情况
		/**
		 * 1.第一次执行到request.getSession()的时候才真正的创建session
		 * 2.可以再web.xml里配session的有效期  单位分钟  默认是30分钟
			  <session-config>
			  	<session-timeout>1</session-timeout>
			  </session-config>
		   3.用户打开浏览器，去玩了30多分钟，再操作浏览器，session也会被销毁
		   4.session.invalidate(); 也可以销毁session
		   5.getSession()有个重载方法getSession(true/false);  false:只获取session，不创建session
		 */
		HttpSession session = request.getSession(); //这一句话才真正的创建session
		
		/**
		  session是基于cookie的，
		    服务器创建session后会把session的id保存cookie（Java默认会创建一个JSESSIONID的cookie回写给浏览器）里
		    但是这个cookie是没有设置有限期的，如果我们关闭了浏览器，这个cookie就没了，浏览器也就找不到它所对应session了。
		    所以我们给这个cookie设置有效期，在有效期内在访问服务器时，会带着这个cookie，也就能找到对应的session了
		*/
		//----------------------------
		String sessionid = session.getId();
		Cookie cookie = new Cookie("JSESSIONID",sessionid);
		cookie.setMaxAge(10*60); //10分钟
		cookie.setPath("/day07");
		response.addCookie(cookie); //覆盖默认的cookie
		//--------------------------
		session.setAttribute("name", "洗衣机");	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
