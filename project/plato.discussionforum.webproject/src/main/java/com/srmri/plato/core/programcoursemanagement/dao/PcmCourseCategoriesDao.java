/**********************************************************************************
* File-name - PcmCourseCategoriesDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Course Categories DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseCategories;



public interface PcmCourseCategoriesDao 
{
    void dAddCourseCategory(PcmCourseCategories courseCategory);
	
	List<PcmCourseCategories> dGetListOfAllCourseCategories();
	
	void dDeleteCourseCategory(PcmCourseCategories courseCategory);

	long dGetCourseCategoriesId(PcmCourseCategories courseCategory);

	PcmCourseCategories dGetcourseCategory(long courseCategoryId);
 
}
