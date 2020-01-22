package cn.itcast.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

//修改标签体 要继承BodyTagSupport类,它实现类BodyTag接口
public class TagDemo4 extends BodyTagSupport {

	//bodycontent
	@Override
	public int doStartTag() throws JspException {
		//返回EVAL_BODY_BUFFERED 服务器就会调用setBodyContent()方法把标签体传进来
		//这个就可以调用getBodyContent()方法得到标签体内容了
		return BodyTag.EVAL_BODY_BUFFERED;
	}
	
	@Override
	public int doEndTag() throws JspException {
		//拿到标签体
		BodyContent bodyContent= this.getBodyContent();
		String content = bodyContent.getString();
		String result = content.toUpperCase();
		try {
			//用out输出
			this.pageContext.getOut().write(result);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		//继续解析剩下的JSP
		return Tag.EVAL_PAGE;
	}
}
