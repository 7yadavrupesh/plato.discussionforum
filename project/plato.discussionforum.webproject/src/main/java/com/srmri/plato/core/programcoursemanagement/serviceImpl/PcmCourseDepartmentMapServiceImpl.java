package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseDepartmentMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseDepartmentMap;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmCourseDepartmentMapService;

public class PcmCourseDepartmentMapServiceImpl implements PcmCourseDepartmentMapService
{
	@Autowired
	private PcmCourseDepartmentMapDao courseDepartmentMapDao;
	
	@Transactional
	@Override
	public void blAddCourseDepartmentMap(PcmCourseDepartmentMap courseDepartmentMap) 
	{
		courseDepartmentMapDao.dAddCourseDepartmentMap(courseDepartmentMap);
		
	}

	@Override
	public List<PcmCourseDepartmentMap> blListsAllCourseDepartmentMaps() 
	{
		
		return courseDepartmentMapDao.dGetListOfAllCourseDepartmentMap();
	}

	@Override
	public PcmCourseDepartmentMap blGetCourseDepartmentMap(long courseDepartmentMapId) 
	{
		
		return courseDepartmentMapDao.dGetCourseDepartmentMap(courseDepartmentMapId);
	}

	@Override
	public long blGetCourseDepartmentMapId(PcmCourseDepartmentMap courseDepartmentMap) 
	{
		
		return courseDepartmentMapDao.dGetCourseDepartmentMapId(courseDepartmentMap);
	}

	@Override
	public void blDeleteCourseDepartmentMap(PcmCourseDepartmentMap courseDepartmentMap) 
	{
		courseDepartmentMapDao.dDeleteCourseDepartmentMap(courseDepartmentMap);	
		
	}

}
