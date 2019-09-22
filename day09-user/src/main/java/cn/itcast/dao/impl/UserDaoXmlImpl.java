package cn.itcast.dao.impl;

import java.text.SimpleDateFormat;

import cn.itcast.dao.UserDao;
import org.dom4j.Document;
import org.dom4j.Element;

import cn.itcast.domain.User;
import cn.itcast.utils.XmlUtils;

//根据业务需求来
public class UserDaoXmlImpl implements UserDao {
	
	//添加一个用户
	public void add(User user){
		try{
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
		
			Element user_tag = root.addElement("user");  //创建user结点，并挂到root
			user_tag.setAttributeValue("id", user.getId());
			user_tag.setAttributeValue("username", user.getUsername());
			user_tag.setAttributeValue("password", user.getPassword());
			user_tag.setAttributeValue("email", user.getEmail());
			user_tag.setAttributeValue("birthday", user.getBirthday()==null?"":user.getBirthday().toLocaleString());
		
			XmlUtils.write2Xml(document);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//登录时查找指定用户
	public User find(String username,String password){
		try{
			Document document = XmlUtils.getDocument();  //Xpath技术
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
			if(e==null){
				return null;
			}
			
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setUsername(e.attributeValue("username"));
			user.setPassword(e.attributeValue("password"));
			user.setEmail(e.attributeValue("email"));
			String birth = e.attributeValue("birthday"); // "" 或者 1990-02-01
			if(birth==null||birth.equals("")){
				user.setBirthday(null);
			}else{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				user.setBirthday(sdf.parse(birth));
			}
			return user;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	

	//注册的时候查看有没有重名
	public User find(String username){
		try{
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username='"+username+"']");
			if(e==null){
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setEmail(e.attributeValue("email"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("username"));
			String birth = e.attributeValue("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sdf.parse(birth));
			return user;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
