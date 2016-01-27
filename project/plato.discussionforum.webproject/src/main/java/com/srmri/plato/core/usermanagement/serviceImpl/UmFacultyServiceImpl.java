/**********************************************************************************
* File-name - UmFacultyServiceImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Faculty Services implementation
**********************************************************************************/ 

package main.java.com.srmri.plato.core.usermanagement.serviceImpl;



import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;


import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


import main.java.com.srmri.plato.core.usermanagement.dao.UmDesignationDao;
import main.java.com.srmri.plato.core.usermanagement.dao.UmFacultyDao;
import main.java.com.srmri.plato.core.usermanagement.dao.UmUserDetailsDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmFaculty;
import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;
import main.java.com.srmri.plato.core.usermanagement.service.UmFacultyService;

@Service("UmFacultyService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UmFacultyServiceImpl implements UmFacultyService
{
	
	@Autowired
	private UmFacultyDao facultyDao;
	
	@Autowired
	private UmUserDetailsDao userDao;
	
	@Autowired
	private UmDesignationDao designationDao;
	
	
	UmFacultyServiceImpl()
	{
		
	}
	
	@Transactional(/*rollbackFor={ConstraintViolationException.class, PSQLException.class}, */propagation = Propagation.REQUIRED, readOnly = false)
	private boolean blAddFacultyDetails(UmUserDetails user, UmFaculty faculty) 
	{
		
		try
		{
			userDao.dAddUserDetails(user);
		
			faculty.setUserId(user.getUserId());
			facultyDao.dAddFaculty(faculty);
			return true;
		}
		catch(Exception e)
		{	
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			
			return false;
					
		}
		
	}
	
	@Override
	public boolean blAddFaculty(UmFaculty faculty) throws IOException, ParseException 
	{
		
		try
		{				
			UmUserDetails user = new UmUserDetails(faculty.getEmailId(), faculty.getEmailId(), faculty.getGender());
					
		    
			if(this.blAddFacultyDetails(user, faculty))
				return true;
			else
				return false;
		}
		catch(Exception e)
		{  
			return false;
		}
	
	}

	@Override
	public List<UmFaculty> blListFaculties() 
	{
		
		return facultyDao.dGetListOfAllFaculties();
	}

	@Override
	public UmFaculty blGetFaculty(long facultyId) 
	{
		
		return facultyDao.dGetFaculty(facultyId);
	}

	@Override
	public void blDeleteFaculty(UmFaculty faculty) 
	{
		
		facultyDao.dDeleteFaculty(faculty);
		
	}

	@Override
	public UmFaculty blGetFacultyByUserId(long userId) {
		return facultyDao.dGetFacultyByUserId(userId);
		
	}

	@Override
	public List<UmFaculty> blGetFacultyListByQualification(String qualification) {
		
		return facultyDao.dGetFacultyListByQualification(qualification);
	}

	@Override
	public List<UmFaculty> blGetFacultyListByFacultyType(String facultyType) {
		
		return facultyDao.dGetFacultyListByFacultyType(facultyType);
	}

	@Override
	public List<UmFaculty> blGetFacultyListByDesignation(String designation)
	{
		long designationId = designationDao.dGetDesignationId(designation);
		return facultyDao.dGetFacultyListByDesignation(designationId);
	}


	

}
