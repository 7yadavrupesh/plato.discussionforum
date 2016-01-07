/**********************************************************************************
 * File-name - DfThreadReply
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

import java.sql.Timestamp;

@Entity
@Table(name = "discussion_forum.df_thread_reply")
public class DfThreadReply implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3439788315309397661L;
//
	@Id
	@SequenceGenerator(name="df_thread_reply_seq",sequenceName="discussion_forum.df_thread_reply_reply_id_seq", allocationSize=100)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="df_thread_reply_seq")
	@Column(name = "reply_id")
	private Long replyId;
	
	@Column(name = "submitted_userid")
	private Long submittedUserid;
	
	@Column(name = "submitted_time")
	private Timestamp submittedTime;

	@Column(name = "thread_id")
	private Long threadId;
	
	@Column(name = "file_id")
	private Long fileId;
	
	@Column(name = "reply_text")
	private String replyText;
	
	@Column(name = "deleted_flag")
	private Boolean deletedFlag;

	public DfThreadReply() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the replyId
	 */
	public Long getReplyId() {
		return replyId;
	}
	/**
	 * @param replyId the replyId to set
	 */
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}
	/**
	 * @return the submittedUserid
	 */
	public Long getSubmittedUserid() {
		return submittedUserid;
	}
	/**
	 * @param submittedUserid the submittedUserid to set
	 */
	public void setSubmittedUserid(Long submittedUserid) {
		this.submittedUserid = submittedUserid;
	}
	/**
	 * @return the submittedTime
	 */
	public Timestamp getSubmittedTime() {
		return submittedTime;
	}
	/**
	 * @param submittedTime the submittedTime to set
	 */
	public void setSubmittedTime(Timestamp submittedTime) {
		this.submittedTime = submittedTime;
	}
	/**
	 * @return the threadId
	 */
	public Long getThreadId() {
		return threadId;
	}
	/**
	 * @param threadId the threadId to set
	 */
	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}
	/**
	 * @return the fileId
	 */
	public Long getFileId() {
		return fileId;
	}
	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
	/**
	 * @return the replyText
	 */
	public String getReplyText() {
		return replyText;
	}
	/**
	 * @param replyText the replyText to set
	 */
	public void setReplyText(String replyText) {
		this.replyText = replyText;
	}
	/**
	 * @return the deleteFlag
	 */
	public Boolean getDeleteFlag() {
		return deletedFlag;
	}
	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(Boolean deletedFlag) {
		this.deletedFlag = deletedFlag;
	}
}
