package com.onlineeyecare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	
	@Id
	@NotBlank(message = "Admin Id must be filled")
	private int adminId;
	@NotBlank(message = "Admin Username must be filled")
	private String adminUsername;
	@NotBlank(message = "Password must be filled")
	@Size(min = 8, max = 12)
	private String adminPassword;
	
	public Admin() {
		super();
	}

	public Admin(int adminId, String adminUsername, String adminPassword) {
		super();
		this.adminId = adminId;
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}