/**********************************************************************************
* File-name - PcmCourseDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Course DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourses;

public interface PcmCourseDao 
{
	    void dAddCourse(PcmCourses course);
		
		PcmCourses dGetCourse(long courseId);
		
		PcmCourses dGetCourse(String courseCode);

		List<PcmCourses> dGetListOfAllCourses();
		
		void dDeleteCourse(PcmCourses course);

		long dGetCourseId(PcmCourses course);

}
