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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramSemesterElectiveDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramSemesterElectives;

public class PcmProgramSemesterElectiveDaoImpl implements PcmProgramSemesterElectiveDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void dAddProgramSemesterElectives(PcmProgramSemesterElectives programSemesterElective) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(programSemesterElective);
		
	}

	@Override
	public PcmProgramSemesterElectives dGetProgramSemesterElectives(long programSemesterElectiveId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmProgramSemesterElectives) session.get(PcmProgramSemesterElectives.class, programSemesterElectiveId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmProgramSemesterElectives> dGetListOfAllProgramSemesterElectives() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmProgramSemesterElectives>) session.createCriteria(PcmProgramSemesterElectives.class).list();
	}

	@Override
	public void dDeleteProgramSemesterElectives(PcmProgramSemesterElectives programSemesterElective) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmProgramSemesterElectives WHERE programSemesterElectiveId = "+programSemesterElective.getProgramSemesterElectiveId()).executeUpdate();
	
	}

	@Override
	public long dGetProgramSemesterElectivesId(PcmProgramSemesterElectives programSemesterElective) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT programSemesterElectiveId FROM PcmProgramSemesterElectives WHERE programSemesterElectiveName ='"+programSemesterElective+"'").uniqueResult();
		
	}

}
