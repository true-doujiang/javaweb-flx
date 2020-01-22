package cn.itcast.service;

import java.util.Map;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;
import cn.itcast.exception.CartNotFoundException;

public class BusinessService {
	
	BookDao dao = new BookDao();
	
	//列出所有书的服务
	public Map getAllBook(){
		return dao.getAll();
	}

	public void buybook(String bookid, Cart cart) {
		Book book = dao.find(bookid);
		cart.add(book);
	}

	//删除购物车里的指定项
	public void deleteBook(String bookid, Cart cart) throws CartNotFoundException {
		if(cart==null){
			throw new CartNotFoundException("购物车为空！！");
		}
		Map map = cart.getMap();
		map.remove(bookid);
	}

	//清空购物车
	public void clearCart(Cart cart) throws CartNotFoundException {
		if(cart==null){
			throw new CartNotFoundException("购物车为空！！");
		}
		Map carmap = cart.getMap();
		carmap.clear();
	}

	//修改指定书的数量
	public void updateCart(Cart cart, String bookid, int quantity) throws CartNotFoundException {
		if(cart==null){
			throw new CartNotFoundException("购物车为空！！");
		}
		CartItem item = cart.getMap().get(bookid);
		item.setQuantity(quantity);
	}
	
}
