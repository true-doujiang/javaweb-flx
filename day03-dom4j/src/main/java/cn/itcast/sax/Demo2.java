package cn.itcast.sax;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 作者: 尤欢欢
 * 日期： 2017年10月29日 下午6:12:07
 * 描述：sax解析xml文档
 */
public class Demo2 {

	public static void main(String[] args) throws Exception {
		//1.创建解析工厂
		SAXParserFactory factory=SAXParserFactory.newInstance();
		//2.得到解析器
		SAXParser sp=factory.newSAXParser();
		//3.得到读取器
		XMLReader reader=sp.getXMLReader();
		//4.设置内容处理器
		reader.setContentHandler(new TagValueHandler());
		//5.读取xml文档内容
		reader.parse("src/book.xml");
	}
}
//获取指定标签  作者 的值
class TagValueHandler extends DefaultHandler{
	
	private String currentTag;//记住当前解析器得到的是什么标签
	private int needNumber = 1;//记住想获取第几个作者标签的值
	private int currentNumber;//当前解析的是第几个	
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currentTag=qName;
		if("作者".equals(currentTag))
			currentNumber++;
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if("作者".equals(currentTag)&& currentNumber==needNumber){
			System.out.println(new String(ch,start,length));
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		currentTag = null;	//置空
	}


	
}
