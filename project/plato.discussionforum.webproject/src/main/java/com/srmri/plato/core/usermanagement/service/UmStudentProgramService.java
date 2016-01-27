/**********************************************************************************
* File-name - UmStudentProgramService.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Student program Services interface
**********************************************************************************/ 

package main.java.com.srmri.plato.core.usermanagement.service;


import java.util.List;

import main.java.com.srmri.plato.core.usermanagement.model.UmStudentProgram;

public interface UmStudentProgramService 
{
	 void blAddStudentProgram(UmStudentProgram studentProgram);

	 List<UmStudentProgram> blListStudentPrograms();
	
	 UmStudentProgram blGetStudentProgram(long studentProgramId);
	
	 void blDeleteStudentProgram(UmStudentProgram user);

}
