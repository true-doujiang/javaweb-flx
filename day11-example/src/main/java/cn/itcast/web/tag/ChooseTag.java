package cn.itcast.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//父标签 choose
//子标签 when
//子标签 otherwise
public class ChooseTag extends SimpleTagSupport {

	private boolean isOk;  //is 生成get、set方法时特殊

	public boolean isOk() {//get
		return isOk;
	}
	public void setOk(boolean isOk) {  //set
		this.isOk = isOk;
	}

	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("isOk默认值:" + isOk); //false
		this.getJspBody().invoke(null);  //执行标签体
	}
}
