/**********************************************************************************
* File-name - UmUserDetailsService.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: User management Services interface
**********************************************************************************/ 

package main.java.com.srmri.plato.core.usermanagement.service;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;

public interface UmUserDetailsService 
{
	 boolean blAuthenticateUser(String userName, String password);
	 
	 
	 boolean blAddUser(UmUserDetails user) throws IOException;
			
	 List<UmUserDetails> blListUsers();
		
	 UmUserDetails blGetUser(long userId);
	 
	 UmUserDetails blGetUser(String username);
	 
	 UmUserDetails blGetUserByEmail(String email);
	 
	 boolean blEmailExists(String email);
		
	 void blDeleteUser(UmUserDetails user);
	 
	 public String randomPasswordGenerator(int length);
	 
	 public String generateHashedPassword(String password);
	

}
