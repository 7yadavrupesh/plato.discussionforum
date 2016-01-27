/**********************************************************************************
* File-name - RbacModulesDaoImpl.java
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
 * Description: The Dao interface implementation for the rbac_modules table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.daoimpl;

import com.srmri.plato.core.rbac.dao.RbacModulesDao;
import com.srmri.plato.core.rbac.entity.RbacModules;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("modulesDao")
public class RbacModulesDaoImpl implements RbacModulesDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Method definition
	 * Used to insert/update a module
	 */
	@Override
	public void rbacDInsertModule(RbacModules module) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(module);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/**
	 * Method definition
	 * Used to fetch the list of modules
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RbacModules> rbacDListModules() {
		// TODO Auto-generated method stub
		return (List<RbacModules>) sessionFactory.getCurrentSession().createCriteria(RbacModules.class).list();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a specific module
	 */
	@Override
	public RbacModules rbacDGetModule(int moduleId) {
		// TODO Auto-generated method stub
		return (RbacModules) sessionFactory.getCurrentSession().get(RbacModules.class, moduleId);
	}

	/**
	 * Method definition
	 * Used to delete the details of a specific module
	 */
	@Override
	public void rbacDDeleteModule(RbacModules module) {
		// TODO Auto-generated method stub	
		try {
			sessionFactory.getCurrentSession().delete(module);
			//sessionFactory.getCurrentSession().createQuery("DELETE FROM rbac_modules WHERE module_id = "+module.getModuleId()).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
