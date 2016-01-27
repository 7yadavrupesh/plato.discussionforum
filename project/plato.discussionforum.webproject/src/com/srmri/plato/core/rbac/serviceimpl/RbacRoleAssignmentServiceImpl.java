/**********************************************************************************
* File-name - RbacRoleAssignmentServiceImpl.java
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
 * Description: The service interface implementation for the rbac_role_assignment table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.rbac.dao.RbacRoleAssignmentDao;
import com.srmri.plato.core.rbac.entity.RbacRoleAssignment;
import com.srmri.plato.core.rbac.service.RbacRoleAssignmentService;

@Service("roleAssignmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RbacRoleAssignmentServiceImpl implements RbacRoleAssignmentService{
	
	@Autowired
	private RbacRoleAssignmentDao roleAssignmentDao;
	
	/**
	 * Method definition
	 * Used to add/update a role assignment
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsAddRoleAssignment(RbacRoleAssignment roleAssignment) {
		roleAssignmentDao.rbacDInsertRoleAssignment(roleAssignment);		
	}

	/**
	 * Method definition
	 * Used to list all the role assignments
	 */
	@Override
	public List<RbacRoleAssignment> rbacBsListRoleAssignments() {		
		return roleAssignmentDao.rbacDListRoleAssignment();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a particular role assignment
	 */
	@Override
	public RbacRoleAssignment rbacBsGetRoleAssignment(int roleAssignmentId) {		
		return roleAssignmentDao.rbacDGetRoleAssignment(roleAssignmentId);
	}

	/**
	 * Method definition
	 * Used to delete a role assignment
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsDeleteRoleAssignment(RbacRoleAssignment roleAssignment) {	
		roleAssignmentDao.rbacDDeleteRoleAssignment(roleAssignment);
	}

	/**
	 * Method declaration
	 * Used to retrieve the role ids of a particular user
	 */
	@Override
	public List<RbacRoleAssignment> rbacBsGetUserRoleIds(long userId) {		
		return roleAssignmentDao.rbacDGetUserRoleIds(userId);
	}

}
