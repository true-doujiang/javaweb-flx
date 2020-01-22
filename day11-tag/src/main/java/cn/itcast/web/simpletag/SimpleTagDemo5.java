package cn.itcast.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


//通过属性控制标签体的执行次数
public class SimpleTagDemo5 extends SimpleTagSupport {

	private int count;  //<itcast:demo5 count="6">

	//这个set方法必须对应tld文件里属性的name
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void doTag() throws JspException, IOException {
		for(int i=0;i<count;i++){
			this.getJspBody().invoke(null);
		}
		//this.getJspContext().getOut().write("循环" + count + "次<br>");  //也可以输出
	}
}
