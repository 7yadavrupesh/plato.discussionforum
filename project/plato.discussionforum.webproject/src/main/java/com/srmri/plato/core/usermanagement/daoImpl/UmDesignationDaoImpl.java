/**********************************************************************************
* File-name - UmDesignationDaoImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Desigantion DAO implementation
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.daoImpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.srmri.plato.core.usermanagement.dao.UmDesignationDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmDesignation;

@Repository("UmDesignationDao")
public class UmDesignationDaoImpl implements UmDesignationDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void dAddDesignation(UmDesignation designation)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(designation);
		
	}
	
	public UmDesignation dGetDesignation(long designationId)
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (UmDesignation) session.get(UmDesignation.class, designationId);	
	}

	@SuppressWarnings("unchecked")
	public List<UmDesignation> dGetListOfAllDesignation()
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (List<UmDesignation>) session.createCriteria(UmDesignation.class).list();
		
	}
	
	public void dDeleteDesignation(UmDesignation designation)
	{
		
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM um_designation WHERE designation_id = "+designation.getDesignationId()).executeUpdate();
	}

	@Override
	public long dGetDesignationId(String designation) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT designationId FROM UmDesignation WHERE designationName ='"+designation+"'").uniqueResult();
		
	
	}
}
