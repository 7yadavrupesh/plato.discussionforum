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
	public boolean df_s_newThreadCreate(Long topicId, Long createdUserId, String title, String description, 
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
		
		threadDao.df_d_addThread(thread);
		return false;
	}
	/*
	 *  Method definition
	 *  Create New Thread
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean df_s_addThread(DfThread thread) {
		// TODO Auto-generated method stub

		
		threadDao.df_d_addThread(thread);
		return false;
	}
	
	/*
	 *  Method definition
	 *  Delete Thread Using Thread Id
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean df_s_deleteThread(Long threadId) {
		// TODO Auto-generated method stub
		threadDao.df_d_deteteThread(threadId);
		return false;
	}
	
	/*
	 *  Method definition
	 *  Delete Thread Using Thread Object
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean df_s_deleteThread(DfThread thread) {
		// TODO Auto-generated method stub
		threadDao.df_d_deteteThread(thread);
		return false;
	}

	/*
	 *  Method definition
	 *  Change Visibility
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean df_s_changeVisibilityThread(DfThread thread, boolean flag) {
		// TODO Auto-generated method stub
		thread.setApproved(flag);
		return false;
	}

	/*
	 *  Method definition
	 *  Get all threads comes under given thread using thread object
	 */
	@Override
	public List<DfThread> df_s_getTopicThreads(DfTopic topic) {
		// TODO Auto-generated method stub
		return threadDao.df_d_getAllThreadList(topic);
	}
	
	/*
	 *  Method definition
	 *  Get all threads comes under given thread using thread id
	 */

	@Override
	public List<DfThread> df_s_getTopicThreads(Long topicId) {
		// TODO Auto-generated method stub
		return threadDao.df_d_getAllThreadList(topicId);
	}

	/*
	 *  Method definition
	 *  Approve Thread
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean df_s_approveThread(Long threadId, boolean approveFlag) {
		// TODO Auto-generated method stub
		threadDao.df_d_approveThread(threadId, approveFlag);
		return true;
	}
	
	@Override
	public List<DfThread> df_s_getAllThreadList() {
		// TODO Auto-generated method stub
		return threadDao.df_d_getAllThreadList();
	}

	@Override
	public DfThread df_s_getThread(Long threadId) {
		// TODO Auto-generated method stub
		return threadDao.df_d_getThread(threadId);
	}
	@Override
	public List<DfThread> df_s_getAllUnApprovedThreadList() {
		// TODO Auto-generated method stub
		return threadDao.df_d_getAllUnApprovedThreadList();
	}
	@Override
	public List<DfThread> df_s_getDeletedThreadList(Long UserId) {
		// TODO Auto-generated method stub
		return threadDao.df_d_getDeletedThreadList(UserId);
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void df_s_undoDeletedThread(Long thread_id) {
		// TODO Auto-generated method stub
		threadDao.df_d_undoDeletedThread(thread_id);
	}
	
	@Override
	public List<DfThread> df_s_getAllDeletedThreadList(Long topicId){
		return threadDao.df_d_getAllDeletedThreadList(topicId);
	}
	
	@Override
	public List<DfThread> df_s_getAllDeletedThreadList(){
		return threadDao.df_d_getAllDeletedThreadList();
	}
}
