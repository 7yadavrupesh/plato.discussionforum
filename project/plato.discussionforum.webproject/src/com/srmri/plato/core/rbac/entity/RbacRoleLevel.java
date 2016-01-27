/**********************************************************************************
* File-name - RbacRoleLevel.java
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
 * Description: The entity class for the rbac_role_level table
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
@Table(name="usermanagement.rbac_role_level")
public class RbacRoleLevel implements Serializable{

	private static final long serialVersionUID = -723583058586873470L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="role_level_seq")
	@SequenceGenerator(name="role_level_seq", sequenceName="usermanagement.rbac_role_level_role_level_id_seq", allocationSize=1)	
	@Column(name = "role_level_id")
	private Integer roleLevelId;
	
	@NotNull(message = "Role level name cannot be empty")
	@NotBlank(message = "Role level name cannot be blank")
	@Column(name="role_level_name")
	private String roleLevelName;
	
	@NotNull(message = "Description cannot be empty")
	@NotBlank(message = "Description cannot be blank")
	@Column(name="description")
	private String description;

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
	 * @return the roleLevelName
	 */
	public String getRoleLevelName() {
		return roleLevelName;
	}

	/**
	 * @param roleLevelName the roleLevelName to set
	 */
	public void setRoleLevelName(String roleLevelName) {
		this.roleLevelName = roleLevelName;
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
		return (this.roleLevelId == null);
	}

}
