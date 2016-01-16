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

import java.lang.Long;
import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfModeratorAssigned;

public interface DfModeratorAssignedService {
	/*
	 *  Method declaration
	 *  Set Moderator
	 */
	boolean df_s_setModerator(Long topicId, Long userId, boolean flag);
	
	/*
	 *  Method declaration
	 *  Notify Moderator
	 */
	boolean df_s_notifyModerator();
	
	List<Long> df_s_getModeratorList(Long topicId);
	List<DfModeratorAssigned> df_s_getModeratorObjList(Long topicId);
	List<DfModeratorAssigned> df_s_getTopicUserActModerator(Long loginUserId);
	void df_s_addModerator(DfModeratorAssigned moderator);
}
