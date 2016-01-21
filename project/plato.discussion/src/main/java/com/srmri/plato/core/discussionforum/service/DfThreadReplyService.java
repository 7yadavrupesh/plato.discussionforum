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

import java.lang.Long;
import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfThreadReply;
import com.srmri.plato.core.discussionforum.entity.DfTopic;

public interface DfThreadReplyService {
	/*
	 *  Method declaration
	 *  Get Thread Reply List
	 */
	List<DfThreadReply> dfSGetThreadReplyList(DfTopic topicId);
	/*
	 *  Method declaration
	 *  Insert New Reply
	 */
	boolean dfSAddThreadReply(Long userId, Long threadId, String text);
	boolean dfSAddThreadReply(DfThreadReply threadReply);
	/*
	 *  Method declaration
	 *  Notify User For New Reply
	 */
	boolean dfSNotifyUserNewReply(Long threadReplyId, Long threadId);
	/*
	 *  Method declaration
	 *  Get Thread Reply List
	 */
	List<DfThreadReply> dfSGetThreadReplyList(Long threadId);
	
	void dfSDeleteThreadReply(Long replyId);
	DfThreadReply dfSGetThreadReply(Long replyId);
}
