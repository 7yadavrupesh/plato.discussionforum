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
	public void dfSAddThreadFileMap(DfThreadFileMap threadFileMap) {
		// TODO Auto-generated method stub
		threadFileMapDao.dfDAddThreadFileMap(threadFileMap);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void dfSRemoveThreadFileMap(DfThreadFileMap threadFileMap) {
		// TODO Auto-generated method stub
		threadFileMapDao.dfDRemoveThreadFileMap(threadFileMap);
	}

	@Override
	public List<DfThreadFileMap> dfSGetTheadFileMapList(Long threadId) {
		// TODO Auto-generated method stub
		return threadFileMapDao.dfDGetTheadFileMapList(threadId);
	}

	@Override
	public List<Long> dfSGetFileList(Long threadId) {
		// TODO Auto-generated method stub
		return threadFileMapDao.dfDGetFileList(threadId);
	}

	@Override
	public DfThreadFileMap dfSGetThreadFileMap(Long fileId) {
		// TODO Auto-generated method stub
		return threadFileMapDao.dfDGetThreadFileMap(fileId);
	}

	@Override
	public void dfSAddThreadFileMap(Long threadId, Long uploadedFileId) {
		// TODO Auto-generated method stub
		threadFileMapDao.dfDAddThreadFileMap(threadId,uploadedFileId);
	}
	

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void dfSRemoveThreadFileMap(Long c) {
		// TODO Auto-generated method stub
		threadFileMapDao.dfDRemoveThreadFileMap(c);
	}
}
