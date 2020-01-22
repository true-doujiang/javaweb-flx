package cn.itcast.web.tag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//这个标签才够劲，可以遍历List Map  数组
public class ForEachTag2 extends SimpleTagSupport {

	private Object items;
	private String var;
	private Collection collection;  //单链集合

	public void setItems(Object items) {  //int[]
		this.items = items;  //这已经要不要无所谓了，因为传进来的items被collection接走了

		if(items instanceof Collection){ //list set 都属于collection
			collection = (Collection) items;
		}

		if(items instanceof Map){	//双链集合也改成单链集合
			Map map = (Map) items;
			collection = map.entrySet();  //set
		}

		//搞定所有的数组    (精辟的代码)          	看看java.lang.reflect.Array的API
		if(items.getClass().isArray()){	//只要是数组就到这里   int[] byte[] String[]
			collection  = new ArrayList();  //这里collection必须初始化才能使用add方法
			int len = Array.getLength(items);
			for(int i=0;i<len;i++){
				Object obj = Array.get(items, i); //java.lang.reflect.Array;
				collection.add(obj);
			}
		}

		/*
		int arr[]不属于Object[] 所以8中基本数据类型要写8种
		if(items instanceof Object[]){ 	 
			Object arg[] = (Object[]) items;
			collection = Arrays.asList(arg);  //list
		}
		
		if(items instanceof int[]){
			int temp[] = (int[])items;
			collection = new ArrayList();
			for(int num : temp){
				collection.add(num);
			}
		}
		
		if(items instanceof short[]){
			
		}
			
		}
		 */
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) this.getJspContext();
		Iterator it = collection.iterator();  //null.iterator
		while(it.hasNext()){
			Object obj = it.next();
			pageContext.setAttribute(var, obj);
			this.getJspBody().invoke(null);
		}
	}

}
