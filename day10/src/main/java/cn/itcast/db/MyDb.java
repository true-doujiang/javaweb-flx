package cn.itcast.db;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.itcast.domain.Book;


//模似数据库
public class MyDb {

	private static Map<String,Book> map = new LinkedHashMap<String, Book>();
	
	static{
		map.put("1", new Book("1","javaweb开发","老张",20,"一本经典的书"));
		map.put("2", new Book("2","jdbc开发","李勇",30,"一本jdbc的书"));
		map.put("3", new Book("3","spring开发","老黎",50,"一本相当经典的书"));
		map.put("4", new Book("4","hibernate开发","老佟",56,"一本佟佟的书"));
		map.put("5", new Book("5","struts开发","老毕",40,"一本经典的书"));
		map.put("6", new Book("6","ajax开发","老张",50,"一本老张的书"));
	}
	
	public static Map getAll(){
		return map;
	}
	
	
}
