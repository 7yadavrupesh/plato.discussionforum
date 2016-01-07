/**********************************************************************************
 * File-name - DfThreadSubscriptionDao
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

package com.srmri.plato.core.discussionforum.dao;

import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfThreadSubscription;

public interface DfThreadSubscriptionDao {
	/*
	 *  Method Declaration
	 *  Add Subscription
	 */
	void df_d_addSubscription(DfThreadSubscription sbs);
	
	/*
	 *  Method Declaration
	 *  Remove Subscription
	 */
	void df_d_removeSubscription(Long threadId,Long userId);
	
	/*
	 *  Method Declaration
	 *  Get Thread Subscri
	 */
	List<DfThreadSubscription> df_d_getThreadSubscriberList();
	boolean df_d_isSubscribed(Long thread_id,Long loginUserId);
}
