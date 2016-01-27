/**********************************************************************************
* File-name - RbacRoleLevelDaoImpl.java
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
 * Description: The Dao interface implementation for the rbac_role_level table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.daoimpl;

import com.srmri.plato.core.rbac.dao.RbacRoleLevelDao;
import com.srmri.plato.core.rbac.entity.RbacRoleLevel;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("roleLevelDao")
public class RbacRoleLevelDaoImpl implements RbacRoleLevelDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Method definition
	 * Used to insert/update a role level
	 */
	@Override
	public void rbacDInsertRoleLevel(RbacRoleLevel roleLevel) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(roleLevel);
		}		
		catch (Exception e) {			
			e.printStackTrace();
		}			
	}

	/**
	 * Method definition
	 * Used to fetch the list of role levels
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RbacRoleLevel> rbacDListRoleLevel() {		
		Session session = sessionFactory.getCurrentSession();
		return (List<RbacRoleLevel>) session.createCriteria(RbacRoleLevel.class).list();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a specific role level
	 */
	@Override
	public RbacRoleLevel rbacDGetRoleLevel(int roleLevelId) {		
		return (RbacRoleLevel) sessionFactory.getCurrentSession().get(RbacRoleLevel.class, roleLevelId);
	}

	/**
	 * Method definition
	 * Used to delete the details of a specific role level
	 */
	@Override
	public void rbacDDeleteRoleLevel(RbacRoleLevel roleLevel) {		
		try {
			sessionFactory.getCurrentSession().delete(roleLevel);			
		} catch (Exception e) {			
			e.printStackTrace();
		}		
	}

}
