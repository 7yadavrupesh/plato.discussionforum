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
	void dfDAddThread(DfThread thread);
	
	/*
	 *  Method Declaration
	 *  Delete Thread using thread id
	 */
	void dfDDeteteThread(Long threadId);
	
	/*
	 *  Method Declaration
	 *  Delete Thread using Thread Object
	 */
	public void dfDDeteteThread(DfThread thread);
	
	/*
	 *  Method Declaration
	 *  Update Thread
	 */
	void dfDUpdateThread(DfThread thread);
	
	/*
	 *  Method Declaration
	 *  Get Thread Details
	 */
	String dfDGetThreadDetail(Long threadId);
	
	/*
	 *  Method Declaration
	 *  Get All Thread List Using Topic Object
	 */
	List<DfThread> dfDGetAllThreadList(DfTopic topic);
	
	/*
	 *  Method Declaration
	 *  Get All Thread List Using Topic Id
	 */
	List<DfThread> dfDGetAllThreadList(Long topicId);
	
	/*
	 *  Method Declaration
	 *  Approve Thread
	 */
	void dfDApproveThread(Long threadId, boolean approveFlag);
	
	/*
	 *  Method Declaration
	 *  Get UnApproved Thread
	 */
	List<DfThread> dfDGetAllUnApprovedThreadList();
	List<DfThread> dfDGetAllThreadList();
	DfThread dfDGetThread(Long threadId);
	List<DfThread> dfDGetDeletedThreadList(Long userId);
	void dfDUndoDeletedThread(Long thread_id);
	List<DfThread> dfDGetAllDeletedThreadList(Long topicId);

	List<DfThread> dfDGetAllDeletedThreadList();

	List<DfThread> dfDGetAllThreadListUser(Long userId);

	List<DfThread> dfDGetAllThreadApprovedByUser(Long userId);
}
