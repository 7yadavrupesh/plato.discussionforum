/**********************************************************************************
 * File-name - DfAttachedFileDaoImpl
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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srmri.plato.core.discussionforum.dao.DfAttachedFileDao;
import com.srmri.plato.core.discussionforum.dao.DfThreadFileMapDao;
import com.srmri.plato.core.discussionforum.entity.DfAttachedFile;
import com.srmri.plato.core.discussionforum.entity.DfThreadFileMap;
import com.srmri.plato.core.discussionforum.entity.DfThreadReplyFileMap;

@Repository("dfThreadFileMapDao")
public class DfThreadFileMapDaoImpl implements DfThreadFileMapDao{

	public DfThreadFileMapDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void df_d_addThreadFileMap(DfThreadFileMap threadFileMap) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(threadFileMap);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public void df_d_removeThreadFileMap(DfThreadFileMap threadFileMap) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(threadFileMap);
	}

	@Override
	public List<DfThreadFileMap> df_d_getTheadFileMapList(Long threadId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadFileMap.class);
		cri.add(Restrictions.eq("threadId", threadId));
		return cri.list();
	}

	@Override
	public List<Long> df_d_getFileList(Long threadId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadFileMap.class);
		cri.add(Restrictions.eq("threadId", threadId));
		List<DfThreadReplyFileMap> objList = cri.list();

		List<Long> fileIdList = new ArrayList<Long>();
		
		if(!objList.isEmpty() || objList != null )
		{
			for(DfThreadReplyFileMap obj: objList){
				fileIdList.add(obj.getFileId());
			}
		}
		return fileIdList;
	}

	@Override
	public DfThreadFileMap df_d_getThreadFileMap(Long fileId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadFileMap.class);
		cri.add(Restrictions.eq("fileId", fileId));
		if(cri.list().isEmpty())
			return null;
		else
			return (DfThreadFileMap) cri.list().get(0);
	}
}
