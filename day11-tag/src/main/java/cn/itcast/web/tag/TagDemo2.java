package cn.itcast.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

//控制jsp页面是否执行
public class TagDemo2 extends TagSupport {

	@Override  //重写doEndTag方法，不是开始标签了
	public int doEndTag() throws JspException {
		
		System.out.println("TagDemo2");
		
		return Tag.SKIP_PAGE;  //余下jsp不会执行
		//return Tag.EVAL_PAGE;
	}
}
