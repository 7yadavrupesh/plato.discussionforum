/**********************************************************************************
* File-name - UmStudentProgramDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: StudentProgram DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.dao;


import java.util.List;

import main.java.com.srmri.plato.core.usermanagement.model.UmStudentProgram;

public interface UmStudentProgramDao 
{
	 void dAddStudentProgram(UmStudentProgram studentProgram);
	
	 UmStudentProgram dGetStudentProgram(long studentProgramId);

	 List<UmStudentProgram> dGetListOfAllStudentPrograms();
	
	 void dDeleteStudentProgram(UmStudentProgram studentProgram);
}
