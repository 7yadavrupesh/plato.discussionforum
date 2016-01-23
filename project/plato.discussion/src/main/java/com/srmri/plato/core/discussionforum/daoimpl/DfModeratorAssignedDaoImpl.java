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
import org.hibernate.criterion.Projections;
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
	public Long dfDAddModerator(DfModeratorAssigned moderator) {
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
	public List<DfModeratorAssigned> dfDGetTopicUserActModerator(Long assignedToUserId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfModeratorAssigned.class);
		cri.add(Restrictions.eq("assignedToUserid",assignedToUserId));
		return cri.list();
	}
	
	/*
	 *  Method definition
	 *  Remove Moderator
	 */
	@Override
	public void dfDRemoveModerator(Long modId) {
		// TODO Auto-generated method stub
		DfModeratorAssigned moderator = new DfModeratorAssigned();
		moderator.setModeratorId(modId);
		sessionFactory.getCurrentSession().delete(moderator);
	}

	/*
	 *  Method definition
	 *  Get Moderator List
	 */

	@Override
	public List<Long> dfDGetModeratorList(Long topicId) {
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

	@SuppressWarnings("unchecked")
	@Override
	public List<DfModeratorAssigned> dfDGetModeratorObjList(Long topicId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfModeratorAssigned.class);
		cri.add(Restrictions.eq("topicId", topicId));
		return cri.list();
	}

	@Override
	public DfModeratorAssigned dfDGetModerator(Long assignedToUserid, Long topicId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfModeratorAssigned.class);
		cri.add(Restrictions.eq("topicId", topicId));
		cri.add(Restrictions.eq("assignedToUserid", assignedToUserid));
		if(!cri.list().isEmpty()){
			return (DfModeratorAssigned) cri.list().get(0);
		}
		else return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DfModeratorAssigned> dfDGetAllModerators() {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfModeratorAssigned.class);
		return cri.list();
	}

	@Override
	public List<Long> dfDGetAllDistinctModeratorsId() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List <Long> modList = sessionFactory.getCurrentSession().createCriteria(DfModeratorAssigned.class)
				.setProjection(Projections.distinct(Projections.property("assignedToUserid"))).list();
		sessionFactory.getCurrentSession().flush();
		return modList;
	}

	@Override
	public DfModeratorAssigned dfDGetModerator(Long moderatorId) {
		// TODO Auto-generated method stub
		DfModeratorAssigned obj=  (DfModeratorAssigned) sessionFactory.getCurrentSession().load(DfModeratorAssigned.class, moderatorId);
		sessionFactory.getCurrentSession().flush();
		return obj;
	}
}
