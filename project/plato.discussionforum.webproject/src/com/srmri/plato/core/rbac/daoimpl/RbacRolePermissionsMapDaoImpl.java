/**********************************************************************************
* File-name - RbacRolePermissionsMapDaoImpl.java
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
 * Description: The Dao interface implementation for the rbac_role_permissions_map table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.daoimpl;

import com.srmri.plato.core.rbac.dao.RbacRolePermissionsMapDao;
import com.srmri.plato.core.rbac.entity.RbacRolePermissionsMap;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("rolePermissionsMapDao")
public class RbacRolePermissionsMapDaoImpl implements RbacRolePermissionsMapDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Method definition
	 * Used to insert/update a role permission map
	 */
	@Override
	public void rbacDInsertRolePermissionsMap(RbacRolePermissionsMap rolePermissionsMap) {		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(rolePermissionsMap);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/**
	 * Method definition
	 * Used to fetch the list of role permission mappings
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RbacRolePermissionsMap> rbacDListRolePermissionsMap() {		
		return (List<RbacRolePermissionsMap>) sessionFactory.getCurrentSession().createCriteria(RbacRolePermissionsMap.class).list();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a specific role permission map
	 */
	@Override
	public RbacRolePermissionsMap rbacDGetRolePermissionsMap(long rolePermissionsMapId) {		
		return (RbacRolePermissionsMap) sessionFactory.getCurrentSession().get(RbacRolePermissionsMap.class, rolePermissionsMapId);
	}

	/**
	 * Method definition
	 * Used to delete the details of a specific role permission map
	 */
	@Override
	public void rbacDDeleteRolePermissionsMap(RbacRolePermissionsMap rolePermissionsMap) {		
		try {
			sessionFactory.getCurrentSession().delete(rolePermissionsMap);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Method definition
	 * Used to retrieve the list of permissions associated with a role
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RbacRolePermissionsMap> rbacDGetRolePermissions(int roleId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(RbacRolePermissionsMap.class);
		cr.add(Restrictions.eq("roleId", roleId));		
		return (List<RbacRolePermissionsMap>) cr.list();
	}

	/**
	 * Method definition
	 * Used to check if a permission is associated with a specific role
	 */
	@Override
	public boolean rbacDIsRolePermissionExists(int roleId, long permissionId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(RbacRolePermissionsMap.class);
		cr.add(Restrictions.eq("roleId", roleId));	
		cr.add(Restrictions.eq("permissionId", permissionId));
		if(cr.list().size() > 0){
			return true;
		}
		else{
			return false;
		}		
	}

}
