/**********************************************************************************
 * File-name - DfModeratorAssignedDao
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

import com.srmri.plato.core.discussionforum.entity.DfModeratorAssigned;

public interface DfModeratorAssignedDao {
	/*
	 *  Method Declaration
	 *  Add Moderator
	 */
	Long df_d_addModerator(DfModeratorAssigned moderator);
	
	/*
	 *  Method Declaration
	 *  Gets All Topics, User Act As Moderator
	 */
	List<DfModeratorAssigned> df_d_getTopicUserActModerator(Long modId);
	/*
	 *  Method Declaration
	 *  Remove Moderator
	 */
	void df_d_removeModerator(Long modId);
	/*
	 *  Method Declaration
	 *  Get Moderator List
	 */
	List<Long> df_d_getModeratorList(Long topicId);

}
