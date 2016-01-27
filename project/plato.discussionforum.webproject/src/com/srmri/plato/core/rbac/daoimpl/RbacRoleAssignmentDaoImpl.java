/**********************************************************************************
* File-name - RbacRoleAssignmentDaoImpl.java
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
 * Description: The Dao interface implementation for the rbac_role_assignment table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.daoimpl;

import com.srmri.plato.core.rbac.dao.RbacRoleAssignmentDao;
import com.srmri.plato.core.rbac.entity.RbacRoleAssignment;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author srmri
 *
 */
@Repository("roleAssignmentDao")
public class RbacRoleAssignmentDaoImpl implements RbacRoleAssignmentDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Method definition
	 * Used to insert/update a role for a user
	 */
	@Override
	public void rbacDInsertRoleAssignment(RbacRoleAssignment roleAssignment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(roleAssignment);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Method definition
	 * Used to fetch the list of role assignments
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RbacRoleAssignment> rbacDListRoleAssignment() {
		// TODO Auto-generated method stub
		return (List<RbacRoleAssignment>) sessionFactory.getCurrentSession().createCriteria(RbacRoleAssignment.class).list();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a specific role assignment
	 */
	@Override
	public RbacRoleAssignment rbacDGetRoleAssignment(int roleAssignmentId) {
		// TODO Auto-generated method stub
		return (RbacRoleAssignment) sessionFactory.getCurrentSession().get(RbacRoleAssignment.class, roleAssignmentId);
	}

	/**
	 * Method definition
	 * Used to delete the details of a specific role assignment
	 */
	@Override
	public void rbacDDeleteRoleAssignment(RbacRoleAssignment roleAssignment) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(roleAssignment);
			//sessionFactory.getCurrentSession().createQuery("DELETE FROM rbac_role_assignment WHERE role_assignment_id = "+roleAssignment.getRoleAssignmentId()).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Method definition
	 * Used to retrieve the role ids of a particular user
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RbacRoleAssignment> rbacDGetUserRoleIds(long userId) {
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(RbacRoleAssignment.class);
		cr.add(Restrictions.eq("userId", userId));		
		return (List<RbacRoleAssignment>) cr.list();		
	}

}
