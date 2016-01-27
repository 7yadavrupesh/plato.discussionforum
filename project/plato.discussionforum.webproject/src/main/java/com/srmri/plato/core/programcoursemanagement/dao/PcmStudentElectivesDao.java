/**********************************************************************************
* File-name - PcmStudentElectivesDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Student electives DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmStudentElectives;

public interface PcmStudentElectivesDao 
{
	void dAddStudentElectives(PcmStudentElectives studentElective);
	
	PcmStudentElectives dGetStudentElectives(long studentElectiveId);

	List<PcmStudentElectives> dGetListOfAllStudentElectives();
	
	void dDeleteStudentElectives(PcmStudentElectives studentElective);

	long dGetStudentElectivesId(PcmStudentElectives studentElective);
}
