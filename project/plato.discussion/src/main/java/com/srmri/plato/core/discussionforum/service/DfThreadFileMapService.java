package com.srmri.plato.core.discussionforum.service;

import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfThreadFileMap;

public interface DfThreadFileMapService {
	void dfSAddThreadFileMap(DfThreadFileMap threadFileMap);
	void dfSRemoveThreadFileMap(DfThreadFileMap threadFileMap);
	List<DfThreadFileMap> dfSGetTheadFileMapList(Long threadId);
	List<Long> dfSGetFileList(Long threadId);
	DfThreadFileMap dfSGetThreadFileMap(Long fileId);
	void dfSAddThreadFileMap(Long threadId, Long uploadedFileId);
	void dfSRemoveThreadFileMap(Long c);
}
