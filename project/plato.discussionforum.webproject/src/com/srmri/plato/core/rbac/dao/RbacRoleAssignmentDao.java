/**********************************************************************************
* File-name - RbacRoleAssignmentDao.java
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
 * Description: The Dao interface for the rbac_role_assignment table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.dao;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacRoleAssignment;

public interface RbacRoleAssignmentDao {
	
	/**
	 * Method declaration
	 * Used to insert/update a role for a user
	 */
	public void rbacDInsertRoleAssignment(RbacRoleAssignment roleAssignment);

	/**
	 * Method declaration
	 * Used to fetch the list of role assignments
	 */
	public List<RbacRoleAssignment> rbacDListRoleAssignment();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a specific role assignment
	 */
	public RbacRoleAssignment rbacDGetRoleAssignment(int roleAssignmentId);
	
	/**
	 * Method declaration
	 * Used to delete the details of a specific role assignment
	 */
	public void rbacDDeleteRoleAssignment(RbacRoleAssignment roleAssignment);
	
	/**
	 * Method declaration
	 * Used to retrieve the role ids of a particular user
	 */
	public List<RbacRoleAssignment> rbacDGetUserRoleIds(long userId);
	

}

