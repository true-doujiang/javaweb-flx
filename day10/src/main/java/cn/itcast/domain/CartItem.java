package cn.itcast.domain;

import lombok.Data;

//cartItem代表某本书，并表示书出现多少次
@Data
public class CartItem {

	private Book book;
	private int quantity;
	private double price; //购买的本类商品总价钱
	

	public double getPrice() {
		System.out.println("==========CarItem====getPrice()=========");
		return book.getPrice()*this.quantity;
	}
}
