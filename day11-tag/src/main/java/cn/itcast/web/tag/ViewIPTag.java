package cn.itcast.web.tag;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/** 
 * 开发自定义标签要查看jsp的API  不是ServletAPI 
 * 
 * 标签执行流程参考word里的执行流程图,也可以打开服务器查看使用这个标签翻译后的Servlet
 */
public class ViewIPTag implements Tag {

	private PageContext pageContext;
	
	public int doStartTag() throws JspException {
		System.out.println("doStartTag");
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		JspWriter out = pageContext.getOut();
		String ip = request.getRemoteAddr();
    	try {
			out.write(ip);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return 0;
	}
	
	public int doEndTag() throws JspException {
		System.out.println("doEndTag");
		return 0;
	}
	
	public Tag getParent() {
		System.out.println("getParent");
		return null;
	}
	
	//等到服务器关闭的时候执行，释放资源  (生命周期类似Servlet)
	public void release() {
		System.out.println("release");
	}
	
	//实例化对象后就调用我，以便传进去其他对象   ,这个方法是服务器调用的
	public void setPageContext(PageContext arg0) {
		System.out.println("setPageContext");
		this.pageContext = arg0;
	}
	//这个方法也是服务器调用  如果有父标签则把父标签传递进来,没有传个null进来
	public void setParent(Tag arg0) {
		System.out.println("setParent");
	}
}
