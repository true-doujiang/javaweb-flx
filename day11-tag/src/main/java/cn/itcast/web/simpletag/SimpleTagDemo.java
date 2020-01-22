package cn.itcast.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class SimpleTagDemo implements SimpleTag {
	
	private JspFragment jspFragment = null;
	private JspContext jspContext = null;
	
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag");
		jspFragment.invoke(jspContext.getOut());
		//执行完就销毁该对象，与传统标签不同的
	}
	
	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
		this.jspFragment = arg0;
	}

	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println("setJspContext");
		this.jspContext = arg0;
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}

}
