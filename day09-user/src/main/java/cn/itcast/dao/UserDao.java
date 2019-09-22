package cn.itcast.dao;

import cn.itcast.domain.User;

public interface UserDao {

	User find(String username, String password);

	void add(User user);

	//注册使用，查看用户名是否已经存在
	User find(String username);
	//boolean find(String username);

}