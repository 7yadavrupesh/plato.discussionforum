/**********************************************************************************
 * File-name - DfThreadServieImpl
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
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.discussionforum.dao.DfThreadDao;
import com.srmri.plato.core.discussionforum.entity.DfThread;
import com.srmri.plato.core.discussionforum.entity.DfTopic;
import com.srmri.plato.core.discussionforum.service.DfThreadService;

@Service("threadService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DfThreadServieImpl implements DfThreadService{

	@Autowired
	private DfThreadDao threadDao;
	
	/*
	 *  Method definition
	 *  Create New Thread
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean dfSNewThreadCreate(Long topicId, Long createdUserId, String title, String description, 
			Long uploadedFile) {
		// TODO Auto-generated method stub
		
		//DfAttachedFile file = new DfAttachedFile();
		//Long uploadedFileId;
		boolean approved = false;
		boolean deletedFlag = false;
		Timestamp createdTime  = new Timestamp(System.currentTimeMillis());
		Timestamp modifiedTime = new Timestamp(System.currentTimeMillis());
		//Timestamp modifiedTime = new Timestamp(date.getTime());
		
//		file.setFileName(uploadedFile.getName());
//		file.setFileLocation(uploadedFile.getAbsolutePath());
//		file.setFileSize(uploadedFile.getTotalSpace());
		
		//uploadedFileId = fileDao.df_d_addAttachedFile(file);
		
		DfThread thread = new DfThread(createdUserId, createdTime, modifiedTime, topicId,
				title, description, approved, deletedFlag);
		
		threadDao.dfDAddThread(thread);
		return false;
	}
	/*
	 *  Method definition
	 *  Create New Thread
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean dfSAddThread(DfThread thread) {
		// TODO Auto-generated method stub

		
		threadDao.dfDAddThread(thread);
		return false;
	}
	
	/*
	 *  Method definition
	 *  Delete Thread Using Thread Id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean dfSDeleteThread(Long threadId) {
		// TODO Auto-generated method stub
		threadDao.dfDDeteteThread(threadId);
		return false;
	}
	
	/*
	 *  Method definition
	 *  Delete Thread Using Thread Object
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean dfSDeleteThread(DfThread thread) {
		// TODO Auto-generated method stub
		threadDao.dfDDeteteThread(thread);
		return false;
	}

	/*
	 *  Method definition
	 *  Change Visibility
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean dfSChangeVisibilityThread(DfThread thread, boolean flag) {
		// TODO Auto-generated method stub
		thread.setApproved(flag);
		return false;
	}

	/*
	 *  Method definition
	 *  Get all threads comes under given thread using thread object
	 */
	@Override
	public List<DfThread> dfSGetTopicThreads(DfTopic topic) {
		// TODO Auto-generated method stub
		return threadDao.dfDGetAllThreadList(topic);
	}
	
	/*
	 *  Method definition
	 *  Get all threads comes under given thread using thread id
	 */

	@Override
	public List<DfThread> dfSGetTopicThreads(Long topicId) {
		// TODO Auto-generated method stub
		return threadDao.dfDGetAllThreadList(topicId);
	}

	/*
	 *  Method definition
	 *  Approve Thread
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean dfSApproveThread(Long threadId, boolean approveFlag) {
		// TODO Auto-generated method stub
		threadDao.dfDApproveThread(threadId, approveFlag);
		return true;
	}
	
	@Override
	public List<DfThread> dfSGetAllThreadList() {
		// TODO Auto-generated method stub
		return threadDao.dfDGetAllThreadList();
	}

	@Override
	public DfThread dfSGetThread(Long threadId) {
		// TODO Auto-generated method stub
		return threadDao.dfDGetThread(threadId);
	}
	@Override
	public List<DfThread> dfSGetAllUnApprovedThreadList() {
		// TODO Auto-generated method stub
		return threadDao.dfDGetAllUnApprovedThreadList();
	}
	@Override
	public List<DfThread> dfSGetDeletedThreadList(Long UserId) {
		// TODO Auto-generated method stub
		return threadDao.dfDGetDeletedThreadList(UserId);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void dfSUndoDeletedThread(Long thread_id) {
		// TODO Auto-generated method stub
		threadDao.dfDUndoDeletedThread(thread_id);
	}
	
	@Override
	public List<DfThread> dfSGetAllDeletedThreadList(Long topicId){
		return threadDao.dfDGetAllDeletedThreadList(topicId);
	}
	
	@Override
	public List<DfThread> dfSGetAllDeletedThreadList(){
		return threadDao.dfDGetAllDeletedThreadList();
	}
	@Override
	public List<DfThread> dfSGetAllThreadListUser(Long userId) {
		// TODO Auto-generated method stub
		return threadDao.dfDGetAllThreadListUser(userId);
	}
	@Override
	public List<DfThread> dfSGetAllThreadApprovedByUser(Long userId) {
		// TODO Auto-generated method stub
		return threadDao.dfDGetAllThreadApprovedByUser(userId);
	}
}
