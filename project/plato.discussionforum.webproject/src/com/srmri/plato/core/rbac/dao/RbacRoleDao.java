/**********************************************************************************
* File-name - RbacRoleDao.java
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
 * Description: The Dao interface for the rbac_role table
*
**********************************************************************************/
 
package com.srmri.plato.core.rbac.dao;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacRole;

public interface RbacRoleDao {
	
	/**
	 * Method declaration
	 * Used to insert/update a role 
	 */
	public void rbacDInsertRole(RbacRole role);

	/**
	 * Method declaration
	 * Used to fetch the list of roles
	 */
	public List<RbacRole> rbacDListRole();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a specific role 
	 */
	public RbacRole rbacDGetRole(int roleId);
	
	/**
	 * Method declaration
	 * Used to delete the details of a specific role 
	 */
	public void rbacDDeleteRole(RbacRole role);

}
