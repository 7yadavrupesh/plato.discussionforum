/**********************************************************************************
* File-name - PcmStudentElectiveDaoImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: StudentElective DAO interface impl
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmStudentElectivesDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmStudentElectives;

public class PcmStudentElectiveDaoImpl implements PcmStudentElectivesDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void dAddStudentElectives(PcmStudentElectives studentElective) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(studentElective);
		
	}

	@Override
	public PcmStudentElectives dGetStudentElectives(long studentElectiveId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmStudentElectives) session.get(PcmStudentElectives.class, studentElectiveId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmStudentElectives> dGetListOfAllStudentElectives() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmStudentElectives>) session.createCriteria(PcmStudentElectives.class).list();
	}

	@Override
	public void dDeleteStudentElectives(PcmStudentElectives studentElective) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmStudentElectives WHERE studentElectiveId = "+studentElective.getStudentElectiveId()).executeUpdate();
	
	}

	@Override
	public long dGetStudentElectivesId(PcmStudentElectives studentElective) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT studentElectiveId FROM PcmStudentElective WHERE studentElectiveName ='"+studentElective+"'").uniqueResult();
		
	}

}
