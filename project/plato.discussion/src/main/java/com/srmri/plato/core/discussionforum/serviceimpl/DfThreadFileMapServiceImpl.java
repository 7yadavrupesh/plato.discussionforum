package com.srmri.plato.core.discussionforum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.discussionforum.dao.DfThreadFileMapDao;
import com.srmri.plato.core.discussionforum.entity.DfThreadFileMap;
import com.srmri.plato.core.discussionforum.service.DfThreadFileMapService;


@Service("threadFileMapService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DfThreadFileMapServiceImpl implements DfThreadFileMapService{

	@Autowired
	private DfThreadFileMapDao threadFileMapDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void df_s_addThreadFileMap(DfThreadFileMap threadFileMap) {
		// TODO Auto-generated method stub
		threadFileMapDao.df_d_addThreadFileMap(threadFileMap);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void df_s_removeThreadFileMap(DfThreadFileMap threadFileMap) {
		// TODO Auto-generated method stub
		threadFileMapDao.df_d_removeThreadFileMap(threadFileMap);
	}

	@Override
	public List<DfThreadFileMap> df_s_getTheadFileMapList(Long threadId) {
		// TODO Auto-generated method stub
		return threadFileMapDao.df_d_getTheadFileMapList(threadId);
	}

	@Override
	public List<Long> df_s_getFileList(Long threadId) {
		// TODO Auto-generated method stub
		return threadFileMapDao.df_d_getFileList(threadId);
	}

	@Override
	public DfThreadFileMap df_s_getThreadFileMap(Long fileId) {
		// TODO Auto-generated method stub
		return threadFileMapDao.df_d_getThreadFileMap(fileId);
	}

	@Override
	public void df_s_addThreadFileMap(Long threadId, Long uploadedFileId) {
		// TODO Auto-generated method stub
		threadFileMapDao.df_d_addThreadFileMap(threadId,uploadedFileId);
	}
}
