/**********************************************************************************
 * File-name - DfThreadReplyDao
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

import com.srmri.plato.core.discussionforum.entity.DfThreadReply;
public interface DfThreadReplyDao {
	
	/*
	 *  Method Declaration
	 *  Insert New Reply
	 */
	void dfDInsertNewReply(DfThreadReply threadReply);
	
	/*
	 *  Method Declaration
	 *  Get Reply Detail
	 */
	DfThreadReply dfDGetReplyDetail(Long replyId);
	
	/*
	 *  Method Declaration
	 *  Get Thread Reply List
	 */
	List<DfThreadReply> dfDGetThreadReplyList(Long threadId);
	
	/*
	 *  Method Declaration
	 *  Delete Thread Reply
	 */
	void dfDDeleteThreadReply(Long replyId);
}
