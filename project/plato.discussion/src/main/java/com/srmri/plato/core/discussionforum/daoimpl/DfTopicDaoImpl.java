/**********************************************************************************
 * File-name - DfTopicDaoImpl
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
import com.srmri.plato.core.discussionforum.dao.*;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srmri.plato.core.discussionforum.entity.DfTopic;

@Repository("dfTopicDao")
public class DfTopicDaoImpl implements DfTopicDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public DfTopicDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *  Method definition
	 *  Add Topic
	 */
	public void dfDAddTopic(DfTopic topic){
		sessionFactory.getCurrentSession().saveOrUpdate(topic);
	}
	
	/*
	 *  Method definition
	 *  Get Topic
	 */
	public DfTopic dfDGetTopic(Long topicId){
		return (DfTopic)sessionFactory.getCurrentSession().get(DfTopic.class, topicId); 
	}
	
	/*
	 *  Method definition
	 *  Delete Topic
	 */
	public void dfDDeteteTopic(Long topicId){
		DfTopic topic = dfDGetTopic(topicId);
		topic.setDeletedFlag(true);
		dfDAddTopic(topic);
	}
	
	/*
	 *  Method definition
	 *  Get All Topic List
	 */
	@SuppressWarnings("unchecked")
	public List<DfTopic> dfDGetAllTopicList(){
		Criteria cri= sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.eq("deletedFlag", false));
		cri.add(Restrictions.eq("approvedFlag", true));
		return cri.list();
	}
	
	/*
	 *  Method definition
	 *  Get Topic List
	 */
	public List<DfTopic> dfDGetTopicList(List<Long> topicIdList){
		List<DfTopic> list = null;
		return list;
	}
	
	/*
	 *  Method definition
	 *  Update Topic
	 */
	public boolean dfDUpdateTopic(DfTopic topic){
		sessionFactory.getCurrentSession().saveOrUpdate(topic);
		return false;
	}
	
	/*
	 *  Method definition
	 *  Get Topics, User Act As Moderator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DfTopic> dfDGetTopicUserActModerator(Long userId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.eq("createdUserid", userId));
		List<DfTopic> list = cri.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DfTopic> dfDGetTopicList(Long userId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.and(Restrictions.eq("createdUserid", userId),Restrictions.eq("deletedFlag", false)));
		cri.add(Restrictions.eq("approvedFlag", true));
		sessionFactory.getCurrentSession().flush();
		return cri.list();
	}

	@Override
	public List<DfTopic> dfDGetAllDeletedTopic() {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.eq("deletedFlag", true));
		cri.add(Restrictions.eq("approvedFlag", true));
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DfTopic> dfDGetAllDeletedNonDeletedTopicList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(DfTopic.class).list();
	}

	@Override
	public List<DfTopic> dfDGetAllUnApprovedTopics() {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.eq("approvedFlag", false));
		cri.add(Restrictions.eq("deletedFlag", false));
		return cri.list();
	}

	@Override
	public void dfDApproveTopic(Long topic_id) {
		// TODO Auto-generated method stub
		DfTopic topic = (DfTopic) sessionFactory.getCurrentSession().load(DfTopic.class, topic_id);
		topic.setApprovedFlag(true);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DfTopic> dfDGetTopicList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(DfTopic.class).list();
	}

	@Override
	public List<DfTopic> dfDGetAllTopicsApprovedByUser(Long userId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.eq("approvedBy", userId));
		cri.add(Restrictions.eq("deletedFlag", false));
		return cri.list();
	}
}
