package cn.itcast.web.simpletag;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//控制标签执行10次
public class SimpleTagDemo2 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		for(int i=0;i<10;i++){
			jf.invoke(null);
			//PageContext pageContent = (PageContext) this.getJspContext();
			//jf.invoke(pageContent.getOut());
		}
	}
}
