package cn.itcast.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//父标签 choose
//子标签 when
//子标签 otherwise
public class OtherwiseTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("otherwise子标签执行");

		ChooseTag parent = (ChooseTag) this.getParent();
		if(parent.isOk()==false){
			this.getJspBody().invoke(null);
			parent.setOk(true);
		}
	}

}
