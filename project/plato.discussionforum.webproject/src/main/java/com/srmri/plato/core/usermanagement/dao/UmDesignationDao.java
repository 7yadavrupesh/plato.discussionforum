/**********************************************************************************
* File-name - UmDesignationDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Desigantion DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.dao;


import java.util.List;

import main.java.com.srmri.plato.core.usermanagement.model.UmDesignation;


public interface UmDesignationDao 
{
	
	void dAddDesignation(UmDesignation designation);
	
	UmDesignation dGetDesignation(long designationId);

	List<UmDesignation> dGetListOfAllDesignation();
	
	void dDeleteDesignation(UmDesignation designation);

	long dGetDesignationId(String designation);
	
	

}
