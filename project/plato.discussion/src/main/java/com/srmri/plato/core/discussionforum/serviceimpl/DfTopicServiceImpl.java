/**********************************************************************************
 * File-name - DfTopicServiceImpl
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
 ***********************************************************************************/

package com.srmri.plato.core.discussionforum.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.discussionforum.dao.DfThreadDao;
import com.srmri.plato.core.discussionforum.dao.DfTopicDao;
import com.srmri.plato.core.discussionforum.entity.*;

import com.srmri.plato.core.discussionforum.service.DfTopicService;

@Service("topicService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DfTopicServiceImpl implements DfTopicService{

	@Autowired
	private DfTopicDao topicDao;
	@Autowired
	private DfThreadDao threadDao;

	/*
	 *  Method definition
	 *  Insert New Topic 
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void df_s_insertTopic(DfTopic topic) {
		// TODO Auto-generated method stub
		topicDao.df_d_addTopic(topic);
	}

	/*
	 *  Method definition
	 *  Insert New Topic 
	 */	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean df_s_insertTopic(String topicTitle, Long createdUserid, Timestamp createdTime,
			boolean deleteFlag) {
		// TODO Auto-generated method stub

		DfTopic topic = new DfTopic();
		topic.setTopicTitle(topicTitle);
		topic.setCreatedTime(createdTime);
		topic.setCreatedUserid(createdUserid);
		topic.setDeletedFlag(deleteFlag);

		topicDao.df_d_addTopic(topic);
		return false;
	}

	/*
	 *  Method definition
	 *  Delete Given Topic
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean df_s_deleteTopic(Long topicId) {
		// TODO Auto-generated method stub
		
		topicDao.df_d_deteteTopic(topicId);
		
		List<DfThread> threadList = threadDao.df_d_getAllThreadList(topicId);

		if(threadList != null){
			for(int i=0;i<threadList.size(); i++){
				threadDao.df_d_deteteThread(threadList.get(i).getThreadId());
			}
		}
		
		return false;
	}

	/*
	 *  Method definition
	 *  Get Thread List Waiting For Approval
	 */
	@SuppressWarnings("null")
	@Override
	public List<DfThread> df_s_getThreadListWaitForApproval(Long userId) {
		//topicDaoImpl.getAllTopicList(userId);
		// TODO Auto-generated method stub
		List<DfTopic> topicLIst = topicDao.df_d_getTopicUserActModerator(userId);
		Iterator<DfTopic> it = topicLIst.iterator();
		List<DfThread> threadList = null;
		while(it.hasNext()){
			DfTopic topic = (DfTopic) it.next();
			threadList.addAll(threadDao.df_d_getAllUnApprovedThreadList());
		}
		return threadList;
	}

	@Override
	public List<DfTopic> df_s_getAllTopicList() {
		// TODO Auto-generated method stub
		return topicDao.df_d_getAllTopicList();
	}

	@Override
	public DfTopic df_s_getTopic(Long topicId){
		return topicDao.df_d_getTopic(topicId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void df_s_UndoDeletedTopic(Long topicId) {
		// TODO Auto-generated method stub
		DfTopic topic = topicDao.df_d_getTopic(topicId);
		topic.setDeletedFlag(false);
		List<DfThread> threadList = threadDao.df_d_getAllDeletedThreadList(topicId);
		
		if(threadList!=null){
			for(DfThread thread: threadList){
				thread.setDeletedFlag(false);
				threadDao.df_d_addThread(thread);
			}
		}
	}

	@Override
	public List<DfTopic> df_s_getDeletedTopic(Long userId) {
		// TODO Auto-generated method stub
		List<DfTopic> allTopicList = topicDao.df_d_getTopicUserActModerator(userId);
		List<DfTopic> deletedTopicList = new ArrayList<DfTopic>();
		
		for(int i=0;i<allTopicList.size();i++){
			DfTopic topic = allTopicList.get(i);
			if(topic.getDeletedFlag() == true){
				//System.out.println("entering for adding");
				deletedTopicList.add(topic);
			}
		}
		return deletedTopicList;
	}

	@Override
	public List<DfTopic> df_s_getTopicList(Long userId) {
		// TODO Auto-generated method stub
		return topicDao.df_d_getTopicList(userId);
	}

	@Override
	public List<DfTopic> df_s_getAllDeletedTopic() {
		// TODO Auto-generated method stub
		return topicDao.df_d_getAllDeletedTopic();
	}

	@Override
	public List<DfTopic> df_s_getAllDeletedNonDeletedTopicList() {
		// TODO Auto-generated method stub
		return topicDao.getAllDeletedNonDeletedTopicList();
	}

	@Override
	public List<DfTopic> df_s_getAllUnApprovedTopics() {
		// TODO Auto-generated method stub
		return topicDao.df_d_getAllUnApprovedTopics();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void df_s_approveTopic(Long topic_id) {
		// TODO Auto-generated method stub
		topicDao.df_d_approveTopic(topic_id);
	}
}
