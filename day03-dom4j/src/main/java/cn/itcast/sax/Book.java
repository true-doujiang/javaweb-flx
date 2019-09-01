package cn.itcast.sax;

public class Book {
	
	private String name;
	private String author;
	//应该用double，这里简化了
	private String price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [author=" + author + ", name=" + name + ", price=" + price
				+ "]";
	}
	
	
}
