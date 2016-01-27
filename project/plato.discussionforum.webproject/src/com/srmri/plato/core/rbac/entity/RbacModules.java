/**********************************************************************************
* File-name - RbacModules.java
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
 * Description: The entity class for the rbac_modules table
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
@Table(name="usermanagement.rbac_modules")
public class RbacModules implements Serializable{

	private static final long serialVersionUID = -723583058586873471L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="modules_seq")
	@SequenceGenerator(name="modules_seq", sequenceName="usermanagement.rbac_modules_module_id_seq", allocationSize=1)
	@Column(name = "module_id")
	private Integer moduleId;
	
	@NotNull(message = "Module name cannot be empty")	
	@NotBlank(message = "Module name cannot be blank")
	@Column(name="module_name")
	private String moduleName;
	
	@NotNull(message = "Module description cannot be empty")	
	@NotBlank(message = "Module description cannot be blank")
	@Column(name="description")
	private String description;

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
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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
		return (this.moduleId == null);
	}

	
}
