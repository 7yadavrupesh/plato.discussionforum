/**********************************************************************************
* File-name - RbacRole.java
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
 * Description: The entity class for the rbac_role table
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
@Table(name="usermanagement.rbac_role")
public class RbacRole implements Serializable{

	private static final long serialVersionUID = -723583058586873473L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="role_seq")
	@SequenceGenerator(name="role_seq", sequenceName="usermanagement.rbac_role_role_id_seq", allocationSize=1)
	@Column(name = "role_id")
	private Integer roleId;
	
	@NotNull(message = "Role name cannot be empty")
	@NotBlank(message = "Role name cannot be blank")
	@Column(name="role_name")
	private String roleName;
	
	@NotNull(message = "Role description cannot be empty")
	@NotBlank(message = "Role description cannot be blank")
	@Column(name="description")
	private String description;
	
	@NotNull(message = "Select a Role Level")
	@Column(name = "role_level_id")
	private Integer roleLevelId;

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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	 * @return the roleLevelId
	 */
	public Integer getRoleLevelId() {
		return roleLevelId;
	}

	/**
	 * @param roleLevelId the roleLevelId to set
	 */
	public void setRoleLevelId(Integer roleLevelId) {
		this.roleLevelId = roleLevelId;
	}
	
	/**
	 * Check if the operation was an insert or an update
	 */
	public boolean isNew() {
		return (this.roleId == null);
	}


	
}
