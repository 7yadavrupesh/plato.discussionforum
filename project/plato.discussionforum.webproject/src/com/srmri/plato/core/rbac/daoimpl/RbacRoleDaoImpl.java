/**********************************************************************************
* File-name - RbacRoleDaoImpl.java
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
 * Description: The Dao interface implementation for the rbac_role table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.daoimpl;

import com.srmri.plato.core.rbac.dao.RbacRoleDao;
import com.srmri.plato.core.rbac.entity.RbacRole;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RbacRoleDaoImpl implements RbacRoleDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Method definition
	 * Used to insert/update a role 
	 */
	@Override
	public void rbacDInsertRole(RbacRole role) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(role);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/**
	 * Method definition
	 * Used to fetch the list of roles
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RbacRole> rbacDListRole() {
		// TODO Auto-generated method stub
		return (List<RbacRole>) sessionFactory.getCurrentSession().createCriteria(RbacRole.class).list();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a specific role 
	 */
	@Override
	public RbacRole rbacDGetRole(int roleId) {
		// TODO Auto-generated method stub
		return (RbacRole) sessionFactory.getCurrentSession().get(RbacRole.class, roleId);
	}

	/**
	 * Method definition
	 * Used to delete the details of a specific role 
	 */
	@Override
	public void rbacDDeleteRole(RbacRole role) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(role);
			//sessionFactory.getCurrentSession().createQuery("DELETE FROM rbac_role WHERE role_id = "+role.getRoleId()).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
