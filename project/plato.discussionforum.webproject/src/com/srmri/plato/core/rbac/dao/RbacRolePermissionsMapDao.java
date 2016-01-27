/**********************************************************************************
* File-name - RbacRolePermissionsMapDao.java
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
 * Description: The Dao interface for the rbac_role_permissions_map table
*
**********************************************************************************/
package com.srmri.plato.core.rbac.dao;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacRolePermissionsMap;

public interface RbacRolePermissionsMapDao {
	
	/**
	 * Method declaration
	 * Used to insert/update a role permission map
	 */
	public void rbacDInsertRolePermissionsMap(RbacRolePermissionsMap rolePermissionsMap);

	/**
	 * Method declaration
	 * Used to fetch the list of role permission mappings
	 */
	public List<RbacRolePermissionsMap> rbacDListRolePermissionsMap();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a specific role permission map
	 */
	public RbacRolePermissionsMap rbacDGetRolePermissionsMap(long rolePermissionsMapId);
	
	/**
	 * Method declaration
	 * Used to delete the details of a specific role permission map
	 */
	public void rbacDDeleteRolePermissionsMap(RbacRolePermissionsMap rolePermissionsMap);
	
	/**
	 * Method declaration
	 * Used to retrieve the list of permissions associated with a role
	 */
	public List<RbacRolePermissionsMap> rbacDGetRolePermissions(int roleId);
	
	/**
	 * Method declaration
	 * Used to check if a permission is associated with a specific role (if a role has a permission)
	 */
	public boolean rbacDIsRolePermissionExists(int roleId, long permissionId);

}
