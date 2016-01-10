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

import com.srmri.plato.core.discussionforum.entity.DfAttachedFile;

public interface DfAttachedFileService {

	Long df_s_addAttachedFile(DfAttachedFile attachedFile);

	void df_s_removeAttachedFile(Long fileId);
	
	DfAttachedFile df_s_getAttachedFile(Long fileId);

	void df_s_removeAttachedFile(DfAttachedFile file);
}
