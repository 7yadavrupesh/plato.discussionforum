/**********************************************************************************
* File-name - RbacModulesServiceImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
 *
 * Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
 * written authorization of SRM Research Institute and its licensors, if any.
*
***********************************************************************************
*
 * Description: The service interface implementation for the rbac_modules table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.rbac.dao.RbacModulesDao;
import com.srmri.plato.core.rbac.entity.RbacModules;
import com.srmri.plato.core.rbac.service.RbacModulesService;

@Service("modulesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RbacModulesServiceImpl implements RbacModulesService{
	
	@Autowired
	private RbacModulesDao moduleDao;
	
	/**
	 * Method definition
	 * Used to add/update a module
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsAddModule(RbacModules module) {
		moduleDao.rbacDInsertModule(module);	
	}

	/**
	 * Method definition
	 * Used to list all the modules
	 */
	@Override
	public List<RbacModules> rbacBsListModules() {		
		return moduleDao.rbacDListModules();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a particular module
	 */
	@Override
	public RbacModules rbacBsGetModule(int moduleId) {		
		return moduleDao.rbacDGetModule(moduleId);
	}

	/**
	 * Method definition
	 * Used to delete a module
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void rbacBsDeleteModule(RbacModules module) {		
		moduleDao.rbacDDeleteModule(module);
	}

	
}
