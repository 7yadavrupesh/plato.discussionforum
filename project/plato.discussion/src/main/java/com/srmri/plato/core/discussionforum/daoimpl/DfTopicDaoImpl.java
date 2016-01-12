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
	public void df_d_addTopic(DfTopic topic){
		System.out.println("df_d_addTopic Enter");
		sessionFactory.getCurrentSession().saveOrUpdate(topic);
		System.out.println("df_d_addTopic out");
	}
	
	/*
	 *  Method definition
	 *  Get Topic
	 */
	public DfTopic df_d_getTopic(Long topicId){
		return (DfTopic)sessionFactory.getCurrentSession().get(DfTopic.class, topicId); 
	}
	
	/*
	 *  Method definition
	 *  Delete Topic
	 */
	public void df_d_deteteTopic(Long topicId){
		System.out.println("df_d_deleteTopic Enter");
		DfTopic topic = df_d_getTopic(topicId);
		topic.setDeletedFlag(true);
		df_d_addTopic(topic);
		System.out.println("df_d_deleteTopic out");
	}
	
	/*
	 *  Method definition
	 *  Get All Topic List
	 */
	@SuppressWarnings("unchecked")
	public List<DfTopic> df_d_getAllTopicList(){
		Criteria cri= sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.eq("deletedFlag", false));
		return cri.list();
	}
	
	/*
	 *  Method definition
	 *  Get Topic List
	 */
	public List<DfTopic> df_d_getTopicList(List<Long> topicIdList){
		List<DfTopic> list = null;
		return list;
	}
	
	/*
	 *  Method definition
	 *  Update Topic
	 */
	public boolean df_d_updateTopic(DfTopic topic){
		sessionFactory.getCurrentSession().saveOrUpdate(topic);
		return false;
	}
	
	/*
	 *  Method definition
	 *  Get Topics, User Act As Moderator
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DfTopic> df_d_getTopicUserActModerator(Long userId) {
		System.out.println("df_d_getTopicUserActModerator enter");
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.eq("createdUserid", userId));
		List<DfTopic> list = cri.list();
		if(list == null)
			System.out.println("list is null");
		System.out.println("moderator size: "+list.size());
		System.out.println("df_d_getTopicUserActModerator out");
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DfTopic> df_d_getTopicList(Long userId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.and(Restrictions.eq("createdUserid", userId),Restrictions.eq("deletedFlag", false)));
		sessionFactory.getCurrentSession().flush();
		return cri.list();
	}

	@Override
	public List<DfTopic> df_d_getAllDeletedTopic() {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfTopic.class);
		cri.add(Restrictions.eq("deletedFlag", true));
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DfTopic> getAllDeletedNonDeletedTopicList() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createCriteria(DfTopic.class).list();
	}	
}
