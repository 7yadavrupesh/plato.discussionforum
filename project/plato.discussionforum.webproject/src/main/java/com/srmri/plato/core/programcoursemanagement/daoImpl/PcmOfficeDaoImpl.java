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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmOfficeDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmOffice;

public class PcmOfficeDaoImpl implements PcmOfficeDao
{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void dAddOffice(PcmOffice office) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(office);
		
	}

	@Override
	public PcmOffice dGetOffice(long officeId) 
	{
		Session session=sessionFactory.getCurrentSession();
		return (PcmOffice) session.get(PcmOffice.class, officeId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmOffice> dGetListOfAllOffice() 
	{
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmOffice>) session.createCriteria(PcmOffice.class).list();
	}

	@Override
	public void dDeleteOffice(PcmOffice office) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM Pcmoffice WHERE officeId = "+office.getOfficeId()).executeUpdate();
		
		
	}

	@Override
	public long dGetOfficeId(PcmOffice office) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT officeId FROM Pcmoffice WHERE officeName ='"+office+"'").uniqueResult();
		
	}

	
}
