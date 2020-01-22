package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Cart;
import cn.itcast.service.BusinessService;
//完成购买操作
public class BuyServlet extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookid = request.getParameter("bookid");
		
		//得到用户的购物车          把用户买的书加到购物车中 
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if(cart==null){
			cart = new Cart();
			request.getSession().setAttribute("cart", cart);
		}
		BusinessService service = new BusinessService();
		service.buybook(bookid,cart);
		//用转发缺陷：刷新购物车页面的时候就又购买了一次,应该用重定向
		//request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/servlet/ListCardUIServlet");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
