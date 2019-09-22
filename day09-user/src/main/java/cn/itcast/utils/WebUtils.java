package cn.itcast.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;


public class WebUtils {

	//把request对象中的请求参数封装到bean中
	public static <T> T request2Bean(HttpServletRequest request,Class<T> clazz){
		try{
			//1、创建要封装数据的bean
			T bean = clazz.newInstance();
			//2、
			Enumeration e = request.getParameterNames(); 
			while(e.hasMoreElements()){
				String name = (String) e.nextElement();  //username=aaa password=123
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value); //BeanUtils工具类 查API
			}
			return bean;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static void copyBean(Object src,Object dest){
		/*		formbean
		private String username;
		private String password;
		private String password2;
		private String email;
		private String birthday; 
			
			   user
		private String id;
		private String username;
		private String password;
		private String email;
		private Date birthday;
		*/
		
		//一定要放在 BeanUtils.copyProperties(dest, src);前面
		ConvertUtils.register(new Converter(){

			public Object convert(Class type, Object value) {
				if(value==null){
					return null;
				}
				String str = (String) value;
				if(str.trim().equals("")){
					return null;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try {
					date = sdf.parse(str);
				} catch (ParseException e) {
					throw new RuntimeException(e);
				}
				return date;
			}
			//只有日期的时候才调用我
		}, Date.class);
		
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//产生全世界唯一ID
	public static String makeId(){
		//UUID   128 36位字符
		return UUID.randomUUID().toString();
	}
	
}
