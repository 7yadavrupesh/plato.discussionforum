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
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmDepartmentSchoolMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmDepartmentSchoolMap;


public class PcmDepartmentSchoolMapDaoImpl implements PcmDepartmentSchoolMapDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void dAddDepartmentSchoolMap(PcmDepartmentSchoolMap departmentSchoolMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(departmentSchoolMap);
		
	}

	@Override
	public PcmDepartmentSchoolMap dGetDepartmentSchoolMap(long departmentSchoolMapId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmDepartmentSchoolMap) session.get(PcmDepartmentSchoolMap.class, departmentSchoolMapId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmDepartmentSchoolMap> dGetListOfAllDepartmentSchoolMaps() 
	{

		Session session=sessionFactory.getCurrentSession();
		return (List<PcmDepartmentSchoolMap>) session.createCriteria(PcmDepartmentSchoolMap.class).list();
	}

	@Override
	public void dDeleteDepartmentSchoolMap(PcmDepartmentSchoolMap departmentSchoolMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmDepartmentSchoolMap WHERE departmentSchoolMapId = "+departmentSchoolMap.getDepartmentSchoolMapId()).executeUpdate();
		
	}

	@Override
	public long dGetDepartmentSchoolMapId(PcmDepartmentSchoolMap departmentSchoolMap) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT departmentSchoolMapId FROM PcmDepartmentSchoolMap WHERE departmentSchoolMapName ='"+departmentSchoolMap+"'").uniqueResult();
		
	}

}
