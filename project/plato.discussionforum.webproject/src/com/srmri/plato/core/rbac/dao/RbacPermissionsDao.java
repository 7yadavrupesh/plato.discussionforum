/**********************************************************************************
* File-name - RbacPermissionsDao.java
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
 * Description: The Dao interface for the rbac_permissions table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.dao;

import java.util.List;

import com.srmri.plato.core.rbac.entity.RbacPermissions;

public interface RbacPermissionsDao {
	
	/**
	 * Method declaration
	 * Used to insert/update a permission
	 */
	public void rbacDInsertPermission(RbacPermissions permission);

	/**
	 * Method declaration
	 * Used to fetch the list of permissions
	 */
	public List<RbacPermissions> rbacDListPermissions();
	
	/**
	 * Method declaration
	 * Used to retrieve the details of a specific permission
	 */
	public RbacPermissions rbacDGetPermission(long permissionId);
	
	/**
	 * Method declaration
	 * Used to delete the details of a specific permission
	 */
	public void rbacDDeletePermission(RbacPermissions permission);
	
	/**
	 * Method declaration
	 * Used to retrieve the permissions of a module 
	 */
	public List<RbacPermissions> rbacDGetModulePermissions(int moduleId);
	
	/**
	 * Method declaration
	 * Used to retrieve the permission id for a given permission code
	 */
	public long rbacDGetPermissionId(String permissionCode);

}
