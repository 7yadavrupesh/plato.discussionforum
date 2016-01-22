/**********************************************************************************
 * File-name - DfTopic
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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name="discussion_forum.df_topic")
public class DfTopic implements Serializable{

	private static final long serialVersionUID = 8728109782073932894L;

	@Id
	@SequenceGenerator(name="df_topic_seq", sequenceName="discussion_forum.df_topic_topic_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="df_topic_seq")
	@Column(name = "topic_id")
	private Long topicId;
	
	@NotBlank(message = "should not be blank")
	@Size(min=2,max=30, message="min 2 characters")
	@Column(name = "topic_title")
	private String topicTitle;
	

	@NotBlank(message = "should not be blank")
	@Size(min=2,max=1000, message="min 10 characters")
	@Column(name = "topic_description")
	private String topicDescription;
	
	@Column(name = "created_userid")
	private Long createdUserid;
	
	@Column(name = "created_time")
	private Timestamp createdTime;
	
	@Column(name = "deleted_flag")
	private Boolean deletedFlag;
	
	@Column(name="approved_flag")
	private Boolean approvedFlag;
	
	@Column(name="approved_by")
	private Long approvedBy;
	
	@Column(name="number_of_view")
	private Long numberOfView = 0L;
	
	public Long getNumberOfView() {
		return numberOfView;
	}
	public void setNumberOfView(Long numberOfView) {
		this.numberOfView = numberOfView;
	}
	public Long getApprovedBy() {
		return approvedBy;
	}
	public void setApprovedBy(Long approvedBy) {
		this.approvedBy = approvedBy;
	}
	public DfTopic() {
		// TODO Auto-generated constructor stub
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
	 * @return the topicTitle
	 */
	public String getTopicTitle() {
		return topicTitle;
	}
	/**
	 * @param topicTitle the topicTitle to set
	 */
	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}
	/**
	 * @return the createdUserid
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
		//return createdTime;
	}
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
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
	
	/**
	 * @return the approvedFlag
	 */
	public Boolean getApprovedFlag() {
		return approvedFlag;
	}
	/**
	 * @param set approvedFlag
	 */
	public void setApprovedFlag(Boolean approvedFlag) {
		this.approvedFlag = approvedFlag;
	}
	public String getTopicDescription() {
		return topicDescription;
	}
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}
}
