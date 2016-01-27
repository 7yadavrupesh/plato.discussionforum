/**********************************************************************************
* File-name - UmUserDetailsServiceImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: User management Services implementation
**********************************************************************************/ 

package main.java.com.srmri.plato.core.usermanagement.serviceImpl;



import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.srmri.plato.core.usermanagement.dao.UmUserDetailsDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;
import main.java.com.srmri.plato.core.usermanagement.service.UmUserDetailsService;


@Service("UmUserDetailsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UmUserDetailsServiceImpl implements UmUserDetailsService
{
	
	@Autowired
	private UmUserDetailsDao userDao;
	
	
	/**
	 * Generates a random key of given length 
	 * used as a password for registering a student
	 * @param length - length of the key
	 * @return String - generated key
	 */
	public String randomPasswordGenerator(int length) 
	{


		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(length);
		
		for( int i = 0; i < length; i++ ) 
			sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * To generate hash of the password from the password entered to register
	 * @param String password - password entered by the user.
	 * @return String hash of the password
	 */
	public String generateHashedPassword(String password)
	{
		
	  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();  
	  String hashedPassword = passwordEncoder.encode(password);   
	  return hashedPassword;  
			 
	}
	
	
	/**
	 * Add the user object to the database via dao.
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	private boolean blAddUserDetails(UmUserDetails user) throws ConstraintViolationException
	{
		System.out.println("service call 2 "+user.getUserName()+" "+user.getPassword());
		try	
		{
			userDao.dAddUserDetails(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	/**
	 * Checks if the user is authenticated to login or not.
	 * @param userId - userid for the user to be authenticated
	 * @param password - password entered by the user to login
	 * @return true/false based on successful authentication
	 */
	@Override
	public boolean blAuthenticateUser(String userName, String password) 
	{
		try
		{
			UmUserDetails user = userDao.dGetUserByName(userName);
		
			String storedPassword = user.getPassword();
		
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			if (passwordEncoder.matches(password, storedPassword))
					return true;
			else 
					return false;
		}
		catch(Exception e)
		{
			if( e instanceof NullPointerException)
				System.out.println("user doesn't exist");
			
			return false;
		}
	}
	
		

	/**
	 * Add user details to a user object.
	 * @param HashMap - details of the user with key as String
	 * @throws IOException
	 */
	@Override
	public boolean blAddUser(UmUserDetails user) throws IOException
	{
		System.out.println("service call "+user.getUserName()+" "+user.getPassword());
				
		if(this.blAddUserDetails(user))
			return true;
		else
			return false;
	}

	
	/**
	 * returns list of all the users in the table
	 * @return List of UmUserDetails object.
	 */
	@Override
	public List<UmUserDetails> blListUsers() 
	{
	
		return userDao.dGetListOfAllUsers();
		
	}
	
	/**
	 * Fetches a particular user via useId
	 * @param long userId - user id of the user to fetch
	 * @return UmUserDetails object with details of the user.
	 */
	@Override
	public UmUserDetails blGetUser(long userId) 
	{
	
		return userDao.dGetUserDetails(userId);
	}
	
	/**
	 * Deletes a user
	 * @param UmUserDetails object
	 */
	@Override
	public void blDeleteUser(UmUserDetails user) 
	{
	
		userDao.dDeleteUserDetails(user);
		
	}
	
	/**
	 * fetches a particular user via username
	 * @param String username
	 * @return UmUserDetails object
	 */
	@Override
	public UmUserDetails blGetUser(String username) 
	{
		
		return userDao.dGetUserByName(username);
	}

	/**
	 * fetches a particular user via emailid
	 * @param String emailid
	 * @return UmUserDetails object
	 */
	@Override
	public UmUserDetails blGetUserByEmail(String email) 
	{
		
		return userDao.dGetUserByEmail(email);
	}
	
	/**
	 * checks if a email exists in the userdetails table or not
	 * @param String email
	 * @return boolean true/false
	 */
	@Override
	public boolean blEmailExists(String email) 
	{
		UmUserDetails user;
	   try
	   {
			 user =userDao.dGetUserByEmail(email);
			
			
	   }
	   catch(Exception e)
	   {
		   return false;   
	   }
	   
	   if(user==null)
		   return false;
	   
	   return true;
		
		
	}

	
	

}
