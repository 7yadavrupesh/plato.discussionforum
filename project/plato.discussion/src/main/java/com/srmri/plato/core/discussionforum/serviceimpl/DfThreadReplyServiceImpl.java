/**********************************************************************************
 * File-name - DfThreadReplyServiceImpl
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

import com.srmri.plato.core.discussionforum.dao.DfThreadReplyDao;
import com.srmri.plato.core.discussionforum.entity.DfThreadReply;
import com.srmri.plato.core.discussionforum.entity.DfTopic;
import com.srmri.plato.core.discussionforum.service.DfThreadReplyService;

@Service("threadReplyService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DfThreadReplyServiceImpl implements DfThreadReplyService{
	
	@Autowired
	private DfThreadReplyDao threadReplyDmo;
	
	/*
	 *  Method definition
	 *  Get Thread Reply List By Topic Id
	 */
	@Override
	public List<DfThreadReply> df_s_getThreadReplyList(Long threadId) {
		// TODO Auto-generated method stub
		return threadReplyDmo.df_d_getThreadReplyList(threadId);
	}

	/*
	 *  Method definition
	 *  Get Thread Reply List By Topic Object
	 */
	@Override
	public List<DfThreadReply> df_s_getThreadReplyList(DfTopic topic) {
		// TODO Auto-generated method stub
		return threadReplyDmo.df_d_getThreadReplyList(topic.getTopicId());
	}
	
	/*
	 *  Method definition
	 *  Insert New Reply
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean df_s_addThreadReply(Long userId, Long threadId, String text) {
		// TODO Auto-generated method stub
		DfThreadReply threadReply = new DfThreadReply();
		threadReply.setThreadId(threadId);
		threadReply.setReplyText(text);
		threadReply.setSubmittedUserid(userId);
		threadReply.setSubmittedTime(new java.sql.Timestamp(System.currentTimeMillis()));
		threadReplyDmo.df_d_insertNewReply(threadReply);
		return false;
	}

	/*
	 *  Method definition
	 *  Notify Respective User For New Reply
	 */
	@Override
	public boolean df_s_notifyUserNewReply(Long threadReplyId, Long threadId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean df_s_addThreadReply(DfThreadReply threadReply) {
		// TODO Auto-generated method stub
		threadReplyDmo.df_d_insertNewReply(threadReply);
		return false;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void df_s_deleteThreadReply(Long replyId) {
		// TODO Auto-generated method stub
		threadReplyDmo.df_d_deleteThreadReply(replyId);
	}
}
