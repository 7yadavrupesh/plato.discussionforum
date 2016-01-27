/**********************************************************************************
* File-name - PcmProgramCourseMapDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Program course mapping DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramCourseMap;

public interface PcmProgramCourseMapDao 
{
	 void dAddProgramCourseMap(PcmProgramCourseMap programCourseMap);
		
		PcmProgramCourseMap dGetProgramCourseMap(long programCourseMapId);

		List<PcmProgramCourseMap> dGetListOfAllProgramCourseMap();
		
		void dDeleteProgramCourseMap(PcmProgramCourseMap programCourseMap);

		long dGetProgramCourseMapId(PcmProgramCourseMap programCourseMap);

}
