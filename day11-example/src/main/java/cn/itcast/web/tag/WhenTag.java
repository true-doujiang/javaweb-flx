package cn.itcast.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//父标签 choose
//子标签 when
//子标签 otherwise
public class WhenTag extends SimpleTagSupport {

	private boolean test;

	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("when子标签执行");

		ChooseTag parent = (ChooseTag) this.getParent();
		if(test==true && parent.isOk()==false){
			this.getJspBody().invoke(null);
			parent.setOk(true); //when执行了就要将父标签的标志值为true
		}
	}
}
