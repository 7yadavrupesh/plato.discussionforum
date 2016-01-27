/**********************************************************************************
* File-name - RbacPermissions.java
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
 * Description: The entity class for the rbac_permissions table
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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name="usermanagement.rbac_permissions")
public class RbacPermissions implements Serializable{

	private static final long serialVersionUID = -723583058586873472L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="permissions_seq")
	@SequenceGenerator(name="permissions_seq", sequenceName="usermanagement.rbac_permissions_permission_id_seq", allocationSize=1)
	@Column(name = "permission_id")
	private Integer permissionId;
	
	@NotNull(message = "Permission code cannot be empty")	
	@NotBlank(message = "Permission code cannot be blank")
	@Column(name="permission_code")
	private String permissionCode;
	
	@NotNull(message = "Permission name cannot be empty")	
	@NotBlank(message = "Permission name cannot be blank")
	@Column(name="permission_name")
	private String permissionName;	
	
	@NotNull(message = "Select a module")
	@Column(name = "module_id")
	private Integer moduleId;
	
	@NotNull(message = "Description cannot be empty")	
	@NotBlank(message = "Description cannot be blank")
	@Column(name="description")
	private String description;

	/**
	 * @return the permissionId
	 */
	public Integer getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	/**
	 * @return the permissionCode
	 */
	public String getPermissionCode() {
		return permissionCode;
	}

	/**
	 * @param permissionCode the permissionCode to set
	 */
	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	/**
	 * @return the permissionName
	 */
	public String getPermissionName() {
		return permissionName;
	}

	/**
	 * @param permissionName the permissionName to set
	 */
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	/**
	 * @return the moduleId
	 */
	public Integer getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Check if the operation was an insert or an update
	 */
	public boolean isNew() {
		return (this.permissionId == null);
	}
	
}
