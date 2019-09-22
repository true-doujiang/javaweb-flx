package cn.itcast.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.BusinessService;
import cn.itcast.service.impl.BusinessServiceImpl;
import cn.itcast.utils.WebUtils;
import cn.itcast.web.formbean.RegisterFormBean;

//处理注册请求
public class RegisterServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//千万不能忘，不然中文检验不过去
		request.setCharacterEncoding("UTF-8");

		RegisterFormBean formbean = WebUtils.request2Bean(request, RegisterFormBean.class);
		
		//1、对提交表单的字段合法性校验
		if(formbean.validate()==false){
			//2、如果校验失败，调回到表单页面，回显校验失败信息
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
			return;
		}
		
		
		//把表单的数据填充到javabean中
		User user = new User();
		try {
			//注册字符串到日期的转换器
			//ConvertUtils.register(new DateLocaleConverter(), Date.class);
			//BeanUtils.copyProperties(user, formbean);
			WebUtils.copyBean(formbean, user);
			user.setId(WebUtils.makeId());
			
			//3、校验成功，则调用service处理请求
			BusinessService service = new BusinessServiceImpl();
			service.registerUser(user);
			
			//6、如果service处理成功，跳转到网站全局局显示页面，为用户注册成功的消息
			request.setAttribute("message", "恭喜您，注册成功！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		
		}catch (UserExistException e) {
			//4、如果service处理不成功，并且原因是因为用户已存在的话，则跳转注意页面，显示注册用户已存在
			formbean.getErrors().put("username", "注册用户已存在！！");
			request.setAttribute("formbean", formbean);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			//5、如果service处理不成功，并且原因是其他问题的话，跳转到网站的全局显示页面，为用户显示友好错误消息
			e.printStackTrace();  //在后台记录异常
			request.setAttribute("message", "对不起，服务器出现未知错误！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
