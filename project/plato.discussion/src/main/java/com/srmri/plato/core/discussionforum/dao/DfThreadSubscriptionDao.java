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
	void dfDAddSubscription(DfThreadSubscription sbs);
	
	/*
	 *  Method Declaration
	 *  Remove Subscription
	 */
	void dfDRemoveSubscription(Long threadId,Long userId);
	
	/*
	 *  Method Declaration
	 *  Get Thread Subscri
	 */
	List<DfThreadSubscription> dfDGetThreadSubscriberList();
	boolean dfDIsSubscribed(Long thread_id,Long loginUserId);
}
