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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmElectiveCoursesDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmElectiveCourses;

public class PcmElectiveCoursesDaoImpl implements PcmElectiveCoursesDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void dAddelectiveCourse(PcmElectiveCourses electiveCourse) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(electiveCourse);
		
	}

	@Override
	public PcmElectiveCourses dGetElectiveCourse(long electiveCourseId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmElectiveCourses) session.get(PcmElectiveCourses.class, electiveCourseId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmElectiveCourses> dGetListOfAllElectiveCourse() 
	{

		Session session=sessionFactory.getCurrentSession();
		return (List<PcmElectiveCourses>) session.createCriteria(PcmElectiveCourses.class).list();
	}

	@Override
	public void dDeleteElectiveCourse(PcmElectiveCourses electiveCourse) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmElectiveCourses WHERE electiveCourseId = "+electiveCourse.getElectiveCourseId()).executeUpdate();
		
		
	}

	@Override
	public long dGetElectiveCourseId(PcmElectiveCourses electiveCourse) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT electiveCourseId FROM PcmElectiveCourses WHERE electiveCourseName ='"+electiveCourse+"'").uniqueResult();
		
	}

}
