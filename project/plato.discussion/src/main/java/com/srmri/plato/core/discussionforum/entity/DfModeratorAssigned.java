/**********************************************************************************
 * File-name - DfModeratorAssigned
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
 * Description: <Add description about the file>
 *
 ****************************************************************************/

package com.srmri.plato.core.discussionforum.entity;
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

import java.sql.Timestamp;

@Entity
@Table(name = "discussion_forum.df_moderator_assigned")

public class DfModeratorAssigned implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2250077329703534391L;

	@Id
	@SequenceGenerator(name="df_moderator_assigned_seq", sequenceName="discussion_forum.df_moderator_assigned_moderator_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="df_moderator_assigned_seq")
	@Column(name = "moderator_id")
	private Long moderatorId;

	@NotNull(message="please select topic")
	@Column(name = "topic_id")
	private Long topicId;
	
	@NotNull(message="please select user")
	@Column(name = "assigned_to_userid")
	private Long assignedToUserid;
	
	@Column(name = "assigned_time")
	private Timestamp assignedTime;
	
	//@NotNull(message="please select assigned by user")
	@Column(name = "assigned_by_userid")
	private Long assignedByUserid;

	public DfModeratorAssigned() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the moderatorId
	 */
	public Long getModeratorId() {
		return moderatorId;
	}
	/**
	 * @param moderatorId the moderatorId to set
	 */
	public void setModeratorId(Long moderatorId) {
		this.moderatorId = moderatorId;
	}
	/**
	 * @return the topicId
	 */
	public Long getTopicId() {
		return topicId;
	}
	/**
	 * @param topicId the topicId to set
	 */
	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}
	/**
	 * @return the assignedToUserid
	 */
	public Long getAssignedToUserid() {
		return assignedToUserid;
	}
	/**
	 * @param assignedToUserid the assignedToUserid to set
	 */
	public void setAssignedToUserid(Long assignedToUserid) {
		this.assignedToUserid = assignedToUserid;
	}
	/**
	 * @return the assignedTime
	 */
	public Timestamp getAssignedTime() {
		return assignedTime;
	}
	/**
	 * @param assignedTime the assignedTime to set
	 */
	public void setAssignedTime(Timestamp assignedTime) {
		this.assignedTime = assignedTime;
	}
	/**
	 * @return the assignedByUserid
	 */
	public Long getAssignedByUserid() {
		return assignedByUserid;
	}
	/**
	 * @param assignedByUserid the assignedByUserid to set
	 */
	public void setAssignedByUserid(Long assignedByUserid) {
		this.assignedByUserid = assignedByUserid;
	}
	
}
