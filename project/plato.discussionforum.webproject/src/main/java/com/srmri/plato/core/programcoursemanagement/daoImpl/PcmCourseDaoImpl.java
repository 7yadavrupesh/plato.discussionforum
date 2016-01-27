/**********************************************************************************
* File-name - PcmCourseDaoImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Course DAO interface impl
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourses;



public class PcmCourseDaoImpl implements PcmCourseDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public void dAddCourse(PcmCourses course) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(course);
	}

	@Override
	public PcmCourses dGetCourse(long courseId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmCourses) session.get(PcmCourses.class, courseId);	
	}
	
	@Override
	public PcmCourses dGetCourse(String courseCode) 
	{
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(PcmCourses.class);
		cr.add(Restrictions.eq("courseCode", courseCode));
		cr.setMaxResults(1);
		return (PcmCourses) cr.uniqueResult();	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmCourses> dGetListOfAllCourses() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmCourses>) session.createCriteria(PcmCourses.class).list();
	}

	@Override
	public void dDeleteCourse(PcmCourses course) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmCourses WHERE courseId = "+course.getCourseId()).executeUpdate();
		
		
	}

	@Override
	public long dGetCourseId(PcmCourses course) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT courseId FROM PcmCourses WHERE courseName ='"+course.getCourseName()+"'").uniqueResult();
		
	}

	

}
