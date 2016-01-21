/**********************************************************************************
 * File-name - DfThreadDaoImpl
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

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srmri.plato.core.discussionforum.dao.*;
import com.srmri.plato.core.discussionforum.entity.DfThread;
import com.srmri.plato.core.discussionforum.entity.DfTopic;

@Repository("dfThreadDao")
public class DfThreadDaoImpl implements DfThreadDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public DfThreadDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *  Method definition
	 *  Add Thread
	 */
	public void dfDAddThread(DfThread thread){
		System.out.println("df_d_addThread IN");
		sessionFactory.getCurrentSession().saveOrUpdate(thread);
		sessionFactory.getCurrentSession().flush();
		System.out.println("df_d_addThread IN");
	}
	
	/*
	 *  Method definition
	 *  Delete Thread using thread id
	 */
	public void dfDDeteteThread(Long threadId){
		DfThread thread = new DfThread();
		thread = (DfThread) sessionFactory.getCurrentSession().get(DfThread.class, threadId);
		thread.setDeletedFlag(true);
		sessionFactory.getCurrentSession().flush();
	}
	
	/*
	 *  Method definition
	 *  Delete Thread using Thread Object
	 */
	public void dfDDeteteThread(DfThread thread){
		sessionFactory.getCurrentSession().delete(thread);
	}
	
	/*
	 *  Method definition
	 *  Update Thread
	 */
	public void dfDUpdateThread(DfThread thread){
		sessionFactory.getCurrentSession().saveOrUpdate(thread);
	}
	
	/*
	 *  Method definition
	 *  Get All Thread List Using Topic Object
	 */
	@SuppressWarnings("unchecked")
	public List<DfThread> dfDGetAllThreadList(DfTopic topic){
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);
		cri.add(Restrictions.and(Restrictions.eq("topicId", topic.getTopicId()),Restrictions.eq("deletedFlag", false)));
		cri.add(Restrictions.eq("approved", true));
		return (List<DfThread>) cri.list();
	}

	/*
	 *  Method definition
	 *  Get All Thread List Using Topic Id
	 */
	@SuppressWarnings("unchecked")
	public List<DfThread> dfDGetAllThreadList(Long topicId){
		
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);

		cri.add(Restrictions.and(Restrictions.eq("approved", true),Restrictions.eq("topicId", topicId)));
		cri.add(Restrictions.eq("deletedFlag", false));
		List<DfThread> threadList =  cri.list();
		return threadList;
	}
	
	@SuppressWarnings("unchecked")
	public List<DfThread> dfDGetAllThreadList(){
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);
		cri.add(Restrictions.and(Restrictions.eq("deletedFlag", false),Restrictions.eq("approved", true)));
		return cri.list();
	}
	/*
	 *  Method definition
	 *  Get Thread Details
	 */
	public String dfDGetThreadDetail(Long threadId){
	 Criteria cri =	sessionFactory.getCurrentSession().createCriteria(DfThread.class);
	 cri.add(Restrictions.eq("threadId", threadId));
	 @SuppressWarnings("unchecked")
	List<DfThread> result = cri.list();
	 Iterator<DfThread> iterator = result.iterator();
	 DfThread obj = (DfThread) iterator.next();
	 return obj.getDescription();
	}
	
	// left for implementation its dependent on sujata's module UM
//	public void df_d_notifyModeratorNewThread(Long threadId, Long topicId){
//		DfModeratorAssignedDaoImpl mod = new DfModeratorAssignedDaoImpl();
//		List<Long> modList = mod.getModeratorList(topicId);
//		for(Iterator it = modList.iterator(); it.hasNext();){
//			Long modId = (Long)it.next();
//		}
//	}

	/*
	 *  Method definition
	 *  Approve Thread
	 */
	@Override
	public void dfDApproveThread(Long threadId, boolean approveFlag) {
		// TODO Auto-generated method stub
		DfThread thread = new DfThread();
		thread  = (DfThread)sessionFactory.getCurrentSession().get(DfThread.class, threadId);
		thread.setApproved(true);
		//thread.setApproved(approveFlag);
	}

	/*
	 *  Method definition
	 *  Get UnApproved Thread
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DfThread> dfDGetAllUnApprovedThreadList() {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);
		cri.add(Restrictions.and(Restrictions.eq("approved", false),Restrictions.eq("deletedFlag", false)));
		return cri.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DfThread dfDGetThread(Long threadId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);
		List<DfThread> tlist = cri.add(Restrictions.eq("threadId", threadId)).list();
		if(tlist.isEmpty())
			return null;
		else
			return tlist.get(0);
	}

	@Override
	public List<DfThread> dfDGetDeletedThreadList(Long userId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);
		@SuppressWarnings("unchecked")
		List<DfThread> tlist = cri.add(Restrictions.and(
				Restrictions.eq("createdUserid", userId),
				Restrictions.eq("deletedFlag", true))).list();
		
		return tlist;
	}

	@Override
	public void dfDUndoDeletedThread(Long thread_id) {
		// TODO Auto-generated method stub
		DfThread thread = new DfThread();
		thread  = (DfThread)sessionFactory.getCurrentSession().get(DfThread.class, thread_id);
		thread.setDeletedFlag(false);
	}
	
	public List<DfThread> dfDGetAllDeletedThreadList(Long topicId){
		
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);
		cri.add(Restrictions.and(Restrictions.eq("deletedFlag", true),Restrictions.eq("topicId", topicId)));
		List<DfThread> threadList =  cri.list();

		if(threadList.isEmpty()){
			return null;
		}
		else{
			return threadList;
		}
	}

	@Override
	public List<DfThread> dfDGetAllDeletedThreadList() {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);
		cri.add(Restrictions.eq("deletedFlag",true));
		return cri.list();
	}

	@Override
	public List<DfThread> dfDGetAllThreadListUser(Long userId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);
		cri.add(Restrictions.eq("createdUserid",userId));
		cri.add(Restrictions.eq("deletedFlag",false));
		return cri.list();
	}

	@Override
	public List<DfThread> dfDGetAllThreadApprovedByUser(Long userId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThread.class);
		cri.add(Restrictions.eq("approvedBy",userId));
		cri.add(Restrictions.eq("deletedFlag",false));
		return cri.list();
	}
}
