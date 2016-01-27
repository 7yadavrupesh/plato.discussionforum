/**********************************************************************************
* File-name - RbacRoleAssignment.java
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
 * Description: The entity class for the rbac_role_assignment table
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


@Entity
@Table(name="usermanagement.rbac_role_assignment")
public class RbacRoleAssignment implements Serializable{

	private static final long serialVersionUID = -723583058586873474L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="roleAssignment_seq")
	@SequenceGenerator(name="roleAssignment_seq", sequenceName="usermanagement.rbac_role_assignment_role_assignment_id_seq", allocationSize=1)
	@Column(name = "role_assignment_id")
	private Integer roleAssignmentId;
	
	@NotNull(message = "Select a role")
	@Column(name="role_id")
	private Integer roleId;
	
	@NotNull(message = "Select a user")
	@Column(name="user_id")
	private long userId;

	/**
	 * @return the roleAssignmentId
	 */
	public Integer getRoleAssignmentId() {
		return roleAssignmentId;
	}

	/**
	 * @param roleAssignmentId the roleAssignmentId to set
	 */
	public void setRoleAssignmentId(Integer roleAssignmentId) {
		this.roleAssignmentId = roleAssignmentId;
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
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	/**
	 * Check if the operation was an insert or an update
	 */
	public boolean isNew() {
		return (this.roleAssignmentId == null);
	}
	
	
}
