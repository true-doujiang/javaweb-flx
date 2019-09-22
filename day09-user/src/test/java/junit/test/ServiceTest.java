package junit.test;

import java.util.Date;
import org.junit.Test;
import cn.itcast.domain.User;
import cn.itcast.exception.UserExistException;
import cn.itcast.service.impl.BusinessServiceImpl;


public class ServiceTest {
	
	@Test
	public void testAdd(){
		User user = new User();
		user.setId("3333");
		user.setUsername("cccc");
		user.setPassword("123");
		user.setEmail("bb@sina.com");
		user.setBirthday(new Date());
		
		BusinessServiceImpl service = new BusinessServiceImpl();
		try {
			service.registerUser(user);
			System.out.println("注册成功！！");
		} catch (UserExistException e) {
			System.out.println("用户已存在！！");
		}
	}
	
	@Test
	public void testLogin(){
		BusinessServiceImpl service = new BusinessServiceImpl();
		User user = service.loginUser("cccc", "123");
		System.out.println(user);
	}
	
	
}
