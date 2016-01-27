/**********************************************************************************
* File-name - PcmProgramDepartmentMapDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Program department mapping DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramDepartmentMap;

public interface PcmProgramDepartmentMapDao 
{
	 void dAddProgramDepartmentMap(PcmProgramDepartmentMap programDepartmentMap);
		
		PcmProgramDepartmentMap dGetProgramDepartmentMap(long programDepartmentMapId);

		List<PcmProgramDepartmentMap> dGetListOfAllProgramDepartmentMap();
		
		void dDeleteProgramDepartmentMap(PcmProgramDepartmentMap programDepartmentMap);

		long dGetProgramDepartmentMapId(PcmProgramDepartmentMap programDepartmentMap);

}
