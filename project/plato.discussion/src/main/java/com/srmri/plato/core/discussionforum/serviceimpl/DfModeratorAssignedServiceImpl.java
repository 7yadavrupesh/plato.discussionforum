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
	public boolean df_s_setModerator(Long topicId, Long userId, boolean flag) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 *  Method definition
	 *  Notify Moderator
	 */
	@Override
	public boolean df_s_notifyModerator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Long> df_s_getModeratorList(Long topicId) {
		// TODO Auto-generated method stub
		return moderatorDao.df_d_getModeratorList(topicId);
	}

	@Override
	public List<DfModeratorAssigned> df_s_getTopicUserActModerator(Long loginUserId) {
		// TODO Auto-generated method stub
		return moderatorDao.df_d_getTopicUserActModerator(loginUserId);
	}

	@Override
	public void df_s_addModerator(DfModeratorAssigned moderator) {
		// TODO Auto-generated method stub
		moderatorDao.df_d_addModerator(moderator);
	}

	@Override
	public List<DfModeratorAssigned> df_s_getModeratorObjList(Long topicId) {
		// TODO Auto-generated method stub
		moderatorDao.df_d_getModeratorObjList(topicId);
		return null;
	}
}
