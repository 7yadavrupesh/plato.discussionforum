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
	boolean df_s_newThreadCreate(Long topicId, Long userId, String title,String description,Long file);
	/*
	 *  Method declaration
	 *  Delete Thread
	 */
	boolean df_s_deleteThread(DfThread thread);
	/*
	 *  Method declaration
	 *  Change Visibility Of Given Thread
	 */
	boolean df_s_changeVisibilityThread(DfThread thread, boolean flag);
	/*
	 *  Method declaration
	 *  Get All Threads Under Given Thread
	 */
	List<DfThread> df_s_getTopicThreads(DfTopic topic);
	/*
	 *  Method declaration
	 *  Approve Thread
	 */
	boolean df_s_approveThread(Long threadId, boolean flag);
	/*
	 *  Method declaration
	 *  Delete Thread
	 */
	boolean df_s_deleteThread(Long threadId);
	/*
	 *  Method declaration
	 *  Get Topic Thread
	 */
	List<DfThread> df_s_getTopicThreads(Long topicId);
	List<DfThread> df_s_getThreadList();
	DfThread df_s_getThread(Long threadId);
	boolean df_s_addThread(DfThread thread);
	List<DfThread> df_s_getAllUnApprovedThreadList();
	List<DfThread> df_s_getDeletedThreadList(Long UserId);
	void df_s_undoDeletedThread(Long thread_id);
	List<DfThread> df_s_getAllDeletedThreadList(Long topicId);
	List<DfThread> df_s_getAllDeletedThreadList();
}
