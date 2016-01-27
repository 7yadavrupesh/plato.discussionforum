/**********************************************************************************
* File-name - UmUserDetailsDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: UserDetails DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.dao;


import java.util.List;

import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;



public interface UmUserDetailsDao 
{
	void dAddUserDetails(UmUserDetails userDetails);
	
	UmUserDetails dGetUserDetails(long userDetailsId);
	
	UmUserDetails dGetUserByName(String userName);

	List<UmUserDetails> dGetListOfAllUsers();
	
	void dDeleteUserDetails(UmUserDetails userDetails);

	UmUserDetails dGetUserByEmail(String email);


}
 