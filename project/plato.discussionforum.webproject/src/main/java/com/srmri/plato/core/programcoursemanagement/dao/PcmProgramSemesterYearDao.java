/**********************************************************************************
* File-name - PcmProgramSemesterYearDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Program semester year DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramSemesterYear;

public interface PcmProgramSemesterYearDao 
{
	 void dAddProgramSemesterYear(PcmProgramSemesterYear ProgramSemesterYear);
		
		PcmProgramSemesterYear dGetProgramSemesterYear(long ProgramSemesterYearId);

		List<PcmProgramSemesterYear> dGetListOfAllProgramSemesterYear();
		
		void dDeleteProgramSemesterYear(PcmProgramSemesterYear ProgramSemesterYear);

		long dGetProgramSemesterYearId(PcmProgramSemesterYear ProgramSemesterYear);


}
