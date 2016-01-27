/**********************************************************************************
* File-name - UmFacultyDaoImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Faculty DAO implementation
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.daoImpl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.srmri.plato.core.usermanagement.dao.UmFacultyDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmFaculty;

@Repository("UmFacultyDao")
public class UmFacultyDaoImpl implements UmFacultyDao
{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	UmFacultyDaoImpl()
	{
		
	}
	
	
	
	public void dAddFaculty(UmFaculty faculty)
	{
		
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(faculty);
		
		
		
		
	}
	
	public UmFaculty dGetFaculty(long facultyId)
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (UmFaculty) session.get(UmFaculty.class, facultyId);	
	}

	@SuppressWarnings("unchecked")
	public List<UmFaculty> dGetListOfAllFaculties()
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (List<UmFaculty>) session.createCriteria(UmFaculty.class).list();
	}
	
	public void dDeleteFaculty(UmFaculty faculty)
	{
		
		Session session=sessionFactory.getCurrentSession();
		
		session.createQuery("DELETE FROM um_faculty WHERE faculty_id = "+faculty.getFacultyId()).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UmFaculty> dGetFacultyListByDepartment(long departmentId) {
		
		Session session=sessionFactory.getCurrentSession();
		return (List<UmFaculty>) session.createQuery("FROM UmFaculty WHERE department_id ="+departmentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UmFaculty> dGetFacultyListByDesignation(long designationId) {
		
		Session session=sessionFactory.getCurrentSession();
		return (List<UmFaculty>) session.createQuery("FROM UmFaculty WHERE designation_id ="+designationId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UmFaculty> dGetFacultyListByFacultyType(String facultyType) {
		
		Session session=sessionFactory.getCurrentSession();
		return (List<UmFaculty>) session.createQuery("FROM UmFaculty WHERE faculty_type ="+facultyType);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UmFaculty> dGetFacultyListByQualification(String qualification) {
		
		Session session=sessionFactory.getCurrentSession();
		return (List<UmFaculty>) session.createQuery("FROM UmFaculty WHERE qualification ="+qualification);
	}

	

	@Override
	public UmFaculty dGetFacultyByUserId(long userId) {
		
		Session session=sessionFactory.getCurrentSession();
		return (UmFaculty) session.createQuery("FROM UmFaculty WHERE user_id ="+userId);
	}

	
	

}
