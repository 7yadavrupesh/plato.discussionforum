/**********************************************************************************
* File-name - UmStudentServiceImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Student Services implementation
**********************************************************************************/ 

package main.java.com.srmri.plato.core.usermanagement.serviceImpl;



import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import main.java.com.srmri.plato.core.usermanagement.dao.UmStudentDao;
import main.java.com.srmri.plato.core.usermanagement.dao.UmUserDetailsDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmStudent;
import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;
import main.java.com.srmri.plato.core.usermanagement.service.UmStudentService;


@Service("UmStudentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UmStudentServiceImpl implements UmStudentService
{
	
	@Autowired
	private UmStudentDao studentDao;
	
	@Autowired
	private UmUserDetailsDao userDao;

	
	
	/**
	 * Adds a student details into student and userdetails table
	 * Transaction is managed by Spring
	 * @param map - details of the student
	 * @throws IOException
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean blAddStudent(UmStudent student) throws IOException , ConstraintViolationException 
	{
		try
		{			
			UmUserDetails user = new UmUserDetails(student.getStudentId(), student.getEmailId(),student.getGender());
		
		
			if(this.blAddStudentDetails(user, student))
				return true;
			else
				return false;
		}
		catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	/**
	 * Adds a student object and a user object into the respective tables 
	 * via dao
	 * @param UmUserDetails user - userdetails object
	 * @param UmStudent student - student object 
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	
	private boolean blAddStudentDetails(UmUserDetails user, UmStudent student) throws ConstraintViolationException
	{
		try
		{	userDao.dAddUserDetails(user);
			student.setUserId(user.getUserId());
			studentDao.dAddStudent(student);
			
			return true;
		}
		catch(Exception e)
		{
			 System.out.println("Transation rolledback");
			 TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			 return false;
		}
		
		
	}
	
	/**
	 * Fetches all the student object from the student table
	 * @return List of UmStudent objects
	 */
	@Override
	public List<UmStudent> blListStudents() 
	{
		
		return studentDao.dGetListOfAllStudents();
	}
	
	/**
	 * Gets a particular student identified by studentId
	 * @return UmStudent object
	 */
	@Override
	public UmStudent blGetStudent(long studentId) 
	{
		
		return studentDao.dGetStudent(studentId);
	}
	
	/**
	 * Delete a UmStudent object
	 * @param UmStudent object
	 */
	@Override
	public void blDeleteStudent(UmStudent student) 
	{
	
		studentDao.dDeleteStudent(student);
		
	}

}
