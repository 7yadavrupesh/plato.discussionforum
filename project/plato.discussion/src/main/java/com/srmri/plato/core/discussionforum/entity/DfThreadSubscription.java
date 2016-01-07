/**********************************************************************************
 * File-name - DfThreadSubscription
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
 * Description: <Add description about the file>
 *
 ****************************************************************************/

package com.srmri.plato.core.discussionforum.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "discussion_forum.df_thread_subscription")
public class DfThreadSubscription implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3013512969299354006L;

	@Id
	@SequenceGenerator(name="df_thread_subscription", sequenceName="discussion_forum.df_thread_subscription_thread_subscription_id_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="df_thread_subscription")
	@Column(name = "thread_subscription_id")
	private Long threadSubscriptionId;
	
	@Column(name = "thread_id")
	private Long threadId;
		
	@Column(name = "subscription_userid")
	private Long subscriptionUserid;
	
	@Column(name = "subscription_time")
	private Timestamp subscriptionTime;

	public DfThreadSubscription() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the deleteFlag
	 */
	public Long getThreadId() {
		return threadId;
	}
	/**
	 * @param threadId the threadId to set
	 */
	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}
	/**
	 * @return the deleteFlag
	 */
	public Long getThreadSubscriptionId() {
		return threadSubscriptionId;
	}
	/**
	 * @param threadSubscriptionId the threadSubscriptionId to set
	 */
	public void setThreadSubscriptionId(Long threadSubscriptionId) {
		this.threadSubscriptionId = threadSubscriptionId;
	}
	/**
	 * @return the deleteFlag
	 */
	public Long getSubscriptionUserid() {
		return subscriptionUserid;
	}
	/**
	 * @param subscriptionUserid the subscriptionUserid to set
	 */
	public void setSubscriptionUserid(Long subscriptionUserid) {
		this.subscriptionUserid = subscriptionUserid;
	}
	/**
	 * @return the deleteFlag
	 */
	public Timestamp getSubscriptionTime() {
		return subscriptionTime;
	}
	/**
	 * @param subscriptionTime the subscriptionTime to set
	 */
	public void setSubscriptionTime(Timestamp subscriptionTime) {
		this.subscriptionTime = subscriptionTime;
	}
	
}