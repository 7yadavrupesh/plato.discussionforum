/**********************************************************************************
* File-name - UmStudentDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description:  Student DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.dao;


import java.util.List;

import main.java.com.srmri.plato.core.usermanagement.model.UmStudent;

public interface UmStudentDao 
{
	void dAddStudent(UmStudent student);
	
	UmStudent dGetStudent(long studentId);

	List<UmStudent> dGetListOfAllStudents();
	
	void dDeleteStudent(UmStudent student);
	
	

}
