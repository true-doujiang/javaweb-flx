package cn.itcast.web.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//这个标签弱爆了，只可以遍历List集合
public class ForEachTag extends SimpleTagSupport {

	private Object items;
	private String var;  //String类型，以他为关键字存到pagecontext域里

	public void setItems(Object items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) this.getJspContext();
		List list = (List) items;
		Iterator it = list.iterator();
		//技巧
		while(it.hasNext()){
			Object obj = it.next();
			pageContext.setAttribute(var, obj);
			this.getJspBody().invoke(null);  //通知标签体执行
		}
	}
}
