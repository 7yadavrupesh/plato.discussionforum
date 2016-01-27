/**********************************************************************************
* File-name - RbacRolePermissionsMapService.java
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
 * Description: The service interface for the rbac_role_permissions_map table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.service;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacRolePermissionsMap;

public interface RbacRolePermissionsMapService {

	/**
	 * Method declaration
	 * Used to add/update a role permission mapping
	 */
	public void rbacBsAddRolePermissionMap(RbacRolePermissionsMap rolePermissionsMap);

	/**
	 * Method declaration
	 * Used to list all the role permission mappings
	 */
	public List<RbacRolePermissionsMap> rbacBsListRolePermissionsMap();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a particular role permission map
	 */
	public RbacRolePermissionsMap rbacBsGetRolePermissionsMap(int rolePermissionId);
	
	/**
	 * Method declaration
	 * Used to delete a role permission map
	 */
	public void rbacBsDeleteRolePermissionMap(RbacRolePermissionsMap rolePermissionMap);
	
	/**
	 * Method declaration
	 * Used to retrieve the list of permissions belonging to a role
	 */
	public List<RbacRolePermissionsMap> rbacBsGetRolePermissions(int roleId);
	
	/**
	 * Method declaration
	 * Used to check if a permission belongs to a role
	 */
	public boolean rbacBsIsRolePermissionExists(String permissionCode, int roleId);

	
}
