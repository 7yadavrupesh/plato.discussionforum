/**********************************************************************************
* File-name - UmDesignationDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Desigantion DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramLevelDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramLevel;

public class PcmProgramLevelDaoImpl implements PcmProgramLevelDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void dAddProgramLevel(PcmProgramLevel programLevel) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(programLevel);
		
	}

	@Override
	public PcmProgramLevel dGetProgramLevel(long programLevelId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmProgramLevel) session.get(PcmProgramLevel.class, programLevelId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmProgramLevel> dGetListOfAllProgramLevel() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmProgramLevel>) session.createCriteria(PcmProgramLevel.class).list();
	}

	@Override
	public void dDeleteProgramLevel(PcmProgramLevel programLevel) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmProgramLevel WHERE programLevelId = "+programLevel.getProgramLevelId()).executeUpdate();
	
	}

	@Override
	public long dGetProgramLevelId(PcmProgramLevel programLevel) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT programLevelId FROM PcmProgramLevel WHERE programLevelName ='"+programLevel+"'").uniqueResult();
		
	}

	

}
