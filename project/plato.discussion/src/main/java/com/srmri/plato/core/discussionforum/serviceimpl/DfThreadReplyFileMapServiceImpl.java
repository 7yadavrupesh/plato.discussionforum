package com.srmri.plato.core.discussionforum.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.srmri.plato.core.discussionforum.dao.DfThreadReplyFileMapDao;
import com.srmri.plato.core.discussionforum.entity.DfThreadReplyFileMap;
import com.srmri.plato.core.discussionforum.service.DfThreadReplyFileMapService;

@Service("threadReplyFileMapService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DfThreadReplyFileMapServiceImpl implements DfThreadReplyFileMapService {

	@Autowired
	private DfThreadReplyFileMapDao threadReplyFileMapDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void dfSSetThreadReplyFileMapList(DfThreadReplyFileMap trfm) {
		// TODO Auto-generated method stub
		threadReplyFileMapDao.dfDAddThreadReplyFileMap(trfm);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void dfSRemoveThreadReplyFileMapList(DfThreadReplyFileMap trfm) {
		// TODO Auto-generated method stub
		threadReplyFileMapDao.dfDRemoveThreadReplyFileMap(trfm);
	}

	@Override
	public List<DfThreadReplyFileMap> dfSGetThreadReplyFileMapList(Long threadReplyId) {
		// TODO Auto-generated method stub
		return threadReplyFileMapDao.dfDGetThreadReplyFileMapList(threadReplyId);
	}

	@Override
	public List<Long> dfSGetFileList(Long threadReplyId) {
		// TODO Auto-generated method stub
		
		return threadReplyFileMapDao.dfDGetFileList(threadReplyId);
	}

	@Override
	public DfThreadReplyFileMap dfSGetThreadReplyFileMap(Long fileId) {
		// TODO Auto-generated method stub
		return threadReplyFileMapDao.dfDGetThreadReplyFileMap(fileId);
	}

	@Override
	public void dfSSetThreadReplyFileMapList(Long replyId, Long uploadedFileId) {
		// TODO Auto-generated method stub
		DfThreadReplyFileMap obj = new DfThreadReplyFileMap();
		obj.setFileId(uploadedFileId);
		obj.setThreadReplyId(replyId);
		threadReplyFileMapDao.dfDAddThreadReplyFileMap(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void dfSRemoveThreadReplyFileMapList(Long fileId) {
		// TODO Auto-generated method stub
		threadReplyFileMapDao.dfDRemoveThreadReplyFileMap(fileId);
	}

}
