/**********************************************************************************
* File-name - UmUserDetailsDaoImpl.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: UserDetails DAO implementation
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.daoImpl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.srmri.plato.core.usermanagement.dao.UmUserDetailsDao;
import main.java.com.srmri.plato.core.usermanagement.model.UmUserDetails;

@Repository("UmUserDetailsDao")
public class UmUserDetailsDaoImpl  implements UmUserDetailsDao
{
	
	UmUserDetailsDaoImpl()
	{}
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public void dAddUserDetails(UmUserDetails user)
	{
		System.out.println("inside add user dao");
		System.out.println("dao "+user.getUserId()+" "+user.getUserName()+" "+user.getPassword());
		try
		{	
			
			Session session=sessionFactory.getCurrentSession();
			
			
			session.saveOrUpdate(user);
			session.flush();
			
			
		
		}
		catch(Exception e)
		{		
			System.out.println("Constraint violation");
			e.printStackTrace();
			
		}
	
	}
	
	public UmUserDetails dGetUserDetails(long userId)
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (UmUserDetails) session.get(UmUserDetails.class, userId);	
	}
	
	public UmUserDetails dGetUserByName(String userName)
	{	
		Session session=sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(UmUserDetails.class);
		cr.add(Restrictions.eq("userName", userName));
		cr.setMaxResults(1);
		return (UmUserDetails) cr.uniqueResult();
	}
	
	@Override
	public UmUserDetails dGetUserByEmail(String email) 
	{	
		System.out.println("inside dgetuser by email");
		try
		{
			Session session=sessionFactory.getCurrentSession();
		
			Criteria cr = session.createCriteria(UmUserDetails.class);
			cr.add(Restrictions.eq("emailId", email));
			cr.setMaxResults(1);
			return (UmUserDetails) cr.uniqueResult();
		}
		catch(Exception e)
		{
			System.out.println("Email does not exist");
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public List<UmUserDetails> dGetListOfAllUsers()
	{
		
		Session session=sessionFactory.getCurrentSession();
		return (List<UmUserDetails>) session.createCriteria(UmUserDetails.class).list();
	}
	
	public void dDeleteUserDetails(UmUserDetails user)
	{
		
		Session session=sessionFactory.getCurrentSession();
		session.createQuery("DELETE FROM UmUserDetails WHERE user_id = "+user.getUserId()).executeUpdate();
	}

	

}
