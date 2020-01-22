package cn.itcast.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagSupport是tag接口的实现类，方便使用
 * 这个类已经将pageContext对象注入进来了，也就是说9个对象都进来了
 */
public class ViewIPTagDemo extends TagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
															//直接拿pageContext
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		JspWriter out = this.pageContext.getOut();
		String ip = request.getRemoteAddr();
		try {
			out.write(ip);
		} catch (IOException e) {
			//子类的异常不能抛给父类，所以这里只能捕获(子类不能比父类干跟多的坏事)
			throw new RuntimeException(e);
		}
		return super.doStartTag();
	}
}
