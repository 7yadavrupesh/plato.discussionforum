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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseCreditsDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseCredits;

public class PcmCourseCreditsDaoImpl implements PcmCourseCreditsDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void dAddCourseCredit(PcmCourseCredits courseCredit) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(courseCredit);
		
	}
	
	@Override
	public PcmCourseCredits dGetCourseCredit(long courseCreditId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmCourseCredits) session.get(PcmCourseCredits.class, courseCreditId);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmCourseCredits> dGetListOfAllCourseCredits() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmCourseCredits>) session.createCriteria(PcmCourseCredits.class).list();
	}

	@Override
	public void dDeleteCourseCredit(PcmCourseCredits courseCredits) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmCourseCredits WHERE courseCreditId = "+courseCredits.getCourseCreditId()).executeUpdate();
		
		
	}

	@Override
	public long dGetCourseCreditId(PcmCourseCredits courseCredit) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT courseCreditId FROM PcmCourseCredits WHERE courseCredit ='"+courseCredit+"'").uniqueResult();
		
	}
	
	
	

}
