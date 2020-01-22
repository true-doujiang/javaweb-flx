package cn.itcast.dao;

import java.util.Map;

import cn.itcast.db.MyDb;
import cn.itcast.domain.Book;

public class BookDao {

	public Map getAll(){
		return MyDb.getAll();
	}
	
	public Book find(String id){
		return (Book) MyDb.getAll().get(id);
	}
	
}
