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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramSemesterYearDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramSemesterYear;

public class PcmProgramSemesterYearDaoImpl implements PcmProgramSemesterYearDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void dAddProgramSemesterYear(PcmProgramSemesterYear programSemesterYear) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(programSemesterYear);
	}

	@Override
	public PcmProgramSemesterYear dGetProgramSemesterYear(long programSemesterYearId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmProgramSemesterYear) session.get(PcmProgramSemesterYear.class, programSemesterYearId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmProgramSemesterYear> dGetListOfAllProgramSemesterYear() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmProgramSemesterYear>) session.createCriteria(PcmProgramSemesterYear.class).list();
	}

	@Override
	public void dDeleteProgramSemesterYear(PcmProgramSemesterYear programSemesterYear) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmProgramSemesterYear WHERE programSemesterYearId = "+programSemesterYear.getProgramSemesterYearId()).executeUpdate();
	
		
	}

	@Override
	public long dGetProgramSemesterYearId(PcmProgramSemesterYear programSemesterYear) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT programSemesterYearId FROM PcmProgramSemesterYear WHERE programSemesterYearName ='"+programSemesterYear+"'").uniqueResult();
		
	}

}
