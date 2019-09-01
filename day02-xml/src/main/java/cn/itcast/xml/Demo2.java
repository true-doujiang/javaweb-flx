package cn.itcast.xml;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Document;

public class Demo2 {
	
	@Test
	public static void main(String[] args) throws Exception {
		
		//1.创建工厂(抽象类,不可以new,查API)
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 
		//2.得到dom解析器					  //新的 DocumentBuilder 实例
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 
		//parse(String uri) 将给定 URI 的内容解析为一个 XML 文档，并且返回一个新的 DOM Document 对象
		//3.解析xml文档，得到代表文档的document   
		 Document document = builder.parse("src/Book.xml");
		
		 //System.out.println(document);
	}

}