/**********************************************************************************
* File-name - PcmCourseDepartmentMapDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Course department mapping DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseDepartmentMap;

public interface PcmCourseDepartmentMapDao
{
	 void dAddCourseDepartmentMap(PcmCourseDepartmentMap courseDepartmentMap);
		
		PcmCourseDepartmentMap dGetCourseDepartmentMap(long courseDepartmentMapId);
		
		void dDeleteCourseDepartmentMap(PcmCourseDepartmentMap courseDepartmentMap);

		long dGetCourseDepartmentMapId(PcmCourseDepartmentMap courseDepartmentMap);

		List<PcmCourseDepartmentMap> dGetListOfAllCourseDepartmentMap();

}
