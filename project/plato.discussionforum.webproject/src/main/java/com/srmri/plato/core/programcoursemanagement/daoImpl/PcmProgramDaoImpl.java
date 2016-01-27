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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmPrograms;


public class PcmProgramDaoImpl implements PcmProgramDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void dAddProgram(PcmPrograms program) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(program);
		
	}

	@Override
	public PcmPrograms dGetProgram(long programId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmPrograms) session.get(PcmPrograms.class, programId);
	}
	
	@Override
	public PcmPrograms dGetProgram(String programCode) 
	{
	
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(PcmPrograms.class);
		cr.add(Restrictions.eq("programCode", programCode));
		cr.setMaxResults(1);
		return (PcmPrograms) cr.uniqueResult();
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<PcmPrograms> dGetListOfAllPrograms() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmPrograms>) session.createCriteria(PcmPrograms.class).list();
	}

	@Override
	public void dDeleteProgram(PcmPrograms program) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmPrograms WHERE programId = "+program.getProgramId()).executeUpdate();
		
		
	}

	@Override
	public long dGetProgramId(PcmPrograms program) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT programId FROM PcmPrograms WHERE programName ='"+program+"'").uniqueResult();
		
	}

	
}
