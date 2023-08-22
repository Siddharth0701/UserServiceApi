package com.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {
	
	private Long id;
	@NotEmpty(message = "User first name should not be null or empty")
	private String first_Name;
	@NotEmpty(message = "User last name should not be null or empty")
	private String last_Name;
	@NotEmpty(message = "User address should not be null or empty")
	private String address;
	private int age;
	@NotEmpty(message = "User email should not be null or empty")
	@Email(message = "Email address should be valid")
	private String email;
	
	
	public UserDto(Long id, String first_Name, String last_Name, String address, int age,String email) {
		super();
		this.id = id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.address = address;
		this.age = age;
		this.email=email;
	}


	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirst_Name() {
		return first_Name;
	}


	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}


	public String getLast_Name() {
		return last_Name;
	}


	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
