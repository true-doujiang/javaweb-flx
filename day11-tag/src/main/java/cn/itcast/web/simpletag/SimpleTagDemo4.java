package cn.itcast.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//控制标签余下的jsp不执行
public class SimpleTagDemo4 extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
				//抛这个异常给jsp，后面的JSP就不执行了
		throw new SkipPageException();
	}
}
