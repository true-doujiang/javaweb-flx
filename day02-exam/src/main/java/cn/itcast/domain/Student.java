/**
 * 
 */
package cn.itcast.domain;

/**作者: 尤欢欢
 * 日期： 2017年10月29日 下午4:48:38
 * 描述： 
 */
public class Student {

	/*
	 * <student idcard="111" examid="222">
			<name>张三</name>
			<location>沈阳</location>
			<grade>89</grade>
		</student>
	 */
	
	private String idcard;
	private String examid;
	private String name;
	private String location;
	private double grade;
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getExamid() {
		return examid;
	}
	public void setExamid(String examid) {
		this.examid = examid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Student [idcard=" + idcard + ", examid=" + examid + ", name="
				+ name + ", location=" + location + ", grade=" + grade + "]";
	}
	
	
}
