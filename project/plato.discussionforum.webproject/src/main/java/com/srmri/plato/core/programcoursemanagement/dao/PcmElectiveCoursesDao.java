/**********************************************************************************
* File-name - PcmElectiveCoursesDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Elective Courses DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmElectiveCourses;

public interface PcmElectiveCoursesDao 
{
	 void dAddelectiveCourse(PcmElectiveCourses electiveCourse);
		
		PcmElectiveCourses dGetElectiveCourse(long electiveCourseId);

		List<PcmElectiveCourses> dGetListOfAllElectiveCourse();
		
		void dDeleteElectiveCourse(PcmElectiveCourses electiveCourse);

		long dGetElectiveCourseId(PcmElectiveCourses electiveCourse);

}
