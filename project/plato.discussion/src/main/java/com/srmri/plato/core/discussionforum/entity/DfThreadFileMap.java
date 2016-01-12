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
@Table(name = "discussion_forum.df_thread_file_map")
public class DfThreadFileMap implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3947812209389319388L;

	@Id	
	@SequenceGenerator(name="df_thread_file_map_thread_file_map_id_seq", sequenceName="discussion_forum.df_thread_file_map_thread_file_map_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="df_thread_file_map_thread_file_map_id_seq")
	@Column(name = "thread_file_map_id")
	private Long threadFileMapId;
	
	@Column(name = "file_id")
	private Long fileId;
	
	@Column(name = "thread_id")
	private Long threadId;
	
	public DfThreadFileMap() {
		// TODO Auto-generated constructor stub
	}

	public Long getThreadFileMapId() {
		return threadFileMapId;
	}


	public void setThreadFileMapId(Long threadFileMapId) {
		this.threadFileMapId = threadFileMapId;
	}


	public Long getFileId() {
		return fileId;
	}


	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}
 

	public Long getThreadId() {
		return threadId;
	}


	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}
		
}
