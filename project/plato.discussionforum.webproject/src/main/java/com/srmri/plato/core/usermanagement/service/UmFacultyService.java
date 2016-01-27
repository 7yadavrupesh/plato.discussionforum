/**********************************************************************************
* File-name - UmFacultyService.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Faculty Services interface
**********************************************************************************/ 

package main.java.com.srmri.plato.core.usermanagement.service;

import java.io.IOException;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import main.java.com.srmri.plato.core.usermanagement.model.UmFaculty;
import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;

public interface UmFacultyService 
{
	
	boolean blAddFaculty(UmFaculty faculty) throws IOException, ParseException;

	List<UmFaculty> blListFaculties();
	
	UmFaculty blGetFaculty(long facultyId);
	
	UmFaculty blGetFacultyByUserId(long userId);
	
	List<UmFaculty> blGetFacultyListByQualification(String qualification);
	
	List<UmFaculty> blGetFacultyListByFacultyType(String facultyType);
	
	List<UmFaculty> blGetFacultyListByDesignation(String designation);
	
	void blDeleteFaculty(UmFaculty faculty);
	

}
