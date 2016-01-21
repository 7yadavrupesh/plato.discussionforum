/**********************************************************************************
 * File-name - DfThreadSubscriptionDoaImpl
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

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srmri.plato.core.discussionforum.dao.DfThreadSubscriptionDao;
import com.srmri.plato.core.discussionforum.entity.DfThreadSubscription;

@Repository("dfThreadSubscriptionDao")
public class DfThreadSubscriptionDoaImpl implements DfThreadSubscriptionDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public DfThreadSubscriptionDoaImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *  Method definition
	 *  Add Subscription
	 */
	@Override
	public void dfDAddSubscription(DfThreadSubscription sbs) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(sbs);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 *  Method definition
	 *  Remove Subscription
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void dfDRemoveSubscription(Long threadId, Long userId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadSubscription.class);
		cri.add(Restrictions.and(
					Restrictions.eq("threadId", threadId), 
					Restrictions.eq("subscriptionUserid", userId))
				);
		List<DfThreadSubscription> sblist = cri.list();
		for (DfThreadSubscription dfThreadSubscription : sblist) {
			sessionFactory.getCurrentSession().delete(dfThreadSubscription);
			sessionFactory.getCurrentSession().flush();
		}
	}

	/*
	 *  Method definition
	 *  Get Thread Subscri
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DfThreadSubscription> dfDGetThreadSubscriberList() {
		// TODO Auto-generated method stub
		return (List<DfThreadSubscription>) sessionFactory.getCurrentSession().createCriteria(DfThreadSubscription.class).list();
	}

	@Override
	public boolean dfDIsSubscribed(Long thread_id, Long loginUserId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadSubscription.class);
		cri.add(Restrictions.and(Restrictions.eq("threadId", thread_id), Restrictions.eq("subscriptionUserid", loginUserId)));
		
		if(cri.list().isEmpty())
			return false;
		else
			return true;
	}
}
