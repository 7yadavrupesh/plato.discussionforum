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
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseDepartmentMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseDepartmentMap;

public class PcmCourseDepartmentMapDaoImpl implements PcmCourseDepartmentMapDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void dAddCourseDepartmentMap(PcmCourseDepartmentMap courseDepartmentMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(courseDepartmentMap);
		
	}
	
	@Override
	public PcmCourseDepartmentMap dGetCourseDepartmentMap(long courseDepartmentMapId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmCourseDepartmentMap) session.get(PcmCourseDepartmentMap.class, courseDepartmentMapId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmCourseDepartmentMap> dGetListOfAllCourseDepartmentMap() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmCourseDepartmentMap>) session.createCriteria(PcmCourseDepartmentMap.class).list();
	}

	@Override
	public void dDeleteCourseDepartmentMap(PcmCourseDepartmentMap courseDepartmentMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmcourseDepartmentMap WHERE courseDepartmentMapId = "+courseDepartmentMap.getCourseDepartmentMapId()).executeUpdate();
		
		
	}

	@Override
	public long dGetCourseDepartmentMapId(PcmCourseDepartmentMap courseDepartmentMap) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT courseDepartmentMapId FROM PcmCourseDepartmentMap WHERE courseDepartmentMapName ='"+courseDepartmentMap+"'").uniqueResult();
		
	}

}
