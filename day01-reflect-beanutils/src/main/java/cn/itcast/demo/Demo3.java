/**
 * 
 */
package cn.itcast.demo;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**作者: 尤欢欢
 * 日期： 2017年10月28日 下午5:42:00
 * 描述： 
 */
public class Demo3 {

	
	
	@Test
	public void test1(){
		//Map map = new HashMap();
		Map map = new LinkedHashMap<String,String>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		//传统方式1     对key迭代
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext()){
			String key = (String)it.next();
			String value = (String) map.get(key);
			System.out.println("key="+key+",value="+value);
		}
		//传统方式2    对key-value迭代
		Set set2 = map.entrySet();
		Iterator it2 = set2.iterator();
		while(it2.hasNext()){
			Map.Entry  entry = (Entry)it2.next();
			System.out.println("key="+entry.getKey()+",value="+entry.getValue());
		}
		
		//建立在传统方式之上的
		//增强for循环的1种方式
		for(Object obj : map.keySet()){
			String key2 = (String)obj;
			String value2 = (String)map.get(key2);
			System.out.println("key2=" + key2 + ",value2=" + value2);
		}
		//增强for循环的2种方式
		for(Object obj : map.entrySet()){
			Map.Entry entry3 = (Entry) obj;
			String key3 = (String) entry3.getKey();
			String value3 = (String) entry3.getValue();
			System.out.println("key3=" + key3 + ",value3=" + value3);
		}
	}
	
	@Test
	public void test2() {
		//增强for循环需要注意的问题：只适合取数据
		int[] arr = {1,2,3};
		for (int i : arr) {
			i = 10;
		}
		System.out.println(Arrays.toString(arr)); 
	}
	
	
}
