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
	public void dfSInsertTopic(DfTopic topic) {
		// TODO Auto-generated method stub
		topicDao.dfDAddTopic(topic);
	}

	/*
	 *  Method definition
	 *  Insert New Topic 
	 */	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean dfSInsertTopic(String topicTitle, Long createdUserid, Timestamp createdTime,
			boolean deleteFlag) {
		// TODO Auto-generated method stub

		DfTopic topic = new DfTopic();
		topic.setTopicTitle(topicTitle);
		topic.setCreatedTime(createdTime);
		topic.setCreatedUserid(createdUserid);
		topic.setDeletedFlag(deleteFlag);

		topicDao.dfDAddTopic(topic);
		return false;
	}

	/*
	 *  Method definition
	 *  Delete Given Topic
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean dfSDeleteTopic(Long topicId) {
		// TODO Auto-generated method stub
		
		topicDao.dfDDeteteTopic(topicId);
		
		List<DfThread> threadList = threadDao.dfDGetAllThreadList(topicId);

		if(threadList != null){
			for(int i=0;i<threadList.size(); i++){
				threadDao.dfDDeteteThread(threadList.get(i).getThreadId());
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
	public List<DfThread> dfSGetThreadListWaitForApproval(Long userId) {
		//topicDaoImpl.getAllTopicList(userId);
		// TODO Auto-generated method stub
		List<DfTopic> topicLIst = topicDao.dfDGetTopicUserActModerator(userId);
		Iterator<DfTopic> it = topicLIst.iterator();
		List<DfThread> threadList = null;
		while(it.hasNext()){
			DfTopic topic = (DfTopic) it.next();
			threadList.addAll(threadDao.dfDGetAllUnApprovedThreadList());
		}
		return threadList;
	}

	@Override
	public List<DfTopic> dfSGetAllTopicList() {
		// TODO Auto-generated method stub
		return topicDao.dfDGetAllTopicList();
	}

	@Override
	public DfTopic dfSGetTopic(Long topicId){
		return topicDao.dfDGetTopic(topicId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void dfSUndoDeletedTopic(Long topicId) {
		// TODO Auto-generated method stub
		DfTopic topic = topicDao.dfDGetTopic(topicId);
		topic.setDeletedFlag(false);
		List<DfThread> threadList = threadDao.dfDGetAllDeletedThreadList(topicId);
		
		if(threadList!=null){
			for(DfThread thread: threadList){
				thread.setDeletedFlag(false);
				threadDao.dfDAddThread(thread);
			}
		}
	}

	@Override
	public List<DfTopic> dfSGetDeletedTopic(Long userId) {
		// TODO Auto-generated method stub
		List<DfTopic> allTopicList = topicDao.dfDGetTopicUserActModerator(userId);
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
	public List<DfTopic> dfSGetTopicList(Long userId) {
		// TODO Auto-generated method stub
		return topicDao.dfDGetTopicList(userId);
	}

	@Override
	public List<DfTopic> dfSGetAllDeletedTopic() {
		// TODO Auto-generated method stub
		return topicDao.dfDGetAllDeletedTopic();
	}

	@Override
	public List<DfTopic> dfSGetAllDeletedNonDeletedTopicList() {
		// TODO Auto-generated method stub
		return topicDao.dfDGetAllDeletedNonDeletedTopicList();
	}

	@Override
	public List<DfTopic> dfSGetAllUnApprovedTopics() {
		// TODO Auto-generated method stub
		return topicDao.dfDGetAllUnApprovedTopics();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void dfSApproveTopic(Long topic_id) {
		// TODO Auto-generated method stub
		topicDao.dfDApproveTopic(topic_id);
	}

	@Override
	public List<DfTopic> dfSGetTopicList() {
		// TODO Auto-generated method stub
		topicDao.dfDGetTopicList();
		return null;
	}

	@Override
	public List<DfTopic> dfSGetAllTopicsApprovedByUser(Long userId) {
		// TODO Auto-generated method stub
		return topicDao.dfDGetAllTopicsApprovedByUser(userId);
	}

	@Override
	public List<DfTopic> dfSGetAllApprovedNonApprovedTopicListByUser(Long createdUserid) {
		// TODO Auto-generated method stub
		
		return topicDao.dfSGetAllApprovedNonApprovedTopicListByUser(createdUserid);
	}
}
