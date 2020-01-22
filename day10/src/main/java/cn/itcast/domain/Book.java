package cn.itcast.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String id;
	private String name;
	private String author;
	private double price;
	private String description;
	

}
