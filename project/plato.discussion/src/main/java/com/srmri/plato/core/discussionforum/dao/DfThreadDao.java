/**********************************************************************************
 * File-name - DfThreadDao
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

package com.srmri.plato.core.discussionforum.dao;

import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfThread;
import com.srmri.plato.core.discussionforum.entity.DfTopic;

public interface DfThreadDao {
	
	/*
	 *  Method Declaration
	 *  Add Thread
	 */
	void df_d_addThread(DfThread thread);
	
	/*
	 *  Method Declaration
	 *  Delete Thread using thread id
	 */
	void df_d_deteteThread(Long threadId);
	
	/*
	 *  Method Declaration
	 *  Delete Thread using Thread Object
	 */
	public void df_d_deteteThread(DfThread thread);
	
	/*
	 *  Method Declaration
	 *  Update Thread
	 */
	void df_d_updateThread(DfThread thread);
	
	/*
	 *  Method Declaration
	 *  Get Thread Details
	 */
	String df_d_getThreadDetail(Long threadId);
	
	/*
	 *  Method Declaration
	 *  Get All Thread List Using Topic Object
	 */
	List<DfThread> df_d_getAllThreadList(DfTopic topic);
	
	/*
	 *  Method Declaration
	 *  Get All Thread List Using Topic Id
	 */
	List<DfThread> df_d_getAllThreadList(Long topicId);
	
	/*
	 *  Method Declaration
	 *  Approve Thread
	 */
	void df_d_approveThread(Long threadId, boolean approveFlag);
	
	/*
	 *  Method Declaration
	 *  Get UnApproved Thread
	 */
	List<DfThread> df_d_getAllUnApprovedThreadList();
	List<DfThread> df_d_getAllThreadList();
	DfThread df_d_getThread(Long threadId);
	List<DfThread> df_d_getDeletedThreadList(Long userId);
	void df_d_undoDeletedThread(Long thread_id);
	List<DfThread> df_d_getAllDeletedThreadList(Long topicId);

	List<DfThread> df_d_getAllDeletedThreadList();
}
