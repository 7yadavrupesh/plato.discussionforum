package com.srmri.plato.core.discussionforum.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srmri.plato.core.discussionforum.dao.DfThreadReplyFileMapDao;
import com.srmri.plato.core.discussionforum.entity.DfThreadReplyFileMap;

@Repository("dfThreadReplyFileMapDao")
public class DfThreadReplyFileMapDaoImpl implements DfThreadReplyFileMapDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void df_d_addThreadReplyFileMap(DfThreadReplyFileMap trfm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(trfm);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public List<DfThreadReplyFileMap> df_d_getThreadReplyFileMapList(Long threadReplyId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadReplyFileMap.class);
		cri.add(Restrictions.eq("threadReplyId", threadReplyId));
		return cri.list();
	}

	@Override
	public List<Long> df_d_getFileList(Long threadReplyId) {
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
	public void df_d_removeThreadReplyFileMap(DfThreadReplyFileMap trfm) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(trfm);
		sessionFactory.getCurrentSession().flush();
	}

	@Override
	public DfThreadReplyFileMap df_d_getThreadReplyFileMap(Long fileId) {
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
	public void df_d_removeThreadReplyFileMap(Long fileId) {
		// TODO Auto-generated method stub
		Criteria cri = sessionFactory.getCurrentSession().createCriteria(DfThreadReplyFileMap.class);
		cri.add(Restrictions.eq("fileId", fileId));
		List<DfThreadReplyFileMap> objList = cri.list();
		if(objList.isEmpty())
			return ;
		else
		{
			sessionFactory.getCurrentSession().delete(objList.get(0));
			sessionFactory.getCurrentSession().flush();
		}
		sessionFactory.getCurrentSession().flush();
	}

}
