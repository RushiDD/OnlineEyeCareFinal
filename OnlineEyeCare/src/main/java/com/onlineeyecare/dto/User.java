package com.onlineeyecare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "User_Table1")
public class User {
	
	@Id
	@NotBlank(message = "UserName must be filled")
	private String userName;
	
	@NotBlank(message = "Password must be filled")
	@Pattern(regexp = "[A-Za-z0-9@#$%^&]{8,20}+$", message = "Password Must be between 8 to 20 characters")
	private String password;
	
	@NotBlank(message = "Role must be filled")
	private String role;
		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public User() {
		super();
	}
	
	public User(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}	
}