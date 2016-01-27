/**********************************************************************************
* File-name - RbacRoleServiceImpl.java
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
 * Description: The service interface implementation for the rbac_role table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.rbac.dao.RbacRoleDao;
import com.srmri.plato.core.rbac.entity.RbacRole;
import com.srmri.plato.core.rbac.service.RbacRoleService;

@Service("roleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RbacRoleServiceImpl implements RbacRoleService{

	@Autowired
	private RbacRoleDao roleDao;
	
	/**
	 * Method definition
	 * Used to add/update a role
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsAddRole(RbacRole role) {
		roleDao.rbacDInsertRole(role);	
	}

	/**
	 * Method definition
	 * Used to list all the roles
	 */
	@Override
	public List<RbacRole> rbacBsListRoles() {
		return roleDao.rbacDListRole();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a particular role
	 */
	@Override
	public RbacRole rbacBsGetRole(int roleId) {		
		return roleDao.rbacDGetRole(roleId);
	}

	/**
	 * Method definition
	 * Used to delete a role
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsDeleteRole(RbacRole role) {		
		roleDao.rbacDDeleteRole(role);
	}

}
