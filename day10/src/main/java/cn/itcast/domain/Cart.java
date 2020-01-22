package cn.itcast.domain;

import java.util.LinkedHashMap;
import java.util.Map;

//代表购物车
public class Cart {

	//用于保存购物车中所有商品
	private Map<String,CartItem> map = new LinkedHashMap();
	private double price;  //0   购物车中所有商品的总价钱
	
	//添加一本书
	public void add(Book book){  //javaweb
		//查看购物车里有没有要买的这本书
		CartItem item = map.get(book.getId());
		if(item!=null){
			item.setQuantity(item.getQuantity()+1);
		}else{
			//没有就是第一次这本书购买
			item = new CartItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(), item);
		}
	}
	
	
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	
	//计算购物车里所有商品的总价
	public double getPrice() {
		double totalprice = 0;
		for(Map.Entry<String,CartItem> me : map.entrySet()){
			CartItem item = me.getValue();
			totalprice += item.getPrice();
		}
		System.out.println("==========Car====getPrice()=========");
		//this.price = totalprice;  return price;
		return totalprice;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
