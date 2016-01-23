/**********************************************************************************
 * File-name - DfModeratorAssignedServiceImpl
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

package com.srmri.plato.core.discussionforum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.discussionforum.dao.DfModeratorAssignedDao;
import com.srmri.plato.core.discussionforum.entity.DfModeratorAssigned;
import com.srmri.plato.core.discussionforum.service.DfModeratorAssignedService;

@Service("moderatorAssignedService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DfModeratorAssignedServiceImpl implements DfModeratorAssignedService {

	public DfModeratorAssignedServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private DfModeratorAssignedDao moderatorDao;
	/*
	 *  Method definition
	 *  Set Moderator
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean dfSSetModerator(Long topicId, Long userId, boolean flag) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 *  Method definition
	 *  Notify Moderator
	 */
	@Override
	public boolean dfSNotifyModerator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Long> dfSGetModeratorList(Long topicId) {
		// TODO Auto-generated method stub
		return moderatorDao.dfDGetModeratorList(topicId);
	}

	@Override
	public List<DfModeratorAssigned> dfSGetTopicUserActModerator(Long loginUserId) {
		// TODO Auto-generated method stub
		return moderatorDao.dfDGetTopicUserActModerator(loginUserId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void dfSAddModerator(DfModeratorAssigned moderator) {
		// TODO Auto-generated method stub
		moderatorDao.dfDAddModerator(moderator);
	}

	@Override
	public List<DfModeratorAssigned> dfSGetModeratorObjList(Long topicId) {
		// TODO Auto-generated method stub
		return moderatorDao.dfDGetModeratorObjList(topicId);
	}

	@Override
	public DfModeratorAssigned dfSGetModerator(Long assignedToUserid, Long topicId) {
		// TODO Auto-generated method stub
	return 	moderatorDao.dfDGetModerator(assignedToUserid,topicId);

	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void dfSRemoveModerator(DfModeratorAssigned moderatorToDelete) {
		// TODO Auto-generated method stub
		moderatorDao.dfDRemoveModerator(moderatorToDelete.getModeratorId());
	}

	@Override
	public List<DfModeratorAssigned> dfSGetAllModerators() {
		// TODO Auto-generated method stub
		return moderatorDao.dfDGetAllModerators();
	}

	@Override
	public List<Long> dfSGetAllDistinctModeratorsId() {
		// TODO Auto-generated method stub
		return moderatorDao.dfDGetAllDistinctModeratorsId();
	}

	@Override
	public DfModeratorAssigned dfSGetModerator(Long moderatorId) {
		// TODO Auto-generated method stub
		
		return moderatorDao.dfDGetModerator(moderatorId);
	}
}
