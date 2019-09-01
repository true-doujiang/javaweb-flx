package cn.itcast.dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/**
 * 作者: 尤欢欢
 * 日期： 2017年10月29日 下午6:12:07
 * 描述：
 */
public class Demo1 {

    /**
     * dom4j比较弱智，所以操作都必须先得到根节点
     * 多看看dom4j的API
     */
    //读第 2 本书的信息 <书名  name="xxxx">C++教程</书名>
    @Test
    public void read() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(Demo1.class.getClassLoader().getResource("book.xml").getPath()));
        Element root = document.getRootElement();

        Element book = (Element) root.elements("书").get(1);

        String value = book.element("书名").getText();
        String value2 = book.element("书名").attributeValue("name");
        System.out.println(value + ";" + value2);
    }

    //在第一本上添加一个新的售价  <售价>209元</售价>
    @Test
    public void add() throws Exception {        //乱码是sun的io造成的

        String path = Demo1.class.getClassLoader().getResource("book.xml").getPath();

        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(path));
        Element book = document.getRootElement().element("书");
        book.addElement("售价").setText("209元");
        //FileWriter 字符流默认是按本地码表（gb2312）写数据的
        //XMLWriter writer=new XMLWriter(new FileWriter("src/book.xml"));  //这个会乱码

        //这个不会乱码了，向XML文件里写的时候是按照UTF-8码表,但是XML里encode=“gb2312”也被改成了UTF-8,所以加个格式化输出器
        //XMLWriter writer=new XMLWriter(new OutputStreamWriter(new FileOutputStream("src/book.xml"), "UTF-8"));

        //定义一个漂亮的格式化输出器
        OutputFormat format = OutputFormat.createPrettyPrint();
        //OutputFormat format2 = OutputFormat.createCompactFormat();
        format.setEncoding("UTF-8"); //xml文件是什么编码这里就用什么编码

        XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path), "gb2312"), format);
        //字节流
        //XMLWriter writer=new XMLWriter(new FileOutputStream("src/book.xml"),format); //同上
        writer.write(document);
        writer.close();
    }


    //在第一本书指定位置上添加一个新的售价,只需要更改List集合
    @Test
    public void add2() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/book.xml"));

        Element book = document.getRootElement().element("书");
        List list = book.elements();//[书名，作者，售价]
        //创建节点
        Element price = DocumentHelper.createElement("售价");
        price.setText("309元");
        list.add(2, price);    //向list集合的指定位置添加元素

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
        writer.write(document);
        writer.close();
    }


    @Test //删除上面的节点
    public void delete() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/book.xml"));

        Element price = document.getRootElement().element("书").element("售价");
        price.getParent().remove(price);

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
        writer.write(document);
        writer.close();
    }


    @Test       //更新节点
    public void update() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("src/book.xml"));

        Element book = (Element) document.getRootElement().elements("书").get(1);
        book.element("作者").setText("Java之父");

        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream("src/book.xml"), format);
        writer.write(document);
        writer.close();
    }

}
