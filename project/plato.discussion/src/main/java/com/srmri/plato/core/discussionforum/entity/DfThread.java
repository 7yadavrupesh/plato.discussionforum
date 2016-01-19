/**********************************************************************************
                                               * File-name - DfThread
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
import javax.tools.ToolProvider;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "discussion_forum.df_thread")
public class DfThread implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 523022698155492119L;

	@Id
	@SequenceGenerator(name="df_thread_seq", sequenceName="discussion_forum.df_thread_thread_id_seq", allocationSize=1)	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="df_thread_seq")
	@Column(name="thread_id")
	private Long threadId;
	
	@Column(name = "created_userid")
	private Long createdUserid;
	
	@Column(name = "created_time")
	private Timestamp createdTime;
	
	@Column(name = "modified_time")
	private Timestamp modifiedTime;
	
	@NotNull(message = "should not be blank")
	@Column(name = "topic_id")
	private Long topicId;
	
	@NotBlank(message = "should not be blank")
	@Size(min=5,max=100,message="minimum 5 and maximum 100 characters")
	@Column(name = "thread_title")
	private String threadTitle;
	
	@NotBlank(message = "should not be blank")
	@Size(min=10,message="minimum 10 characters")
	@Column(name = "description")
	private String description;
	
	@Column(name = "approved")
	private Boolean approved;
	
	@Column(name = "deleted_flag")
	private Boolean deletedFlag;
	
	@Column(name = "approved_by")
	private Long approvedBy;
	
	public Long getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}

	public DfThread() {
		// TODO Auto-generated constructor stub
	}
	
	public DfThread(Long createdUserId, Timestamp createdTime, Timestamp modifiedTime, Long topicId,
			String title, String description, boolean approved, boolean deletedFlag) {
		
		this.createdUserid = createdUserId;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
		this.topicId = topicId;
		this.threadTitle = title;
		this.description = description;
		this.approved = approved;
		this.deletedFlag = deletedFlag;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param threadId the threadId to set
	 */
	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}
	/**
	 * @return the threadId
	 */
	public Long getThreadId() {
		return threadId;
	}
	/**
	 * @return the createdUserId
	 */
	public Long getCreatedUserid() {
		return createdUserid;
	}
	/**
	 * @param createdUserid the createdUserid to set
	 */
	public void setCreatedUserid(Long createdUserid) {
		this.createdUserid = createdUserid;
	}
	/**
	 * @return the createdTime
	 */
	public String getCreatedTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(createdTime);
	}
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * @return the modifiedTime
	 */
	public String getModifiedTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(modifiedTime);
	}
	/**
	 * @param modifiedTime the modifiedTime to set
	 */
	public void setModifiedTime(Timestamp modifiedTime) {
		this.modifiedTime = modifiedTime;
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
	 * @return the threadTitle
	 */
	public String getThreadTitle() {
		return threadTitle;
	}
	/**
	 * @param threadTitle the threadTitle to set
	 */
	public void setThreadTitle(String threadTitle) {
		this.threadTitle = threadTitle;
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
	 * @return the approved
	 */
	public Boolean getApproved() {
		return approved;
	}
	/**
	 * @param approved the approved to set
	 */
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	/**
	 * @return the deletedFlag
	 */
	public Boolean getDeletedFlag() {
		return deletedFlag;
	}
	/**
	 * @param deletedFlag the deletedFlag to set
	 */
	public void setDeletedFlag(Boolean deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
}
