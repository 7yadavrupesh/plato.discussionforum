/**********************************************************************************
* File-name - PcmProgramSemesterElectiveDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Program semester elective DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramSemesterElectives;

public interface PcmProgramSemesterElectiveDao 
{
	 void dAddProgramSemesterElectives(PcmProgramSemesterElectives programSemesterElectives);
		
		PcmProgramSemesterElectives dGetProgramSemesterElectives(long programSemesterElectivesId);

		List<PcmProgramSemesterElectives> dGetListOfAllProgramSemesterElectives();
		
		void dDeleteProgramSemesterElectives(PcmProgramSemesterElectives programSemesterElectives);

		long dGetProgramSemesterElectivesId(PcmProgramSemesterElectives programSemesterElectives);

}
