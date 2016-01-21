/**
 * 
 */
package com.srmri.plato.core.discussionforum.dao;

import java.util.List;

import com.srmri.plato.core.discussionforum.entity.DfThreadReplyFileMap;

/**
 * @author ethan
 *
 */
public interface DfThreadReplyFileMapDao {
	void dfDAddThreadReplyFileMap(DfThreadReplyFileMap trfm);
	List<DfThreadReplyFileMap> dfDGetThreadReplyFileMapList(Long threadReplyId); 
	List<Long> dfDGetFileList(Long threadReplyId);
	void dfDRemoveThreadReplyFileMap(DfThreadReplyFileMap trfm);
	DfThreadReplyFileMap dfDGetThreadReplyFileMap(Long fileId);
	void dfDRemoveThreadReplyFileMap(Long fileId);
}
