/**********************************************************************************
* File-name - UserBean.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: User form and Validation bean
**********************************************************************************/


package main.java.com.srmri.plato.core.login.bean;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class UserBean implements Serializable
{
	
	private static final long serialVersionUID = 3915828477878138862L;

	private long userId;
	
	@Size(min=1, max=255, message="Cannot be null")
	private String userName;
	
	@Size(min=8, max=255, message="Password should be atleast 8 characters long")
	private String password;
	
	private String rememberMe;
	
	private String role;
	
	private int roleId;
	
	
	public UserBean()
	{}

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

	public String getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(String rememberMe) {
		this.rememberMe = rememberMe;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the roleId
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	

}
