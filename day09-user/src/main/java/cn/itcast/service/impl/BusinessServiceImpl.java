package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoXmlImpl;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.BusinessService;
import cn.itcast.utils.ServiceUtils;

/**
 * @author 尤欢欢
 * 对web层提供所有的服务
 */
public class BusinessServiceImpl implements BusinessService {

	//这里service层和dao层并没有实现解耦
	UserDao dao = new UserDaoXmlImpl(); //工厂模式  spring 可以实现解耦
	
	//提供注册服务
	public void registerUser(User user) throws UserExistException{
		if(dao.find(user.getUsername())!=null){
			//checked exception 
			//unchecked exception
			//这里抛编译时异常的原因：是我想上一层(web)程序处理这个异常，以给用户一个友好提示
			throw new UserExistException("注册的用户名已存在！！！");
		}
		
		String password = ServiceUtils.md5(user.getPassword()); //把密码加密
		user.setPassword(password);
		dao.add(user);
	}
	
	//提供登录服务
	public User loginUser(String username,String password){
		password = ServiceUtils.md5(password);
		return dao.find(username, password);
	}
	
}
