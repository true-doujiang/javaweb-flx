package cn.itcast.dom4j;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

/**
 * 作者: 尤欢欢
 * 日期： 2017年10月29日 下午6:12:07
 * 描述：
 */
public class Demo4 {

	public static void main(String[] args) throws Exception {
		//应用xpath提取xml文档的数据,需要包jaxen-1.1-beta-6.jar
		
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book.xml"));
		String value = document.selectSingleNode("//作者").getText();// 第一个值
		System.out.println(value);
	}
}
