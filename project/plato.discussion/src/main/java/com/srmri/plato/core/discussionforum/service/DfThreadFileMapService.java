package com.srmri.plato.core.discussionforum.service;

import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfThreadFileMap;

public interface DfThreadFileMapService {
	void df_s_addThreadFileMap(DfThreadFileMap threadFileMap);
	void df_s_removeThreadFileMap(DfThreadFileMap threadFileMap);
	List<DfThreadFileMap> df_s_getTheadFileMapList(Long threadId);
	List<Long> df_s_getFileList(Long threadId);
	DfThreadFileMap df_s_getThreadFileMap(Long fileId);
	void df_s_addThreadFileMap(Long threadId, Long uploadedFileId);
}
