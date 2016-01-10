package com.srmri.plato.core.discussionforum.service;

import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfThreadReplyFileMap;

public interface DfThreadReplyFileMapService {
	void df_s_setThreadReplyFileMapList(DfThreadReplyFileMap trfm);
	List<DfThreadReplyFileMap> df_s_getThreadReplyFileMapList(Long threadReplyId); 
	List<Long> df_s_getFileList(Long threadReplyId);
	void df_s_removeThreadReplyFileMapList(DfThreadReplyFileMap trfm);
	DfThreadReplyFileMap df_s_getThreadReplyFileMap(Long fileId);
	void df_s_setThreadReplyFileMapList(Long replyId, Long uploadedFileId);
	void df_s_removeThreadReplyFileMapList(Long fileId);
}
