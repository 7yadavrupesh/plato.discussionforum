/**********************************************************************************
* File-name - RbacRolePermissionsMap.java
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
 * Description: The entity class for the rbac_role_permissions_map table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="usermanagement.rbac_role_permissions_map")
public class RbacRolePermissionsMap implements Serializable{

	private static final long serialVersionUID = -723583058586873475L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="rbac_role_permissions_seq")
	@SequenceGenerator(name="rbac_role_permissions_seq", sequenceName="usermanagement.rbac_role_permissions_map_role_permissions_map_id_seq", allocationSize=1)
	@Column(name = "role_permissions_map_id")
	private long rolePermissionsMapId;
	
	@Column(name="role_id")
	private Integer roleId;
	
	@Column(name="permission_id")
	private long permissionId;

	/**
	 * @return the rolePermissionsMapId
	 */
	public long getRolePermissionsMapId() {
		return rolePermissionsMapId;
	}

	/**
	 * @param rolePermissionsMapId the rolePermissionsMapId to set
	 */
	public void setRolePermissionsMapId(long rolePermissionsMapId) {
		this.rolePermissionsMapId = rolePermissionsMapId;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the permissionId
	 */
	public long getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}	
	
}
