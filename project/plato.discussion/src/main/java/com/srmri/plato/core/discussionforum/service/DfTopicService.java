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
	boolean dfSInsertTopic(String topicTitle, Long createdUserid, Timestamp createdTime, boolean deleteFlag);
	void dfSInsertTopic(DfTopic topic);
	/*
	 *  Method declaration
	 *  Delete Topic
	 */
	boolean dfSDeleteTopic(Long topicId);
	/*
	 *  Method declaration
	 *  Get Thread List Waiting For Approval
	 */
	List<DfThread> dfSGetThreadListWaitForApproval(Long userId);
	
	List<DfTopic> dfSGetAllTopicList();
	DfTopic dfSGetTopic(Long topicId);
	List<DfTopic> dfSGetDeletedTopic(Long userId);
	List<DfTopic> dfSGetTopicList(Long userId);
	List<DfTopic> dfSGetAllDeletedTopic();
	List<DfTopic> dfSGetAllDeletedNonDeletedTopicList();
	List<DfTopic> dfSGetAllUnApprovedTopics();
	void dfSUndoDeletedTopic(Long topicId);
	void dfSApproveTopic(Long topic_id);
	List<DfTopic> dfSGetTopicList();
	List<DfTopic> dfSGetAllTopicsApprovedByUser(Long userId);
}
