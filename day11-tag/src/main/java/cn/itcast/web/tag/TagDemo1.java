package cn.itcast.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * TagSupport是tag接口的实现类，方便使用
 * 这个类已经将pageContext对象注入进来了，也就是说9个对象都进来了
 */
//控制标签体是否执行
public class TagDemo1 extends TagSupport {

	@Override //重写开始标签
	public int doStartTag() throws JspException {
		/**
		 * 判断权限，有权限就显示，没权限，不显示
		 */
		
		//执行标签体
		//return Tag.EVAL_BODY_INCLUDE;
		
		//不执行标签体
		return Tag.SKIP_BODY;
	}
}
