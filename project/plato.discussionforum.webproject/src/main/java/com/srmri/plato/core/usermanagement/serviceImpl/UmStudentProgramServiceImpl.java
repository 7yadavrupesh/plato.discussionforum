/**********************************************************************************
 * File-name - UmStudentProgramServiceImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
 * Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
 * written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
 * Description: Student Program Services implementation
**********************************************************************************/ 
package main.java.com.srmri.plato.core.usermanagement.serviceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.srmri.plato.core.usermanagement.dao.UmStudentProgramDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmStudentProgram;
import main.java.com.srmri.plato.core.usermanagement.service.UmStudentProgramService;

@Service("UmStudentProgramService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UmStudentProgramServiceImpl implements UmStudentProgramService
{
	
	@Autowired
	private UmStudentProgramDao studentProgramDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)

	@Override
	public void blAddStudentProgram(UmStudentProgram studentProgram) 
	{

		studentProgramDao.dAddStudentProgram(studentProgram);
		
	}

	@Override
	public List<UmStudentProgram> blListStudentPrograms() 
	{
	
		return studentProgramDao.dGetListOfAllStudentPrograms();
	}

	@Override
	public UmStudentProgram blGetStudentProgram(long studentProgramId) 
	{
		
		return studentProgramDao.dGetStudentProgram(studentProgramId);
	}

	@Override
	public void blDeleteStudentProgram(UmStudentProgram studentProgram) 
	{
		
		studentProgramDao.dDeleteStudentProgram(studentProgram);
		
	}

}
