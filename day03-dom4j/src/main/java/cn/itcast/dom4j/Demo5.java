package cn.itcast.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 作者: 尤欢欢
 * 日期： 2017年10月29日 下午6:12:07
 * 描述：
 */
public class Demo5 {

	public static void main(String[] args) throws DocumentException {
		
		String username = "aaa";
		String password = "123";
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/users.xml"));
		//XPath表达式要学一下 @ ''
		Element element = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
		if(element!=null){
			System.out.println("让用户登陆成功！！");
		}else{
			System.out.println("用户名和密码不正确！！");
		}

	}

}
