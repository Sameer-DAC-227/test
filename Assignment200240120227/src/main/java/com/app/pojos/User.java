package com.app.pojos;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50)
	private String name;
	
	@Column(length = 50, unique = true, nullable = false )
	private String email;

	public User() {
		System.out.println("In default constructor : " + getClass().getName());
	}

	public User(String name, String email) {
		System.out.println("In parameterized constructor : " + getClass().getName());
		this.name = name;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
