/**********************************************************************************
* File-name - RbacRoleLevelServiceImpl.java
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
 * Description: The service interface implementation for the rbac_role_level table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.rbac.dao.RbacRoleLevelDao;
import com.srmri.plato.core.rbac.entity.RbacRoleLevel;
import com.srmri.plato.core.rbac.service.RbacRoleLevelService;

@Service("roleLevelService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RbacRoleLevelServiceImpl implements RbacRoleLevelService{

	@Autowired
	private RbacRoleLevelDao roleLevelDao;
	
	/**
	 * Method declaration
	 * Used to add/update a role level
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)	
	@Override	
	public void rbacBsAddRoleLevel(RbacRoleLevel roleLevel) {		
		roleLevelDao.rbacDInsertRoleLevel(roleLevel);
	}

	/**
	 * Method declaration
	 * Used to list all the role levels
	 */
	@Override
	public List<RbacRoleLevel> rbacBsListRoleLevels() {
		return roleLevelDao.rbacDListRoleLevel();		
	}

	/**
	 * Method declaration
	 * Used to retrieve the details of a particular role level
	 */
	@Override
	public RbacRoleLevel rbacBsGetRoleLevel(int roleLevelId) {		
		return roleLevelDao.rbacDGetRoleLevel(roleLevelId);
	}

	/**
	 * Method declaration
	 * Used to delete a role level
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsDeleteRoleLevel(RbacRoleLevel roleLevel) {
		roleLevelDao.rbacDDeleteRoleLevel(roleLevel);
		
	}

}
