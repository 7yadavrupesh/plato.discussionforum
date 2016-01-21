package com.srmri.plato.core.discussionforum.service;

import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfThreadReplyFileMap;

public interface DfThreadReplyFileMapService {
	void dfSSetThreadReplyFileMapList(DfThreadReplyFileMap trfm);
	List<DfThreadReplyFileMap> dfSGetThreadReplyFileMapList(Long threadReplyId); 
	List<Long> dfSGetFileList(Long threadReplyId);
	void dfSRemoveThreadReplyFileMapList(DfThreadReplyFileMap trfm);
	DfThreadReplyFileMap dfSGetThreadReplyFileMap(Long fileId);
	void dfSSetThreadReplyFileMapList(Long replyId, Long uploadedFileId);
	void dfSRemoveThreadReplyFileMapList(Long fileId);
}
