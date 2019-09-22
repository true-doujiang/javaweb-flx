package cn.itcast.service;

import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;

public interface BusinessService {

	//提供注册服务
	void registerUser(User user) throws UserExistException; //抛出一个自定义编译时异常

	User loginUser(String username, String password);

}