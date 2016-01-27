/**********************************************************************************
* File-name - UmStudentDaoImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Student DAO implementation
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.daoImpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.srmri.plato.core.usermanagement.dao.UmStudentDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmStudent;


@Repository("UmStudentDao")
public class UmStudentDaoImpl implements UmStudentDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void dAddStudent(UmStudent student)
	{
		Session session=sessionFactory.getCurrentSession();

		session.saveOrUpdate(student);
		
	}
	
	public UmStudent dGetStudent(long studentId)
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (UmStudent) session.get(UmStudent.class, studentId);	
	}

	@SuppressWarnings("unchecked")
	public List<UmStudent> dGetListOfAllStudents()
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (List<UmStudent>) session.createCriteria(UmStudent.class).list();
	}
	
	public void dDeleteStudent(UmStudent student)
	{
		
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM um_student WHERE student_id = "+student.getStudentId()).executeUpdate();
	}
}
