/**********************************************************************************
* File-name - PcmProgramDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Program DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmPrograms;

public interface PcmProgramDao 
{
	 void dAddProgram(PcmPrograms programs);
		
		PcmPrograms dGetProgram(long programsId);

		List<PcmPrograms> dGetListOfAllPrograms();
		
		void dDeleteProgram(PcmPrograms programs);

		long dGetProgramId(PcmPrograms programs);

		PcmPrograms dGetProgram(String programCode);

}
