/**********************************************************************************
 * File-name - DfThreadReplyDaoImpl
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

import com.srmri.plato.core.discussionforum.dao.DfThreadReplyDao;
import com.srmri.plato.core.discussionforum.entity.DfThreadReply;

@Repository("dfThreadReplyDao")
public class DfThreadReplyDaoImpl implements DfThreadReplyDao{

	@Autowired
	private SessionFactory sessionFactory;

	public DfThreadReplyDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 *  Method definition
	 *  Insert New Reply
	 */
	@Override
	public void dfDInsertNewReply(DfThreadReply threadReply) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(threadReply);
		sessionFactory.getCurrentSession().flush();
	}

	/*
	 *  Method definition
	 *  Get Reply Detail
	 */
	@Override
	public DfThreadReply dfDGetReplyDetail(Long replyId) {
		// TODO Auto-generated method stub
		return (DfThreadReply)sessionFactory.getCurrentSession().get(DfThreadReply.class,replyId);
	}

	/*
	 *  Method definition
	 *  Get Thread Reply List
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<DfThreadReply> dfDGetThreadReplyList(Long threadId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadReply.class);
		return cri.add(Restrictions.and(Restrictions.eq("threadId", threadId),Restrictions.eq("deletedFlag", false))).list();
	}

	/*
	 *  Method definition
	 *  Delete Thread Reply
	 */
	@Override
	public void dfDDeleteThreadReply(Long replyId) {
		// TODO Auto-generated method stub
		DfThreadReply tr = (DfThreadReply) sessionFactory.getCurrentSession().get(DfThreadReply.class,replyId);
		tr.setDeleteFlag(true);
	}

}
