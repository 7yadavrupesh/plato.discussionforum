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

package com.srmri.plato.core.discussionforum.service;

import java.util.List;
import com.srmri.plato.core.discussionforum.entity.DfThread;
import com.srmri.plato.core.discussionforum.entity.DfTopic;

public interface DfThreadService {
	/*
	 *  Method declaration
	 *  Create New Thread
	 */
	boolean dfSNewThreadCreate(Long topicId, Long userId, String title,String description,Long file);
	/*
	 *  Method declaration
	 *  Delete Thread
	 */
	boolean dfSDeleteThread(DfThread thread);
	/*
	 *  Method declaration
	 *  Change Visibility Of Given Thread
	 */
	boolean dfSChangeVisibilityThread(DfThread thread, boolean flag);
	/*
	 *  Method declaration
	 *  Get All Threads Under Given Thread
	 */
	List<DfThread> dfSGetTopicThreads(DfTopic topic);
	/*
	 *  Method declaration
	 *  Approve Thread
	 */
	boolean dfSApproveThread(Long threadId, boolean flag);
	/*
	 *  Method declaration
	 *  Delete Thread
	 */
	boolean dfSDeleteThread(Long threadId);
	/*
	 *  Method declaration
	 *  Get Topic Thread
	 */
	List<DfThread> dfSGetTopicThreads(Long topicId);
	List<DfThread> dfSGetAllThreadList();
	DfThread dfSGetThread(Long threadId);
	boolean dfSAddThread(DfThread thread);
	List<DfThread> dfSGetAllUnApprovedThreadList();
	List<DfThread> dfSGetDeletedThreadList(Long UserId);
	void dfSUndoDeletedThread(Long thread_id);
	List<DfThread> dfSGetAllDeletedThreadList(Long topicId);
	List<DfThread> dfSGetAllDeletedThreadList();
	List<DfThread> dfSGetAllThreadListUser(Long userId);
	List<DfThread> dfSGetAllThreadApprovedByUser(Long userId);
}
