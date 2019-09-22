package cn.itcast.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils {
	
	private static String filename = "users.xml";
	
//	private static String filepath;
//	static{
//		filepath = XmlUtils.class.getClassLoader().getResource("users.xml").getPath();
//	}
	
	public static Document getDocument() throws DocumentException{
		URL url = XmlUtils.class.getClassLoader().getResource(filename);
		String realpath = url.getPath();//路径里有空格
		try {
			realpath = URLDecoder.decode(realpath,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(realpath));
		return document;
	}
	
	public static void write2Xml(Document document) throws IOException{
		URL url = XmlUtils.class.getClassLoader().getResource(filename);
		String realpath = url.getPath();
		try {
			realpath = URLDecoder.decode(realpath,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream(realpath),format);
        writer.write(document);
        writer.close();
	}
	
}
