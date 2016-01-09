/**********************************************************************************
 * File-name - DfAttachedFile
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


@Entity
@Table(name = "discussion_forum.df_thread_reply_file_map")
public class DfThreadReplyFileMap implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4838186960117688595L;

	@Id	
	@SequenceGenerator(name="df_thread_reply_file_map_thread_reply_file_map_id_seq", sequenceName="discussion_forum.df_thread_reply_file_map_thread_reply_file_map_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="df_thread_reply_file_map_thread_reply_file_map_id_seq")
	@Column(name = "thread_reply_file_map_id")
	private Long threadReplyFileMapId;
	
	@Column(name = "file_id")
	private Long fileId;
	
	@Column(name = "thread_reply_id")
	private Long threadReplyId;
	

	public DfThreadReplyFileMap() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getThreadReplyFileMapId() {
		return threadReplyFileMapId;
	}

	public void setThreadReplyFileMapId(Long threadReplyFileMapId) {
		this.threadReplyFileMapId = threadReplyFileMapId;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public Long getThreadReplyId() {
		return threadReplyId;
	}

	public void setThreadReplyId(Long threadReplyId) {
		this.threadReplyId = threadReplyId;
	}

}
