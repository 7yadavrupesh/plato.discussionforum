/**********************************************************************************
* File-name - UmDesignationServiceImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Designation Services implementation
**********************************************************************************/ 

package main.java.com.srmri.plato.core.usermanagement.serviceImpl;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.srmri.plato.core.usermanagement.dao.UmDesignationDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmDesignation;
import main.java.com.srmri.plato.core.usermanagement.service.UmDesignationService;

@Service("UmDesignationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UmDesignationServiceImpl implements UmDesignationService
{
	
	
	@Autowired
	transient private UmDesignationDao designationDao;
	
	public UmDesignationServiceImpl(){}
	/**
	 * Adds a designation in the table via dao
	 * @param UmDesignation object
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void blAddDesignation(UmDesignation designation) 
	{
	
		designationDao.dAddDesignation(designation);
		
	}
	
	/**
	 * gets list of all the designations in the table
	 * @return List of UmDesignation objects with designation details
	 */
	@Override
	public List<UmDesignation> blListDesignations() 
	{
	
		return designationDao.dGetListOfAllDesignation();
	}

	
	/**
	 * gets a particular designation identified by designationId
	 * @param long designationId
	 * @return UmDesignation object 
	 */
	@Override
	public UmDesignation blGetDesignation(long designationId) 
	{
		
		return designationDao.dGetDesignation(designationId);
	}
	
	/**
	 * deletes a designation
	 * @param UmDesignation object
	 */
	@Override
	public void blDeleteDesignation(UmDesignation designation) 
	{
	
		designationDao.dDeleteDesignation(designation);
		
	}
	@Override
	public long blGetDesignationId(String designation) {
		
		return designationDao.dGetDesignationId(designation);
	}

}
