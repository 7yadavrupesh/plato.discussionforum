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
	boolean dfSSetModerator(Long topicId, Long userId, boolean flag);
	
	/*
	 *  Method declaration
	 *  Notify Moderator
	 */
	boolean dfSNotifyModerator();
	
	List<Long> dfSGetModeratorList(Long topicId);
	List<DfModeratorAssigned> dfSGetModeratorObjList(Long topicId);
	List<DfModeratorAssigned> dfSGetTopicUserActModerator(Long loginUserId);
	void dfSAddModerator(DfModeratorAssigned moderator);

	DfModeratorAssigned dfSGetModerator(Long assignedToUserid, Long topicId);

	void dfSRemoveModerator(DfModeratorAssigned moderatorToDelete);

	List<DfModeratorAssigned> dfSGetAllModerators();

	List<Long> dfSGetAllDistinctModeratorsId();

	DfModeratorAssigned dfSGetModerator(Long moderatorId);

	

}
