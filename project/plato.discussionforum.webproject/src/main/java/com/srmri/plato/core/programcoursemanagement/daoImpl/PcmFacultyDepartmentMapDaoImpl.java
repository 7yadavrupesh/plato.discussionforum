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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmFacultyDepartmentMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmFacultyDepartmentMap;

public class PcmFacultyDepartmentMapDaoImpl implements PcmFacultyDepartmentMapDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void dAddFacultyDepartmentMap(PcmFacultyDepartmentMap facultyDepartmentMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(facultyDepartmentMap);
		
	}

	@Override
	public PcmFacultyDepartmentMap dGetFacultyDepartmentMap(long facultyDepartmentMapId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmFacultyDepartmentMap) session.get(PcmFacultyDepartmentMap.class, facultyDepartmentMapId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmFacultyDepartmentMap> dGetListOfAllFacultyDepartmentMap() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmFacultyDepartmentMap>) session.createCriteria(PcmFacultyDepartmentMap.class).list();
	}

	@Override
	public void dDeleteFacultyDepartmentMap(PcmFacultyDepartmentMap facultyDepartmentMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmFacultyDepartmentMap WHERE facultyDepartmentMapId = "+facultyDepartmentMap.getFacultyDepartmentMapId()).executeUpdate();
		
		
	}

	@Override
	public long dGetFacultyDepartmentMapId(PcmFacultyDepartmentMap facultyDepartmentMap) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT facultyDepartmentMapId FROM PcmFacultyDepartmentMap WHERE facultyDepartmentMapName ='"+facultyDepartmentMap+"'").uniqueResult();
		
	}

}
