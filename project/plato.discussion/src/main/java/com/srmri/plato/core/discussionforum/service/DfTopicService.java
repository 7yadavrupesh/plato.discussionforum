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

import java.sql.Timestamp;
import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfThread;
import com.srmri.plato.core.discussionforum.entity.DfTopic;


public interface DfTopicService {
	/*
	 *  Method declaration
	 *  Insert New Topic
	 */
	boolean df_s_insertTopic(String topicTitle, Long createdUserid, Timestamp createdTime, boolean deleteFlag);
	void df_s_insertTopic(DfTopic topic);
	/*
	 *  Method declaration
	 *  Delete Topic
	 */
	boolean df_s_deleteTopic(Long topicId);
	/*
	 *  Method declaration
	 *  Get Thread List Waiting For Approval
	 */
	List<DfThread> df_s_getThreadListWaitForApproval(Long userId);
	
	List<DfTopic> df_s_getAllTopicList();
	DfTopic df_s_getTopic(Long topicId);
	List<DfTopic> df_s_getDeletedTopic(Long userId);
	List<DfTopic> df_s_getTopicList(Long userId);
	List<DfTopic> df_s_getAllDeletedTopic();
	List<DfTopic> df_s_getAllDeletedNonDeletedTopicList();
	List<DfTopic> df_s_getAllUnApprovedTopics();
	void df_s_UndoDeletedTopic(Long topicId);
	void df_s_approveTopic(Long topic_id);
}
