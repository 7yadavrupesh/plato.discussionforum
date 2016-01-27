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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmStudentCoursesDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmStudentCourses;

public class PcmStudentCourseDaoImpl implements PcmStudentCoursesDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void dAddStudentCourses(PcmStudentCourses studentCourse) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(studentCourse);
		
	}

	@Override
	public PcmStudentCourses dGetStudentCourses(long studentCourseId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmStudentCourses) session.get(PcmStudentCourses.class, studentCourseId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmStudentCourses> dGetListOfAllStudentCourses() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmStudentCourses>) session.createCriteria(PcmStudentCourses.class).list();
	}

	@Override
	public void dDeleteStudentCourses(PcmStudentCourses studentCourse) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmStudentCourses WHERE studentCourseId = "+studentCourse.getStudentCourseId()).executeUpdate();
	
		
	}

	@Override
	public long dGetStudentCoursesId(PcmStudentCourses studentCourse) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT studentCourseId FROM PcmStudentCourse WHERE studentCourseName ='"+studentCourse+"'").uniqueResult();
		
	}
}
