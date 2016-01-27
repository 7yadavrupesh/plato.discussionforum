/**********************************************************************************
* File-name - RbacRolePermissionsMapServiceImpl.java
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
 * Description: The service interface implementation for the rbac_role_permissions_map table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.rbac.dao.RbacPermissionsDao;
import com.srmri.plato.core.rbac.dao.RbacRolePermissionsMapDao;
import com.srmri.plato.core.rbac.entity.RbacRolePermissionsMap;
import com.srmri.plato.core.rbac.service.RbacRolePermissionsMapService;

@Service("rolePermissionsMapService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RbacRolePermissionsMapServiceImpl implements RbacRolePermissionsMapService{

	@Autowired
	private RbacRolePermissionsMapDao rolePermissionsMapDao;
	
	@Autowired
	private RbacPermissionsDao permissionsDao;
	
	/**
	 * Method definition
	 * Used to add/update a role permission mapping
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsAddRolePermissionMap(RbacRolePermissionsMap rolePermissionsMap) {
		rolePermissionsMapDao.rbacDInsertRolePermissionsMap(rolePermissionsMap);		
	}

	/**
	 * Method definition
	 * Used to list all the role permission mappings
	 */
	@Override
	public List<RbacRolePermissionsMap> rbacBsListRolePermissionsMap() {		
		return rolePermissionsMapDao.rbacDListRolePermissionsMap();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a particular role permission map
	 */
	@Override
	public RbacRolePermissionsMap rbacBsGetRolePermissionsMap(int rolePermissionsMapId) {		
		return rolePermissionsMapDao.rbacDGetRolePermissionsMap(rolePermissionsMapId);
	}

	/**
	 * Method definition
	 * Used to delete a role permission map
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsDeleteRolePermissionMap(RbacRolePermissionsMap rolePermissionsMap) {
		rolePermissionsMapDao.rbacDDeleteRolePermissionsMap(rolePermissionsMap);	
	}

	/**
	 * Method definition
	 * Used to retrieve the list of permissions belonging to a role
	 */	
	@Override
	public List<RbacRolePermissionsMap> rbacBsGetRolePermissions(int roleId) {		
		return rolePermissionsMapDao.rbacDGetRolePermissions(roleId);
	}

	/**
	 * Method definition
	 * Used to check if a permission belongs to a role
	 */
	@Override
	public boolean rbacBsIsRolePermissionExists(String permissionCode, int roleId) {
		long permissionId = permissionsDao.rbacDGetPermissionId(permissionCode);
		boolean value = rolePermissionsMapDao.rbacDIsRolePermissionExists(roleId, permissionId);
		return value;
	}

}
