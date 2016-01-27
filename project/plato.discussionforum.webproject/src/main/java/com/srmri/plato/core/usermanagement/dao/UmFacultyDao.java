/**********************************************************************************
* File-name - UmFacultyDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Faculty DAO interface
**********************************************************************************/


package main.java.com.srmri.plato.core.usermanagement.dao;


import java.util.List;

import main.java.com.srmri.plato.core.usermanagement.model.UmFaculty;

public interface UmFacultyDao 
{
	void dAddFaculty(UmFaculty faculty);
	
	UmFaculty dGetFaculty(long facultyId);

	List<UmFaculty> dGetListOfAllFaculties();
	
	void dDeleteFaculty(UmFaculty faculty);

	List<UmFaculty> dGetFacultyListByDepartment(long departmentId);

	List<UmFaculty> dGetFacultyListByDesignation(long designationId);

	List<UmFaculty> dGetFacultyListByFacultyType(String facultyType);

	List<UmFaculty> dGetFacultyListByQualification(String qualification);

	UmFaculty dGetFacultyByUserId(long userId);

	


}
