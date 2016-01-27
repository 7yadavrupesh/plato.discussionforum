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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramTypeDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramType;

public class PcmProgramTypeDaoImpl implements PcmProgramTypeDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void dAddProgramType(PcmProgramType programType) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(programType);
		
	}

	@Override
	public PcmProgramType dGetProgramType(long programTypeId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmProgramType) session.get(PcmProgramType.class, programTypeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmProgramType> dGetListOfAllProgramType() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmProgramType>) session.createCriteria(PcmProgramType.class).list();
	}

	@Override
	public void dDeleteProgramType(PcmProgramType programType) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmProgramType WHERE programTypeId = "+programType.getProgramTypeId()).executeUpdate();
	
		
		
	}

	@Override
	public long dGetProgramTypeId(PcmProgramType programType) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT programTypeId FROM PcmProgramType WHERE programTypeName ='"+programType+"'").uniqueResult();
		
	}

}
