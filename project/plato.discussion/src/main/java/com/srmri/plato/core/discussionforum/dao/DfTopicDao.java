/**********************************************************************************
 * File-name - DfTopicDao
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

import com.srmri.plato.core.discussionforum.entity.DfTopic;
import java.util.List;

public interface DfTopicDao {

	/*
	 *  Method Declaration
	 *  Add Topic
	 */
	void dfDAddTopic(DfTopic topic);
	
	/*
	 *  Method Declaration
	 *  Delete Topic
	 */
	void dfDDeteteTopic(Long topicId);
	
	/*
	 * Method Declaration 
	 * Get Topic
	 */
	DfTopic dfDGetTopic(Long topicId);
	
	/*
	 *  Method Declaration
	 *  Get All Topic List
	 */
	List<DfTopic> dfDGetAllTopicList();
	
	
	/*
	 *  Method Declaration
	 *  Get Topics, User Act As Moderator
	 */
	List<DfTopic> dfDGetTopicUserActModerator(Long userId);
	List<DfTopic> dfDGetTopicList(Long userId);
	List<DfTopic> dfDGetAllDeletedTopic();

	List<DfTopic> dfDGetAllDeletedNonDeletedTopicList();

	List<DfTopic> dfDGetAllUnApprovedTopics();

	void dfDApproveTopic(Long topic_id);

	List<DfTopic> dfDGetTopicList();

	List<DfTopic> dfDGetAllTopicsApprovedByUser(Long userId);
}
