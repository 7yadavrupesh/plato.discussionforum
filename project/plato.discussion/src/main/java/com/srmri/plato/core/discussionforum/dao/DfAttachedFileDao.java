/**********************************************************************************
 * File-name - DfAttachedFileDao
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

import com.srmri.plato.core.discussionforum.entity.DfAttachedFile;

public interface DfAttachedFileDao {

	/*
	 *  Method Declaration
	 *  Add Attached File
	 */
	Long dfDAddAttachedFile(DfAttachedFile attachedFile);

	/*
	 * Method Declaration
	 * Remove Attached File
	 */
	void dfDRemoveAttachedFile(Long fileId);

	DfAttachedFile dfDGetAttachedFile(Long fileId);

	void dfDRemoveAttachedFile(DfAttachedFile file);
}
