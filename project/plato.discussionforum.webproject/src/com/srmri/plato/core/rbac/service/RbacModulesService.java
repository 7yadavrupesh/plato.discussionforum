/**********************************************************************************
* File-name - RbacModulesService.java
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
 * Description: The service interface for the rbac_modules table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.service;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacModules;

public interface RbacModulesService {
	
	/**
	 * Method declaration
	 * Used to add/update a module
	 */
	public void rbacBsAddModule(RbacModules module);

	/**
	 * Method declaration
	 * Used to list all the modules
	 */
	public List<RbacModules> rbacBsListModules();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a particular module
	 */
	public RbacModules rbacBsGetModule(int moduleId);
	
	/**
	 * Method declaration
	 * Used to delete a module
	 */
	public void rbacBsDeleteModule(RbacModules module);

}
