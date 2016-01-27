/**********************************************************************************
* File-name - RbacPermissionsDaoImpl.java
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
 * Description: The Dao interface implementation for the rbac_permissions table
*
**********************************************************************************/

package com.srmri.plato.core.rbac.daoimpl;

import com.srmri.plato.core.rbac.dao.RbacPermissionsDao;
import com.srmri.plato.core.rbac.entity.RbacPermissions;
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
@Repository("permissionsDao")
public class RbacPermissionsDaoImpl implements RbacPermissionsDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Method definition
	 * Used to insert/update a permission
	 */
	@Override
	public void rbacDInsertPermission(RbacPermissions permission) {		
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(permission);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	/**
	 * Method definition
	 * Used to fetch the list of permissions
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<RbacPermissions> rbacDListPermissions() {		
		return (List<RbacPermissions>) sessionFactory.getCurrentSession().createCriteria(RbacPermissions.class).list();
	}

	/**
	 * Method definition
	 * Used to retrieve the details of a specific permission
	 */
	@Override
	public RbacPermissions rbacDGetPermission(long permissionId) {		
		return (RbacPermissions) sessionFactory.getCurrentSession().get(RbacPermissions.class, permissionId);
	}

	/**
	 * Method definition
	 * Used to delete the details of a specific permission
	 */
	@Override
	public void rbacDDeletePermission(RbacPermissions permission) {		
		try {
			sessionFactory.getCurrentSession().delete(permission);
			//sessionFactory.getCurrentSession().createQuery("DELETE FROM rbac_permissions WHERE permission_id = "+permission.getPermissionId()).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * Method definition
	 * Used to retrieve the permissions of a module 
	 */
	@SuppressWarnings("unchecked")
	public List<RbacPermissions> rbacDGetModulePermissions(int moduleId){
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(RbacPermissions.class);
		cr.add(Restrictions.eq("moduleId", moduleId));		
		return (List<RbacPermissions>) cr.list();
	}

	/**
	 * Method definition
	 * Used to retrieve the permission id for a given permission code
	 */
	@Override
	public long rbacDGetPermissionId(String permissionCode) {
		Session session = sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(RbacPermissions.class);
		cr.add(Restrictions.eq("permissionCode", permissionCode));
		@SuppressWarnings("unchecked")
		List<RbacPermissions> permission = cr.list();
		if(permission.size() > 0){
			int permissionId = permission.get(0).getPermissionId();
			return permissionId;
		}
		else{
			return 0;
		}
		
	}
	
	

}
