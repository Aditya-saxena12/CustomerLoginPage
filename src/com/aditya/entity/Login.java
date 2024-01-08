package com.aditya.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Login 
{
	@Id
	@NotNull(message="is reuired")
	@Size(min=1,message="is required")
	@Column(name="username")
	private String userName;
	
	@NotNull(message="is reuired")
	@Size(min=1,message="is required")
	@Column(name="password")
	private String userPass;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	
}
