/**
 * 
 */
package cn.itcast.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

/**作者: 尤欢欢
 * 日期： 2017年10月28日 下午7:35:41
 * 描述： 使用beanUtils框架（Apache开发的）操纵bean的属性 
 *     加入jar:commons-beanutils-1.8.3.jar 它有依赖于一个日志包commons-logging.jar
 */
public class Demo {

	@Test
	public void test1() {
		Person p = new Person();
		try {
			BeanUtils.setProperty(p, "age", 123);
			//BeanUtils.setProperty(p, "idea.sixiang", "我想有钱");  //如果设置的属性值是其他的引用数据类型，此时必须要注册一个类型转换器才能实现自动的转换
			System.out.println(p.getAge()); 
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 Java四类八种基础数据类型
	 第一类：整型 byte short int long
	 第二类：浮点型 float double
	 第三类：逻辑型 boolean(它只有两个值可取true false)
	 第四类：字符型 char 
	 
	 在栈中可以直接分配内存的数据是基本数据类型
	 引用数据类型：是数据的引用在栈中，但是他的对象再堆中
	 */
	@Test
	public void test2() {
		String name = "aaa";
		String age = "123";
		String password = "123456";
		Person p = new Person();
		try {
			BeanUtils.setProperty(p, "name", name);
			BeanUtils.setProperty(p, "age", age);
			BeanUtils.setProperty(p, "password", password);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(p.getName());//aaaa
		System.out.println(p.getAge());//123
		System.out.println(p.getPassword());//123456
	}

	
	@Test
	public void test3() {
		String birthday = "1893-12-01";
		//为了让日期赋值到bean的birthday属性上，给beanUtils注册一个日期转换器
		//ConvertUtils.register(converter, clazz);
		ConvertUtils.register(new Converter() {
			@Override
			public Object convert(Class type, Object value) {
				//System.out.println("type=" + type);  //class java.util.Date
				//System.out.println("value=" + value);//1983-12-01
				if(!(value instanceof String)){
					new ConversionException("只支持String类型的转换"); //抛那个异常查API
				}
				String val = (String) value;
				if(val.trim().equals("")){
					return null;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = null;
				try {
					date = sdf.parse(val);
				} catch (ParseException e) {
					throw new RuntimeException(e);	//抛一个运行时异常、不可以继续再往下执行了。e放进去，异常链不能断				
				}
				return date;
			}
		}, Date.class);
		
		try {
			Person p = new Person();
			BeanUtils.setProperty(p, "birthday", birthday);
			Date date = p.getBirthday();
			// 打印对象会默认调用对象的toString方法。Date对象的toSting方法to出来的就是老外喜欢看的日期格式了
			System.out.println(date.toLocaleString());
			System.out.println("___"+BeanUtils.getProperty(p, "birthday"));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4() throws Exception {
		String birthday="1990-12-1";
		//String birthday="";  //这种情况就会出错了  org.apache.commons.beanutils.ConversionException
		
		//使用自带的转换器DateLocaleConverter()，但是不好有bug 
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person p = new Person();
		BeanUtils.setProperty(p, "birthday", birthday);
		System.out.println(p.getBirthday()); 
	}
	
	@Test
	public void test5() throws Exception {
		Map map = new HashMap();
		map.put("name", "yhh");
		map.put("password", "123456");
		map.put("age", "11");
		map.put("birthday", "1990-12-1");
		
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		Person p = new Person();
		//此时用 populate() 	用map集合填充bean属性, map关键字和bean属性要一致
		BeanUtils.populate(p, map);
		
		System.out.println(p);
	}
}
