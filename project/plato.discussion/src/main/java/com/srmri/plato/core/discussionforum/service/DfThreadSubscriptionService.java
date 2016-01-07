/**********************************************************************************
 * File-name - DfAttachedFile
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

package com.srmri.plato.core.discussionforum.service;

public interface DfThreadSubscriptionService {
	/*
	 *  Method declaration
	 *  Set Thread Follow
	 */
	void df_s_addThreadSubscription(Long threadId, Long userId);
	void df_s_removeThreadSubscription(Long threadId, Long userId);
	boolean df_s_isSubscribed(Long thread_id,Long loginUserId);

}
