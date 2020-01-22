package cn.itcast.web.simpletag;

import java.io.IOException;
import java.io.StringWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//修改标签体
public class SimpleTagDemo3 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		//带缓冲区,且又能把缓冲区的数据取出来     
		StringWriter sw = new StringWriter();  //StringWriter extends Writer
		jf.invoke(sw);  //把内容写入缓冲区
		//又把缓冲区的数据取出来  
		String content = sw.getBuffer().toString();
		content = content.toUpperCase();
		
		PageContext pageContent = (PageContext) this.getJspContext(); //JspContext 实际就是PageContext
		pageContent.getOut().write(content);
	}
}
