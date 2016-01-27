/**********************************************************************************
* File-name -RbacPermissionsService.java
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
 * Description: The service interface for the rbac_permissions table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.service;

import java.util.List;
import java.util.Map;

import com.srmri.plato.core.rbac.entity.RbacPermissions;

public interface RbacPermissionsService {
	/**
	 * Method declaration
	 * Used to add/update a permission
	 */
	public void rbacBsAddPermission(RbacPermissions permission);

	/**
	 * Method declaration
	 * Used to list all the permissions
	 */
	public List<RbacPermissions> rbacBsListPermissions();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a particular permission
	 */
	public RbacPermissions rbacBsGetPermission(int permissionId);
	
	/**
	 * Method declaration
	 * Used to delete a permission
	 */
	public void rbacBsDeletePermission(RbacPermissions permission);
	
	/**
	 * Method declaration
	 * Used to retrieve the permissions of a module 
	 */
	public List<RbacPermissions> rbacBsGetModulePermissions(int moduleId);
	
	/**
	 * Method declaration
	 * Used to retrieve all the permissions for all modules
	 */
	public Map<String,List<RbacPermissions>> rbacBsGetAllModulesPermissions();
	
	/**
	 * Method declaration
	 * Used to retrieve the permission id for a given permission code
	 */
	public long rbacBsGetPermissionId(String permissionCode);
}
