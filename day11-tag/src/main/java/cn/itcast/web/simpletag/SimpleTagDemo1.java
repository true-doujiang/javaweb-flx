package cn.itcast.web.simpletag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//控制标签体是否执行     SimpleTagSupport implements SimpleTag
public class SimpleTagDemo1 extends SimpleTagSupport {

	//简单标签使用这个方法完成所有业务逻辑
	@Override
	public void doTag() throws JspException, IOException {
	
		//得到代表标签体的JspFragment
		JspFragment jf = this.getJspBody();
		
		/**输出到浏览器2种方式*/
		//第一种：
		//PageContext pageContext = (PageContext) this.getJspContext();
		//jf.invoke(pageContext.getOut());
		
		//第二种：
		//jf.invoke(null);//传入null同上
	}
}
