/**********************************************************************************
* File-name - UmUserDetails.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: UserDetails model
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.model;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

import java.sql.Timestamp;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Table(name="usermanagement.um_user_details")
public class UmUserDetails implements Serializable
{
	private static final long serialVersionUID = 8740618022691146387L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;
	

	@Column(name="user_name", unique=true)
	private String userName;
	
	
	@Column(name="password")
	private String password;
	
	@Column(name="email_id", unique=true)
	private String emailId;
	
	@Column(name="picture")
	private String picture;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	
	@Column(name="valid")
	private Integer valid;
	
	@Column(name="logged_in")
	private Integer loggedIn;
	
	@Column(name="last_login")
	private Timestamp lastLogin;
	
	@Column(name="gender")
	private String gender;
	
	

	
	
	
	/**
	 * Default Constructor
	 */
	public UmUserDetails()
	{
		this.password = "$";
		
		this.createdAt = new Timestamp(System.currentTimeMillis());
		this.updatedAt = new Timestamp(System.currentTimeMillis());
		this.lastLogin = new Timestamp(System.currentTimeMillis());
		this.loggedIn = 0;
		this.valid = 1;
		
	}
	
	
	
	/**
	 * Parameterized constructor
	 * For student account creation
	 * @param String username - user name of the user
	 * @param String emailId -  email id of the user
	 * @param String gender - gender of the user
	 */
	public UmUserDetails(String userName,String emailId,String gender)
	{
		this.userName = userName;
		this.emailId = emailId;
		this.gender = gender;
		this.password = "$";
		this.createdAt = new Timestamp(System.currentTimeMillis());
		this.updatedAt = new Timestamp(System.currentTimeMillis());
		this.lastLogin = new Timestamp(System.currentTimeMillis());
		this.loggedIn = 0;
		this.valid = 1;
		
	
	}
	
	/**
	 * Getter method for userID
	 * @return userId of this user object
	 */
	public long getUserId() {
		return userId;
	}
	
	
	/**
	 * Setter method for user id of this user
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	/**
	 * Getter method for userName
	 * @return userName of this user object
	 */
	public String getUserName() {
		return userName;
	}
	
	
	/**
	 * Setter method for user name for this user
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Getter method for password
	 * @return password of this user object
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Setter method for user entered password for this user
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * Setter method for setting a random system 
	 * generated password for this user 
	 */
	public void setRandomPassword(int length) {
		//this.password = this.randomPasswordGenerator(length);
	}
	
	
	/**
	 * Getter method for emailId
	 * @return emailId of this user object
	 */
	public String getEmailId() {
		return emailId;
	}
	
	
	/**
	 * Setter method for email id of this user
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * Getter method for use image
	 * @return image of this user object
	 */
	public String getImage() 
	{
		return this.picture;
	}
	
	
	/**
	 * Setter method for image of this user
	 */
	public void setImage(String imagePath) throws IOException 
	{
		this.picture = imagePath;
		/*if(!isLarge(imagePath) && !this.isMalware(imagePath))
			this.picture = this.getImageBytes(imagePath);
		else if(isLarge(imagePath))
			System.out.println("file size exceeds");
		else
			System.out.println("file is a possible malware");*/
		
	}
	
	/**
	 * Getter method for created timestamp
	 * @return created timestamp of this user object
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * Setter method for created at timestamp for this user
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	
	/**
	 * Getter method for updated timestamp
	 * @return updated timestamp of this user object
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * Setter method for updated at timestamp for this user
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	/**
	 * Getter method for validity
	 * @return valid field value of this user object
	 */
	public Integer getValid() {
		return valid;
	}
	
	
	/**
	 * Setter method for validity of this user
	 */
	public void setValid(Integer valid) {
		this.valid = valid;
	}
	
	/**
	 * Getter method for loggedin value
	 * @return logged in of this user object
	 */
	public Integer getLoggedIn() {
		return loggedIn;
	}
	
	
	/**
	 * Setter method for logged in value
	 */
	public void setLoggedIn(Integer loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	/**
	 * Getter method for last login timestamp
	 * @return last login timestamp of this user object
	 */
	public Timestamp getLastLogin() {
		return lastLogin;
	}

	/**
	 * Setter method for last login timestamp
	 */
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	/**
	 * Getter method for gender
	 * @return gender of this user object
	 */
	public String getGender() {
		return gender;
	}
	
	
	/**
	 * Setter method for gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


}
