/**
 * 
 */
package junit.test;

import java.rmi.StubNotFoundException;

import org.junit.Test;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;
import cn.itcast.exception.StudentNotExitException;

/**作者: 尤欢欢
 * 日期： 2017年10月29日 下午5:14:53
 * 描述： 
 */
public class StudentDaoTest {

	
	@Test
	public void testAdd() {
		StudentDao dao = new StudentDao();
		Student s = new Student();
		s.setExamid("121");
		s.setGrade(88);
		s.setIdcard("121");
		s.setLocation("南京");
		s.setName("尤欢欢");
		dao.add(s);
	}
	
	
	@Test
	public void testfind(){
		StudentDao dao = new StudentDao();
		Student s = dao.find("121");
		System.out.println(s); 
	}
	
	@Test
	public void testdelete() {
		StudentDao dao = new StudentDao();
		try {
			dao.delete("安安");
		} catch (StubNotFoundException e) {
			System.out.println("该用户不存在"); 
			e.printStackTrace();
		}
	}
}
