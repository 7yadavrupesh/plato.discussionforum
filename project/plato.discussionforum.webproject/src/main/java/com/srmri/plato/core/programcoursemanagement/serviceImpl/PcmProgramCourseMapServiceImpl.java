package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramCourseMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramCourseMap;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmProgramCourseMapService;

public class PcmProgramCourseMapServiceImpl implements PcmProgramCourseMapService
{
	@Autowired
	private PcmProgramCourseMapDao programCourseMapDao;
	
	@Override
	public void blAddProgramCourseMap(PcmProgramCourseMap programCourseMap) 
	{		
		programCourseMapDao.dAddProgramCourseMap(programCourseMap);
	}

	@Override
	public List<PcmProgramCourseMap> blListsAllProgramCourseMaps() 
	{
		
		return programCourseMapDao.dGetListOfAllProgramCourseMap()
				;
	}

	@Override
	public PcmProgramCourseMap blGetProgramCourseMap(long programCourseMapId) 
	{
		return programCourseMapDao.dGetProgramCourseMap(programCourseMapId);
		 
	}

	@Override
	public long blGetProgramCourseMapId(PcmProgramCourseMap programCourseMap) 
	{
		
		return programCourseMapDao.dGetProgramCourseMapId(programCourseMap);
	}

	@Override
	public void blDeleteProgramCourseMap(PcmProgramCourseMap programCourseMap) 
	{
		
		programCourseMapDao.dDeleteProgramCourseMap(programCourseMap);
	}

}
