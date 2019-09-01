/**
 * 
 */
package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**作者: 尤欢欢
 * 日期： 2017年10月28日 下午5:35:32
 * 描述： 
 */
public class Demo2 {

	/**
	 * 对象只能强制转成对象，不可以对象强制转成基本数据类型。
	 * 但是：包装类型的对象可以转成其对象的基本数据类型。
	 */
	public static void main(String[] args) {
		Integer i = 1;//装箱
		int j = i;	  //拆箱

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		int k = list.get(0);
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			Integer next = (Integer)it.next();//拆箱	Object不可以直接转成基本数据类型，但是可以转成基本数据类型的包装类型
			System.out.println(next); 
		}
	}

}
