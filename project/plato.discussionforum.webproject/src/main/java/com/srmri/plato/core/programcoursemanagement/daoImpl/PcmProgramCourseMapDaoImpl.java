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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramCourseMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramCourseMap;

public class PcmProgramCourseMapDaoImpl implements PcmProgramCourseMapDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void dAddProgramCourseMap(PcmProgramCourseMap programCourseMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(programCourseMap);
		
	}

	@Override
	public PcmProgramCourseMap dGetProgramCourseMap(long programCourseMapId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmProgramCourseMap) session.get(PcmProgramCourseMap.class, programCourseMapId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmProgramCourseMap> dGetListOfAllProgramCourseMap() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmProgramCourseMap>) session.createCriteria(PcmProgramCourseMap.class).list();
	}

	@Override
	public void dDeleteProgramCourseMap(PcmProgramCourseMap programCourseMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmProgramCourseMap WHERE programCourseMapId = "+programCourseMap.getProgramCourseMapId()).executeUpdate();
		
		
	}

	@Override
	public long dGetProgramCourseMapId(PcmProgramCourseMap programCourseMap) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT programCourseMapId FROM PcmProgramCourseMap WHERE programCourseMapName ='"+programCourseMap+"'").uniqueResult();
		
	}

}
