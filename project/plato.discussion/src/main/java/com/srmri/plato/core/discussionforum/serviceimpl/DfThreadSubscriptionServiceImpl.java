/**********************************************************************************
 * File-name - DfThreadSubscriptionServiceImpl
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.discussionforum.dao.DfThreadSubscriptionDao;
import com.srmri.plato.core.discussionforum.entity.DfThreadSubscription;
import com.srmri.plato.core.discussionforum.service.DfThreadSubscriptionService;

@Service("threadSubscriptionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DfThreadSubscriptionServiceImpl implements DfThreadSubscriptionService{
	
	@Autowired
	private DfThreadSubscriptionDao threadSubscriptionDao;
	
	public DfThreadSubscriptionServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *  Method definition
	 *  Set Thread Follow
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void dfSAddThreadSubscription(Long threadId, Long userId) {
		// TODO Auto-generated method stub
		DfThreadSubscription sbs = new DfThreadSubscription();
		java.util.Date date = new java.util.Date();
		
		Timestamp subscriptionTime = new Timestamp(date.getTime());
		sbs.setSubscriptionTime(subscriptionTime);
		sbs.setThreadId(threadId);
		sbs.setSubscriptionUserid(userId);
		threadSubscriptionDao.dfDAddSubscription(sbs);
	}

	@Override
	public void dfSRemoveThreadSubscription(Long threadId, Long userId) {
		// TODO Auto-generated method stub
		threadSubscriptionDao.dfDRemoveSubscription(threadId, userId);
	}

	@Override
	public boolean dfSIsSubscribed(Long thread_id, Long loginUserId) {
		// TODO Auto-generated method stub
		return threadSubscriptionDao.dfDIsSubscribed(thread_id,loginUserId);
	}
}
