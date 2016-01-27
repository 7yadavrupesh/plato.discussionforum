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

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseCategoriesDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseCategories;

public class PcmCourseCategoriesDaoImpl implements PcmCourseCategoriesDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void dAddCourseCategory(PcmCourseCategories courseCategory) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(courseCategory);
		
		
	}

	@Override
	public PcmCourseCategories dGetcourseCategory(long courseCategoryId) 
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (PcmCourseCategories) session.get(PcmCourseCategories.class, courseCategoryId);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PcmCourseCategories> dGetListOfAllCourseCategories() 
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (List<PcmCourseCategories>) session.createCriteria(PcmCourseCategories.class).list();
	}

	

	@Override
	public void dDeleteCourseCategory(PcmCourseCategories courseCategory) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM PcmCourseCategories WHERE courseCategory_id = "+courseCategory.getCourseCategoryId()).executeUpdate();
		
	}

	@Override
	public long dGetCourseCategoriesId(PcmCourseCategories courseCategory) 
	{
		Session session = sessionFactory.getCurrentSession();
		return (long) session.createQuery("SELECT courseCategoryId FROM PcmCourseCategories WHERE courseCategoryName ='"+courseCategory.getCourseCategoryName()+"'").uniqueResult();
		
	}
	

}
