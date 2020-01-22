package cn.itcast.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Cart;
import cn.itcast.exception.CartNotFoundException;
import cn.itcast.service.BusinessService;


public class UpdateCartServlet extends HttpServlet {
	
	/**
	 * 把购物车中的书修改为指定数量
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String bookid = request.getParameter("bookid");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		
		BusinessService service = new BusinessService();
		try {
			service.updateCart(cart,bookid,quantity);
			request.getRequestDispatcher("/WEB-INF/jsp/listcart.jsp").forward(request, response);
		} catch (CartNotFoundException e) {
			request.setAttribute("message", "对不起，您还没有购买任何商品!!!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
