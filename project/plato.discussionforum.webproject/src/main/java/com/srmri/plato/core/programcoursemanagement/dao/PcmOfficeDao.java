/**********************************************************************************
* File-name - PcmOfficeDao.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Office DAO interface
**********************************************************************************/

package main.java.com.srmri.plato.core.programcoursemanagement.dao;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmOffice;

public interface PcmOfficeDao 
{
	  void dAddOffice(PcmOffice office);
		
		PcmOffice dGetOffice(long officeId);

		List<PcmOffice> dGetListOfAllOffice();
		
		void dDeleteOffice(PcmOffice office);

		long dGetOfficeId(PcmOffice office);

}
