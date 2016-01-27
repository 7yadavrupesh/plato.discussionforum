package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmFacultyCourseMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmFacultyCourseMap;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmFacultyCourseMapService;

public class PcmFacultyCourseMapServiceImpl implements PcmFacultyCourseMapService
{
	
	@Autowired
	private PcmFacultyCourseMapDao facultyCourseMapDao;
	

	@Override
	public void blAddFacultyCourseMap(PcmFacultyCourseMap facultyCourseMap) 
	{
		facultyCourseMapDao.dAddFacultyCourseMap(facultyCourseMap);
		
	}

	@Override
	public List<PcmFacultyCourseMap> blListsAllFacultyCourseMaps() 
	{
		
		return facultyCourseMapDao.dGetListOfAllFacultyCourseMap();
	}

	@Override
	public PcmFacultyCourseMap blGetFacultyCourseMap(long facultyCourseMapId) 
	{
		
		return facultyCourseMapDao.dGetFacultyCourseMap(facultyCourseMapId);
	}

	@Override
	public long blGetFacultyCourseMapId(PcmFacultyCourseMap facultyCourseMap) 
	{
		
		return facultyCourseMapDao.dGetFacultyCourseMapId(facultyCourseMap);
	}

	@Override
	public void blDeleteFacultyCourseMap(PcmFacultyCourseMap facultyCourseMap) 
	{
		facultyCourseMapDao.dDeleteFacultyCourseMap(facultyCourseMap);
		
	}

}
