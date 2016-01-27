/**********************************************************************************
* File-name - ResetBean.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Password rest form and validation bean
**********************************************************************************/


package main.java.com.srmri.plato.core.login.bean;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class ResetBean implements Serializable
{
	
	private static final long serialVersionUID = 7574740387847196464L;


	@Size(min=1, max=255, message="Cannot be null")
	private String userName;
		
	
	@Size(min=8, max=255, message="Password should be atleast 8 characters long")
	private String password;

	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
