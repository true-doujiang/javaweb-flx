package cn.itcast.web.simpletag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


//属性说明
public class SimpleTagDemo6 extends SimpleTagSupport {

	private Date date;
	
	//这个方法的名字必须对应tld里的属性name
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext) this.getJspContext();
		pageContext.getOut().write(date.toLocaleString()+"<br/>");
	}
}
