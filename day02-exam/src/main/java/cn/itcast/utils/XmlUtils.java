/**
 * 
 */
package cn.itcast.utils;

import java.io.File;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**作者: 尤欢欢
 * 日期： 2017年10月29日 下午4:52:11
 * 描述： 
 */
public class XmlUtils {

	//工具类的方法一般都设计成静态的
	public static Document getDocument()throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		ClassLoader classLoader = XmlUtils.class.getClassLoader();
		URL resource = classLoader.getResource("student.xml");
		String path = resource.getPath();
		//System.out.println(path);
		Document document = builder.parse(new File(path));
		return document;
	}
	
	public static void write2Xml(Document document) throws TransformerException{ 
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
													// new StreamResult(new FileOutputStream("src/student.xml"))
		transformer.transform(new DOMSource(document), new StreamResult(new File("src/student.xml")));
	}
}
