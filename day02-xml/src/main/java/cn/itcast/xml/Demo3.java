package cn.itcast.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 作者: 尤欢欢
 * 日期： 2017年10月28日 下午9:35:33
 * 描述： 使用dom方式对xml文档进行CRUD
 */
public class Demo3 {
	
	//读取<书名>C++教程</书名>
	@Test
	public void read1() throws Exception {
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 Document document = builder.parse("src/book.xml");
		 
		 String path = document.getDocumentURI();
		 System.out.println(path);
		 
//		 Element element = document.getDocumentElement();
//		 NodeList list2 = element.getElementsByTagName("书名");
//		 Node node2 = list2.item(1);
//		 String content2 = node2.getTextContent();
//		 System.out.println(content2);//C++教程
		 
		 //public interface Document extends Node 
		 NodeList list = document.getElementsByTagName("书名"); //同js
		 Node node = list.item(1);
		 String content = node.getTextContent();
		 System.out.println(content);//C++教程
	}
	
	
	
	@Test  //得到文档中所有标签
	public void read2() throws Exception {
		 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder=factory.newDocumentBuilder();
		 Document document=builder.parse("src/book.xml");
		 //获取根节点
		 Node root=document.getElementsByTagName("书架").item(0);
		 //Node bookname =document.getElementsByTagName("书名").item(0);
		 list(root);
	}

	private void list(Node node) {
		Node child;
		if (node instanceof Element){ //过滤空节点#text
			System.out.println(node.getNodeName());
		}
		
		NodeList nodelist = node.getChildNodes();
		for (int i=0; i<nodelist.getLength(); i++){	
			child = nodelist.item(i);
			list(child);	//递归	
		}		
	}
	
	
	
	@Test  //得到文档中标签属性<书名 name="xxxx">java web就业</书名>
	public void read3() throws Exception {
		 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder=factory.newDocumentBuilder();
		 Document document=builder.parse("src/book.xml");

		 NodeList list=document.getElementsByTagName("书名");
		 Node node=list.item(0);
		 if(node.hasAttributes()){
			 NamedNodeMap nodemap = node.getAttributes();
			 for(int i=0;i<nodemap.getLength();i++){
				 Node nd=nodemap.item(i);
				 String strname=nd.getNodeName();
				 String strval=nd.getNodeValue();
				 System.out.println(strname+":"+strval);//name:xxxx
				 
			 }			 
		 }
		 
		 				//这里我知道list.item(0)是元素才可以强转的
		 Element node2 = (Element)list.item(0);
		 String str3 = node2.getAttribute("name");
		 System.out.println("name="+str3); //__xxxx
	}
	
	
	@Test  //<售价>10</售价>	
	public void add() throws Exception{
		 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder=factory.newDocumentBuilder();
		 Document document=builder.parse("src/book.xml");
		 //创建节点
		 Element price=document.createElement("售价");
		 price.setTextContent("59.0元");
		 //把创建的节点放到第一本书上
		 document.getElementsByTagName("书").item(0).appendChild(price);
		 //把跟新后的内容写回文档
		 Transformer transformer=TransformerFactory.newInstance().newTransformer();
		 DOMSource source=new DOMSource(document);
		 FileOutputStream outstream =new FileOutputStream(new File("src/outbook.xml"));
		 StreamResult reslut=new StreamResult(outstream);
		 transformer.transform(source, reslut);
		 outstream.close();		
	}
	
	//向文档中指定位置上添加节点  <售价>10</售价>	
	@Test
	public void add2() throws Exception{
		 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder=factory.newDocumentBuilder();
		 Document document=builder.parse("src/book.xml");
		 //创建节点
		 Element price=document.createElement("售价");
		 price.setTextContent("59.0元");
		 //得到参考节点
		 Element refNode=(Element)document.getElementsByTagName("售价").item(0);
		 //得到挂崽的节点
		 Element book=(Element)document.getElementsByTagName("书").item(0);
		 //把创建的节点放到第一本书上
		 document.getElementsByTagName("书").item(0).appendChild(price);
		 // 往book节点指定位置插值
		 book.insertBefore(price, refNode);
		 Transformer transformer=TransformerFactory.newInstance().newTransformer();
		 DOMSource source=new DOMSource(document);
		 FileOutputStream outstream =new FileOutputStream(new File("src/outbook2.xml"));
		 StreamResult reslut=new StreamResult(outstream);
		 transformer.transform(source, reslut);
		 outstream.close();		
	}
	//向文档节点 添加属性 <售价>10</售价>	
	@Test
	public void addAtt() throws Exception{
		 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder=factory.newDocumentBuilder();
		 Document document=builder.parse("src/book.xml");
		 
		 //得到参考节点
		 Element refNode=(Element)document.getElementsByTagName("售价").item(0);
		 refNode.setAttribute("addAtrr","new cha ru value");
		 
		
		
		 Transformer transformer=TransformerFactory.newInstance().newTransformer();
		 DOMSource source=new DOMSource(document);
		 FileOutputStream outstream =new FileOutputStream(new File("src/outbook3.xml"));
		 StreamResult reslut=new StreamResult(outstream);
		 transformer.transform(source, reslut);
		 outstream.close();		
	}
	//删除 <售价>10</售价>	
	@Test
	public void delete() throws Exception{
		 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder=factory.newDocumentBuilder();
		 Document document=builder.parse("src/book.xml");
		 
		 //得到要删除的节点
		 Element refNode=(Element)document.getElementsByTagName("售价").item(0);
		 refNode.getParentNode().removeChild(refNode);
		
		
		 Transformer transformer=TransformerFactory.newInstance().newTransformer();
		 DOMSource source=new DOMSource(document);
		 FileOutputStream outstream =new FileOutputStream(new File("src/outbook3.xml"));
		 StreamResult reslut=new StreamResult(outstream);
		 transformer.transform(source, reslut);
		 outstream.close();		
	}
	//更新 售价
	@Test
	public void update() throws Exception{
		 DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder=factory.newDocumentBuilder();
		 Document document=builder.parse("src/book.xml");
		 
		 //得到要更新的节点
		 Element refNode=(Element)document.getElementsByTagName("售价").item(0);
		 refNode.setTextContent("1000");
		 
		 Transformer transformer=TransformerFactory.newInstance().newTransformer();
		 DOMSource source=new DOMSource(document);
		 FileOutputStream outstream =new FileOutputStream(new File("src/outbook3.xml"));
		 StreamResult reslut=new StreamResult(outstream);
		 transformer.transform(source, reslut);
		 outstream.close();	
		 
	}

}
