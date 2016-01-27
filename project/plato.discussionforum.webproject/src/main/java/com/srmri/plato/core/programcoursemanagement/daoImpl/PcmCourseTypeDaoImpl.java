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
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseTypeDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseType;

public class PcmCourseTypeDaoImpl implements PcmCourseTypeDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void dAddCourseType(PcmCourseType courseType) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(courseType);
		
	}

	@Override
	public PcmCourseType dGetCourseType(long courseTypeId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmCourseType) session.get(PcmCourseType.class, courseTypeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmCourseType> dGetListOfAllCourseTypes() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmCourseType>) session.createCriteria(PcmCourseType.class).list();
	}

	@Override
	public void dDeleteCourseType(PcmCourseType courseType) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmcourseType WHERE courseTypeId = "+courseType.getCourseTypeId()).executeUpdate();
		
	}

	@Override
	public long dGetCourseTypeId(PcmCourseType courseType) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT courseTypeId FROM PcmcourseType WHERE courseTypeName ='"+courseType+"'").uniqueResult();
		
	}

}
