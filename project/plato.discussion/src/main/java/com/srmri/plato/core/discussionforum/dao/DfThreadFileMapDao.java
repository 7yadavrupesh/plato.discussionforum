/**********************************************************************************
 * File-name - DfThreadDao
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

import com.srmri.plato.core.discussionforum.entity.DfThreadFileMap;

public interface DfThreadFileMapDao {
	
	void df_d_addThreadFileMap(DfThreadFileMap threadFileMap);
	void df_d_removeThreadFileMap(DfThreadFileMap threadFileMap);
	List<DfThreadFileMap> df_d_getTheadFileMapList(Long threadId);
	List<Long> df_d_getFileList(Long threadId);
	DfThreadFileMap df_d_getThreadFileMap(Long fileId );
	void df_d_addThreadFileMap(Long threadId, Long uploadedFileId);
}
