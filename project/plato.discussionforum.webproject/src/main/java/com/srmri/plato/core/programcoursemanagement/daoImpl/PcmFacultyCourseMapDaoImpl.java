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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmFacultyCourseMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmFacultyCourseMap;

public class PcmFacultyCourseMapDaoImpl implements PcmFacultyCourseMapDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void dAddFacultyCourseMap(PcmFacultyCourseMap facultyCourseMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(facultyCourseMap);
		
	}

	@Override
	public PcmFacultyCourseMap dGetFacultyCourseMap(long facultyCourseMapId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmFacultyCourseMap) session.get(PcmFacultyCourseMap.class, facultyCourseMapId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmFacultyCourseMap> dGetListOfAllFacultyCourseMap() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmFacultyCourseMap>) session.createCriteria(PcmFacultyCourseMap.class).list();
	}

	@Override
	public void dDeleteFacultyCourseMap(PcmFacultyCourseMap facultyCourseMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmFacultyCourseMap WHERE facultyCourseMapId = "+facultyCourseMap.getFacultyCourseMapId()).executeUpdate();
		
	}

	@Override
	public long dGetFacultyCourseMapId(PcmFacultyCourseMap facultyCourseMap) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT facultyCourseMapId FROM PcmFacultyCourseMap WHERE facultyCourseMapName ='"+facultyCourseMap+"'").uniqueResult();
		
	}

}
