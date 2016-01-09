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
	void df_d_addThreadReplyFileMap(DfThreadReplyFileMap trfm);
	List<DfThreadReplyFileMap> df_d_getThreadReplyFileMapList(Long threadReplyId); 
	List<Long> df_d_getFileList(Long threadReplyId);
	void df_d_removeThreadReplyFileMap(DfThreadReplyFileMap trfm);
	DfThreadReplyFileMap df_d_getThreadReplyFileMap(Long fileId);
}
