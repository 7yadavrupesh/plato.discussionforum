/**********************************************************************************
* File-name - RbacRoleService.java
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
 * Description: The service interface for the rbac_role table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.service;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacRole;

public interface RbacRoleService {
	
	/**
	 * Method declaration
	 * Used to add/update a role
	 */
	public void rbacBsAddRole(RbacRole role);

	/**
	 * Method declaration
	 * Used to list all the roles
	 */
	public List<RbacRole> rbacBsListRoles();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a particular role
	 */
	public RbacRole rbacBsGetRole(int roleId);
	
	/**
	 * Method declaration
	 * Used to delete a role
	 */
	public void rbacBsDeleteRole(RbacRole role);

}
