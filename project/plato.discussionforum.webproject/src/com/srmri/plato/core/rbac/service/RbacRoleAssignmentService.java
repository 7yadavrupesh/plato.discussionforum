/**********************************************************************************
* File-name - RbacRoleAssignmentService.java
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
 * Description: The service interface for the rbac_role_assignment table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.service;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacRoleAssignment;

public interface RbacRoleAssignmentService{
	
	/**
	 * Method declaration
	 * Used to add/update a role assignment
	 */
	public void rbacBsAddRoleAssignment(RbacRoleAssignment roleAssignment);

	/**
	 * Method declaration
	 * Used to list all the role assignments
	 */
	public List<RbacRoleAssignment> rbacBsListRoleAssignments();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a particular role assignment
	 */
	public RbacRoleAssignment rbacBsGetRoleAssignment(int roleAssignmentId);
	
	/**
	 * Method declaration
	 * Used to delete a role assignment
	 */
	public void rbacBsDeleteRoleAssignment(RbacRoleAssignment roleAssignment);
	
	/**
	 * Method declaration
	 * Used to retrieve the role ids of a particular user
	 */
	public List<RbacRoleAssignment> rbacBsGetUserRoleIds(long userId);

}
