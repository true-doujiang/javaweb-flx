package cn.itcast;


import lombok.Data;

@Data
public class User {


	private String username;
	private String gender;
	private String likes[];
	
	

	public User() { }

	public User(String username) {
		this.username = username;
	}


	
}
