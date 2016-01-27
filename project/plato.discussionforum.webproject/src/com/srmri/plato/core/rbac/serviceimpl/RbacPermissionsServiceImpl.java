/**********************************************************************************
* File-name - RbacPermissionsServiceImpl.java
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
 * Description: The service interface implementation for the rbac_permissions table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.rbac.dao.RbacModulesDao;
import com.srmri.plato.core.rbac.dao.RbacPermissionsDao;
import com.srmri.plato.core.rbac.entity.RbacModules;
import com.srmri.plato.core.rbac.entity.RbacPermissions;
import com.srmri.plato.core.rbac.service.RbacPermissionsService;

@Service("permissionsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RbacPermissionsServiceImpl implements RbacPermissionsService{
	
	@Autowired
	private RbacPermissionsDao permissionsDao;
	
	@Autowired
	private RbacModulesDao modulesDao;

	/**
	 * Method definition
	 * Used to add/update a permission
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsAddPermission(RbacPermissions permission) {
		permissionsDao.rbacDInsertPermission(permission);		
	}

	/**
	 * Method definition
	 * Used to list all the permissions
	 */
	@Override
	public List<RbacPermissions> rbacBsListPermissions() {		
		return permissionsDao.rbacDListPermissions();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a particular permission
	 */
	@Override
	public RbacPermissions rbacBsGetPermission(int permissionId) {		
		return permissionsDao.rbacDGetPermission(permissionId);
	}

	/**
	 * Method definition
	 * Used to delete a permission
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsDeletePermission(RbacPermissions permission) {
		permissionsDao.rbacDDeletePermission(permission);
	}
	
	/**
	 * Method definition
	 * Used to retrieve the permissions of a module 
	 */
	public List<RbacPermissions> rbacBsGetModulePermissions(int moduleId){
		return permissionsDao.rbacDGetModulePermissions(moduleId);
	}

	/**
	 * Method definition
	 * Used to retrieve all the permissions for all modules 
	 */
	@Override
	public Map<String, List<RbacPermissions>> rbacBsGetAllModulesPermissions() {
		Map<String,List<RbacPermissions>> modulesPermissions = new HashMap<String,List<RbacPermissions>>();
		List<RbacModules> modules = modulesDao.rbacDListModules();
		for (int i = 0; i < modules.size(); i++) {
			List<RbacPermissions> permissionList = permissionsDao.rbacDGetModulePermissions(modules.get(i).getModuleId());
			if(permissionList != null){
				modulesPermissions.put(modules.get(i).getModuleName(), permissionList);
			}
		}
		return modulesPermissions;
	}

	/**
	 * Method definition
	 * Used to retrieve the permission id for a given permission code
	 */
	@Override
	public long rbacBsGetPermissionId(String permissionCode) {
		long permissionId = permissionsDao.rbacDGetPermissionId(permissionCode);
		return permissionId;
	}

}
