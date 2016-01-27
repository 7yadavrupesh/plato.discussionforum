/**********************************************************************************
* File-name - EmailBean.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Email validation bean
**********************************************************************************/


package main.java.com.srmri.plato.core.login.bean;

import java.io.Serializable;

import javax.validation.constraints.Pattern;


public class EmailBean implements Serializable
{
	
	private static final long serialVersionUID = 9022862653606630418L;
	
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
	  		   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Not a valid email")
	private String email;
	
	/**
	 * Default constructor
	 */
	public EmailBean()
	{}
	
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


}
