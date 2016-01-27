/**********************************************************************************
* File-name - RbacModulesDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
 *
 * Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
 * written authorization of SRM Research Institute and its licensors, if any.
*
***********************************************************************************
*
 * Description: The Dao interface for the rbac_modules table
*
**********************************************************************************/
package com.srmri.plato.core.rbac.dao;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacModules;


public interface RbacModulesDao {
	
	/**
	 * Method declaration
	 * Used to insert/update a module
	 */
	public void rbacDInsertModule(RbacModules module);
	

	/**
	 * Method declaration
	 * Used to fetch the list of modules
	 */
	public List<RbacModules> rbacDListModules();
	

	/**
	 * Method declaration
	 * Used to retrieve the details of a specific module
	 */
	public RbacModules rbacDGetModule(int moduleId);
	
	/**
	 * Method declaration
	 * Used to delete the details of a specific module
	 */
	public void rbacDDeleteModule(RbacModules module);

}
