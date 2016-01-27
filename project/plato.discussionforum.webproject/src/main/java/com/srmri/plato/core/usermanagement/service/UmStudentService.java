/**********************************************************************************
 * File-name - UmStudentService.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
 * Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
 * written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
 * Description: Student Services interface
**********************************************************************************/ 

package main.java.com.srmri.plato.core.usermanagement.service;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import main.java.com.srmri.plato.core.usermanagement.model.UmStudent;
import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;

public interface UmStudentService
{
	boolean blAddStudent(UmStudent student/*HashMap<String, Object> map*/) throws IOException;
	
	//boolean blAddStudentDetails(UmUserDetails user, UmStudent student);

	List<UmStudent> blListStudents();
	
	UmStudent blGetStudent(long studentId);
	
	void blDeleteStudent(UmStudent student);

}
