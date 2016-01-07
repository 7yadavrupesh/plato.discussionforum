/**********************************************************************************
 * File-name - DfAttachedFileServiceImpl
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

package com.srmri.plato.core.discussionforum.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.discussionforum.dao.DfAttachedFileDao;
import com.srmri.plato.core.discussionforum.dao.DfModeratorAssignedDao;
import com.srmri.plato.core.discussionforum.entity.DfAttachedFile;
import com.srmri.plato.core.discussionforum.service.DfAttachedFileService;

@Service("attachedFileService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DfAttachedFileServiceImpl implements DfAttachedFileService{
	
	@Autowired
	private DfAttachedFileDao attachedFileDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Long df_s_addAttachedFile(DfAttachedFile attachedFile) {
		// TODO Auto-generated method stub
		return attachedFileDao.df_d_addAttachedFile(attachedFile);
	}

	/*
	 * Method definition
	 * Remove Attached File
	 */
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void df_s_removeAttachedFile(Long fileId) {
		// TODO Auto-generated method stub
		attachedFileDao.df_d_removeAttachedFile(fileId);
	}

	@Override
	public DfAttachedFile df_s_getAttachedFile(Long fileId) {
		// TODO Auto-generated method stub
		return attachedFileDao.df_d_getAttachedFile(fileId);
		
	}
}
