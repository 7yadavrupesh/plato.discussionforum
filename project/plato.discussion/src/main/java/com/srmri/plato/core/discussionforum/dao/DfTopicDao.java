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
	void df_d_addTopic(DfTopic topic);
	
	/*
	 *  Method Declaration
	 *  Delete Topic
	 */
	void df_d_deteteTopic(Long topicId);
	
	/*
	 *  Method Declaration
	 *  Update Topic
	 */
	boolean df_d_updateTopic(DfTopic topic);
	
	/*
	 * Method Declaration 
	 * Get Topic
	 */
	DfTopic df_d_getTopic(Long topicId);
	
	/*
	 *  Method Declaration
	 *  Get All Topic List
	 */
	List<DfTopic> df_d_getAllTopicList();
	
	/*
	 *  Method Declaration
	 *  Get Topic List
	 */
	List<DfTopic> df_d_getTopicList(List<Long> topicIdList);
	
	/*
	 *  Method Declaration
	 *  Get Topics, User Act As Moderator
	 */
	List<DfTopic> df_d_getTopicUserActModerator(Long userId);
	List<DfTopic> df_d_getTopicList(Long userId);
	List<DfTopic> df_d_getAllDeletedTopic();

	List<DfTopic> getAllDeletedNonDeletedTopicList();

	List<DfTopic> df_d_getAllUnApprovedTopics();

	void df_d_approveTopic(Long topic_id);
}
