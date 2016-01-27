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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramDepartmentMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramDepartmentMap;


public class PcmProgramDepartmentMapDaoImpl implements PcmProgramDepartmentMapDao
{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void dAddProgramDepartmentMap(PcmProgramDepartmentMap programDepartmentMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(programDepartmentMap);
		
	}

	@Override
	public PcmProgramDepartmentMap dGetProgramDepartmentMap(long programDepartmentMapId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmProgramDepartmentMap) session.get(PcmProgramDepartmentMap.class, programDepartmentMapId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmProgramDepartmentMap> dGetListOfAllProgramDepartmentMap() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmProgramDepartmentMap>) session.createCriteria(PcmProgramDepartmentMap.class).list();
	}

	@Override
	public void dDeleteProgramDepartmentMap(PcmProgramDepartmentMap programDepartmentMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmProgramDepartmentMap WHERE programDepartmentMapId = "+programDepartmentMap.getProgramDepartmentMapId()).executeUpdate();
		
		
	}

	@Override
	public long dGetProgramDepartmentMapId(PcmProgramDepartmentMap programDepartmentMap) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT programDepartmentMapId FROM PcmProgramDepartmentMap WHERE programDepartmentMapName ='"+programDepartmentMap+"'").uniqueResult();
		
	}

}
