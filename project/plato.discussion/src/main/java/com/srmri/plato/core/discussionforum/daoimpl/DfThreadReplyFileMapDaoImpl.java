package com.srmri.plato.core.discussionforum.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srmri.plato.core.discussionforum.dao.DfAttachedFileDao;
import com.srmri.plato.core.discussionforum.dao.DfThreadReplyFileMapDao;
import com.srmri.plato.core.discussionforum.entity.DfThreadReplyFileMap;

@Repository("dfThreadReplyFileMapDao")
public class DfThreadReplyFileMapDaoImpl implements DfThreadReplyFileMapDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private DfAttachedFileDao attachedFileDao;
	@Override
	public void dfDAddThreadReplyFileMap(DfThreadReplyFileMap trfm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(trfm);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<DfThreadReplyFileMap> dfDGetThreadReplyFileMapList(Long threadReplyId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadReplyFileMap.class);
		cri.add(Restrictions.eq("threadReplyId", threadReplyId));
		return cri.list();
	}

	@Override
	public List<Long> dfDGetFileList(Long threadReplyId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadReplyFileMap.class);
		cri.add(Restrictions.eq("threadReplyId", threadReplyId));
		List<DfThreadReplyFileMap> objList = cri.list();

		List<Long> fileIdList = new ArrayList<Long>();
		
		if(!objList.isEmpty() || objList != null )
		{
			for(DfThreadReplyFileMap obj: objList){
				fileIdList.add(obj.getFileId());
			}
		}
		return fileIdList;
	}

	@Override
	public void dfDRemoveThreadReplyFileMap(DfThreadReplyFileMap trfm) {
		// TODO Auto-generated method stub
		Long fileIdForDelete = trfm.getFileId();
		sessionFactory.getCurrentSession().delete(trfm);
		sessionFactory.getCurrentSession().flush();
		attachedFileDao.dfDRemoveAttachedFile(fileIdForDelete);
	}

	@Override
	public DfThreadReplyFileMap dfDGetThreadReplyFileMap(Long fileId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadReplyFileMap.class);
		cri.add(Restrictions.eq("fileId", fileId));
		List<DfThreadReplyFileMap> objList = cri.list();
		if(objList.isEmpty())
			return null;
		else
			return objList.get(0);
	}

	@Override
	public void dfDRemoveThreadReplyFileMap(Long fileId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadReplyFileMap.class);
		cri.add(Restrictions.eq("fileId", fileId));
		DfThreadReplyFileMap obj = (DfThreadReplyFileMap) cri.list().get(0);
		Long fileIdForDelete = obj.getFileId();
		if(obj == null)
			return ;
		else
		{
			sessionFactory.getCurrentSession().delete(obj);
			sessionFactory.getCurrentSession().flush();
			attachedFileDao.dfDRemoveAttachedFile(fileIdForDelete);
		}
		
		
	}

}
