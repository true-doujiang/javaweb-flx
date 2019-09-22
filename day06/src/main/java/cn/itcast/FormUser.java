package cn.itcast;

import lombok.Data;


@Data
public class FormUser {
	
	private int id;
	private String username;
	private String password;
	private String gender;
	private String city;
	private String[] likes;
	private String description;
	

}
