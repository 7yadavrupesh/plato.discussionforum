/**********************************************************************************
* File-name - RbacRoleLevelDao.java
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
 * Description: The Dao interface for the rbac_role_level table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.dao;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacRoleLevel;

public interface RbacRoleLevelDao {
	
	/**
	 * Method declaration
	 * Used to insert/update a role level
	 */
	public void rbacDInsertRoleLevel(RbacRoleLevel roleLevel);

	/**
	 * Method declaration
	 * Used to fetch the list of role levels
	 */
	public List<RbacRoleLevel> rbacDListRoleLevel();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a specific role level
	 */
	public RbacRoleLevel rbacDGetRoleLevel(int roleLevelId);
	
	/**
	 * Method declaration
	 * Used to delete the details of a specific role level
	 */
	public void rbacDDeleteRoleLevel(RbacRoleLevel roleLevel);

}
