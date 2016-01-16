/**********************************************************************************
 * File-name - DfModeratorAssignedDaoImpl
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

package com.srmri.plato.core.discussionforum.daoimpl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srmri.plato.core.discussionforum.dao.DfModeratorAssignedDao;
import com.srmri.plato.core.discussionforum.entity.DfModeratorAssigned;


@Repository("dfModeratorAssignedDao")
public class DfModeratorAssignedDaoImpl implements DfModeratorAssignedDao{

	@Autowired
	private SessionFactory sessionFactory;

	public DfModeratorAssignedDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *  Method definition
	 *  Add Moderator
	 */
	@Override
	public Long df_d_addModerator(DfModeratorAssigned moderator) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(moderator);
		return moderator.getModeratorId();
	}
	
	/*
	 *  Method definition
	 *  Gets All Topics, User Act As Moderator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DfModeratorAssigned> df_d_getTopicUserActModerator(Long assignedToUserId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfModeratorAssigned.class);
		cri.add(Restrictions.eq("assignedToUserid",assignedToUserId));
		List<DfModeratorAssigned> result = cri.list();
		return result;
	}
	
	/*
	 *  Method definition
	 *  Remove Moderator
	 */
	@Override
	public void df_d_removeModerator(Long modId) {
		// TODO Auto-generated method stub
		DfModeratorAssigned moderator = new DfModeratorAssigned();
		moderator.setModeratorId(modId);
		sessionFactory.getCurrentSession().delete(moderator);
	}

	/*
	 *  Method definition
	 *  Get Moderator List
	 */
	@SuppressWarnings("null")
	@Override
	public List<Long> df_d_getModeratorList(Long topicId) {
		// TODO Auto-generated method stub
		
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfModeratorAssigned.class);
		cri.add(Restrictions.eq("topicId", topicId));
		@SuppressWarnings("unchecked")
		List<DfModeratorAssigned> mixedList = cri.list();
		List<Long> memList = new ArrayList<Long>();
		for (DfModeratorAssigned dfModeratorAssigned : mixedList) {
			memList.add(dfModeratorAssigned.getAssignedToUserid());
		}
		List<Long> distinctMemList = memList.stream().distinct().collect(Collectors.toList());
	    
		return distinctMemList;
	}

	@Override
	public List<DfModeratorAssigned> df_d_getModeratorObjList(Long topicId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfModeratorAssigned.class);
		cri.add(Restrictions.eq("topicId", topicId));
		return cri.list();
	}
}
