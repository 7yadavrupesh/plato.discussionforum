/**********************************************************************************
* File-name - RbacRoleLevelService.java
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
 * Description: The service interface for the rbac_role_level table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.service;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacRoleLevel;

public interface RbacRoleLevelService {
	
	/**
	 * Method declaration
	 * Used to add/update a role level
	 */
	public void rbacBsAddRoleLevel(RbacRoleLevel roleLevel);

	/**
	 * Method declaration
	 * Used to list all the role level
	 */
	public List<RbacRoleLevel> rbacBsListRoleLevels();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a particular role level
	 */
	public RbacRoleLevel rbacBsGetRoleLevel(int roleLevelId);
	
	/**
	 * Method declaration
	 * Used to delete a role level
	 */
	public void rbacBsDeleteRoleLevel(RbacRoleLevel roleLevel);
}
