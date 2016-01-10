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
	public void df_s_setThreadReplyFileMapList(DfThreadReplyFileMap trfm) {
		// TODO Auto-generated method stub
		threadReplyFileMapDao.df_d_addThreadReplyFileMap(trfm);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void df_s_removeThreadReplyFileMapList(DfThreadReplyFileMap trfm) {
		// TODO Auto-generated method stub
		threadReplyFileMapDao.df_d_removeThreadReplyFileMap(trfm);
	}

	@Override
	public List<DfThreadReplyFileMap> df_s_getThreadReplyFileMapList(Long threadReplyId) {
		// TODO Auto-generated method stub
		return threadReplyFileMapDao.df_d_getThreadReplyFileMapList(threadReplyId);
	}

	@Override
	public List<Long> df_s_getFileList(Long threadReplyId) {
		// TODO Auto-generated method stub
		
		return threadReplyFileMapDao.df_d_getFileList(threadReplyId);
	}

	@Override
	public DfThreadReplyFileMap df_s_getThreadReplyFileMap(Long fileId) {
		// TODO Auto-generated method stub
		return threadReplyFileMapDao.df_d_getThreadReplyFileMap(fileId);
	}

	@Override
	public void df_s_setThreadReplyFileMapList(Long replyId, Long uploadedFileId) {
		// TODO Auto-generated method stub
		DfThreadReplyFileMap obj = new DfThreadReplyFileMap();
		obj.setFileId(uploadedFileId);
		obj.setThreadReplyId(replyId);
		threadReplyFileMapDao.df_d_addThreadReplyFileMap(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void df_s_removeThreadReplyFileMapList(Long fileId) {
		// TODO Auto-generated method stub
		threadReplyFileMapDao.df_d_removeThreadReplyFileMap(fileId);
	}

}
