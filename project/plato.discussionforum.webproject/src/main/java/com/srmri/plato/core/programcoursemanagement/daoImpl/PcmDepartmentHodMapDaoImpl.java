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
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmDepartmentHodMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmDepartmentHodMap;

public class PcmDepartmentHodMapDaoImpl implements PcmDepartmentHodMapDao
{
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public void dAddDepartmentHodMap(PcmDepartmentHodMap departmentHodMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(departmentHodMap);
		
	}

	@Override
	public PcmDepartmentHodMap dGetDepartmentHodMap(long departmentHodMapId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmDepartmentHodMap) session.get(PcmDepartmentHodMap.class, departmentHodMapId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmDepartmentHodMap> dGetListOfAllDepartmentHodMap() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmDepartmentHodMap>) session.createCriteria(PcmDepartmentHodMap.class).list();
	}

	@Override
	public void dDeleteDepartmentHodMap(PcmDepartmentHodMap departmentHodMap) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmDepartmentHodMap WHERE departmentHodMapId = "+departmentHodMap.getDepartmentHodMapId()).executeUpdate();
		
	}

	

	@Override
	public long dGetDepartmentHodMapId(PcmDepartmentHodMap departmentHodMap) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT departmentHodMapId FROM PcmdepartmentHodMap WHERE departmentHodMapName ='"+departmentHodMap+"'").uniqueResult();
		
	}

}
