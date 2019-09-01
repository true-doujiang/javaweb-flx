package cn.itcast.dao;

import java.rmi.StubNotFoundException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.itcast.domain.Student;
import cn.itcast.utils.XmlUtils;

/**
 * 作者: 尤欢欢
 * 日期： 2017年10月29日 下午5:04:09
 * 描述：
 */
public class StudentDao {

	/*
	 <student idcard="111" examid="222">
		<name>张三</name>
		<location>沈阳</location>
		<grade>89</grade>
	</student>

	 */
	public void add(Student student){
		try {
			Document document = XmlUtils.getDocument();
			Element student_node = document.createElement("student");
			student_node.setAttribute("examid", student.getExamid());;
			student_node.setAttribute("idcard", student.getIdcard());;
			//创建用于封装学生姓名、地址、成绩的标签
			Element name = document.createElement("name");
			Element location = document.createElement("location");
			Element grade = document.createElement("grade");
			name.setTextContent(student.getName());
			location.setTextContent(student.getLocation());
			grade.setTextContent(student.getGrade()+"");
			
			student_node.appendChild(name);
			student_node.appendChild(location);
			student_node.appendChild(grade);
			
			//得到exam结点，并把student挂上去
			document.getElementsByTagName("exam").item(0).appendChild(student_node);
			XmlUtils.write2Xml(document);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(String name) throws StubNotFoundException{
		try {
			Document document = XmlUtils.getDocument();
			NodeList list = document.getElementsByTagName("name");
			for (int i = 0; i < list.getLength(); i++) {
				Node item = list.item(i);
				if(item.getTextContent().equals(name)){
					item.getParentNode().getParentNode().removeChild(item.getParentNode());
					XmlUtils.write2Xml(document);
					return;
				}
			}
			throw new StubNotFoundException(name + "不存在"); 
		} catch (StubNotFoundException e) {
			throw e;
		}catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public Student find(String examid){
		try {
			Document document = XmlUtils.getDocument();
			NodeList list = document.getElementsByTagName("student");
			for (int i = 0; i < list.getLength(); i++) {
				Element student_node = (Element) list.item(i);
				if(student_node.getAttribute("examid").equals(examid)){
					Student s = new Student();
					s.setExamid(examid);
					s.setIdcard(student_node.getAttribute("idcard"));
					
					Node item = student_node.getElementsByTagName("name").item(0);
					String name = item.getTextContent();
					
					Node item2 = student_node.getElementsByTagName("location").item(0);
					String location = item2.getTextContent();
					
					Node item3 = student_node.getElementsByTagName("grade").item(0);
					double grade = Double.parseDouble(item3.getTextContent());
					
					s.setName(name);
					s.setLocation(location);
					s.setGrade(grade);
					return s;
				}
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
