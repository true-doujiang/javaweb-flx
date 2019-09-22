package cn.itcast.web.formbean;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

@Data
public class RegisterFormBean {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday; //表单提交过来的数据都是字符串类型
	
	//保存校验失败的消息
	private Map<String,String> errors = new HashMap<String, String>(); 
	
	

	
	/*
	private String username;  用户名不能为空，并且要是3-8的字符 abcdABcd
	private String password;  密码不能为空，并且要是3-8的数字
	private String password2; 两次密码要一致
	private String email;     不可以为空且要是一个合法的邮箱
	private String birthday;  可以为空，不为空时，要是一个合法的日期 
	*/
	public boolean validate(){
		boolean isOk = true;
		
		if(this.username==null || this.username.trim().equals("") ){
			isOk = false;
			errors.put("username", "用户名不能为空！！");
		}else{
			if(!this.username.matches("[a-zA-Z]{3,8}")){
				isOk = false;
				errors.put("username", "用户名必须是3-8位的字母！！");
			}
		}
		
		if(this.password==null || this.password.trim().equals("")){
			isOk = false;
			errors.put("password", "密码不能为空！！");
		}else{
			if(!this.password.matches("\\d{3,8}")){
				isOk = false;
				errors.put("password", "密码必须是3-8位的数字！！");
			}
		}
		
		// 两次密码要一致
		if(this.password2==null||this.password2.trim().equals("")){
			isOk = false;
			errors.put("password2", "确认密码不能为空！！");
		}else{
			if(!this.password2.equals(this.password)){
				isOk = false;
				errors.put("password2", "两次密码不一致！！");
			}
		}
		
		//private String email;     不可以为空，不为空要是一个合法的邮箱
		if(this.email==null || this.email.trim().equals("")){
			isOk = false;
			errors.put("email", "邮箱不能为空！！");
		}else{
			// flx_itcast@sina.com.cn
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOk = false;
				errors.put("email", "邮箱格式不合法邮箱！！");
			}
		}
		
		//private String birthday;  可以为空，不为空时，要是一个合法的日期
		if(this.birthday!=null && this.birthday.trim().equals("")){
			try{
				DateLocaleConverter conver = new DateLocaleConverter();
				conver.convert(this.birthday);
			}catch (Exception e) {
				isOk = false;
				errors.put("birthday", "日期格式不对 ！！");
			}
		}
		
		return isOk;
	}
}
