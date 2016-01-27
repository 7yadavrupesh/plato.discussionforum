/**********************************************************************************
* File-name - UmStudentProgramDaoImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: StudentProgram DAO implementation
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.daoImpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.srmri.plato.core.usermanagement.dao.UmStudentProgramDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmStudentProgram;

@Repository("UmStudentProgramDao")
public class UmStudentProgramDaoImpl implements UmStudentProgramDao
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void dAddStudentProgram(UmStudentProgram studentProgram)
	{
	
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(studentProgram);
	}
	
	
	public UmStudentProgram dGetStudentProgram(long studentProgramId)
	{
	
		Session session=sessionFactory.getCurrentSession();
		return (UmStudentProgram) session.get(UmStudentProgram.class, studentProgramId);	
	}

	
	@SuppressWarnings("unchecked")
	
	public List<UmStudentProgram> dGetListOfAllStudentPrograms()
	{
	
		Session session=sessionFactory.getCurrentSession();
		return (List<UmStudentProgram>) session.createCriteria(UmStudentProgram.class).list();
	}
	
	
	public void dDeleteStudentProgram(UmStudentProgram studentProgram)
	{
	
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM um_student_program WHERE student_program_id = "+studentProgram.getStudentProgramId()).executeUpdate();
	}
}
