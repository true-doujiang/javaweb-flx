/**
 * 
 */
package cn.itcast.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.itcast.beanutils.Person;

/**作者: 尤欢欢
 * 日期： 2017年10月28日 下午6:12:20
 * 描述： 
 */
public class Demo4 {

	@Test
	public void testSum() {
		sum(1,2,3,4);
		int[] arr = {5,6,7};
		sum(arr);//给它一个int类型的数组也可以
	}

	private void sum(int ...nums) {
		/**
		 * 调用可变参数的方法时, 编译器将自动创建一个数组保存传递给方法的可变参数，
		 * 因此，程序员可以在方法体中以数组的形式访问可变参数
		 * 可以把nums当成一个数组
		 */
		int sum = 0;
		for (int i : nums) {
			System.out.println(i);
			sum += i;
		}
		System.out.println("sum=" + sum);
	}
	
	/**
	 * 可变参数注意的问题
	 */
	//public void aa(int ...nums,int s){}//不可以
	//public void bb(int s ,int ...nums) //可以
	
	@Test
	public void test2() {
		/**
		 @SafeVarargs
	     public static <T> List<T> asList(T... a) {
	         return new ArrayList<>(a);
	     }
		 */
		List list = Arrays.asList("1","4","y","77");
		System.out.println(list);
		
		String arr[] = {"1","2","3","4"};
		list = Arrays.asList(arr);
		System.out.println(list);//[1, 2, 3, 4]
		
		/**
		 * asList(T ...a)要的是对象类型
		 * 这里把int[] 当成一个对象了      细节******
		 */
		int[] nums = {1,4,2,5};
		list = Arrays.asList(nums);
		System.out.println(list);
		
		Integer nums2[] = {1,2,3,4,5};
		list = Arrays.asList(nums2);
		System.out.println(list);//[1, 2, 3, 4, 5]
		
		//--------------------------------------
		Person p = new Person();
		p.setAge(100);
		p.setName("yhh");
		p.setPassword("123456");
		p.setBirthday(new Date());
		
		Person p2 = new Person();
		p2.setAge(100);
		p2.setName("lll");
		p2.setPassword("123456");
		p2.setBirthday(new Date());
		
		List plist = Arrays.asList(p,p2);
		System.out.println(plist);
	}
	
	
	
}
