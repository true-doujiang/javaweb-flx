package cn.itcast.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

//控制标签体重复执行5次
public class TagDemo3 extends TagSupport {

	int x = 5;
	
	@Override
	public int doStartTag() throws JspException {
		return Tag.EVAL_BODY_INCLUDE;  //让表标签体执行
	}
	
	/** doAfterBody在开始标签之后，结束标签之前执行
	 */
	@Override
	public int doAfterBody() throws JspException {
		x--;
		if(x>0){
			//IterationTag(接口) 重复执行只能靠它
			return IterationTag.EVAL_BODY_AGAIN;
		}else{
			return IterationTag.SKIP_BODY;
		}
	}
}
