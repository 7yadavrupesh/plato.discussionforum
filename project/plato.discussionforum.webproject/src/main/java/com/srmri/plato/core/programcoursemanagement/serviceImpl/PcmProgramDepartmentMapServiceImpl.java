package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramDepartmentMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramDepartmentMap;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmProgramDepartmentMapService;

public class PcmProgramDepartmentMapServiceImpl implements PcmProgramDepartmentMapService
{
	@Autowired
	private PcmProgramDepartmentMapDao programDepartmentMapDao;
	
	@Override
	public void blAddProgramDepartmentMap(PcmProgramDepartmentMap programDepartmentMap) 
	{
		programDepartmentMapDao.dAddProgramDepartmentMap(programDepartmentMap);
		
	}

	@Override
	public List<PcmProgramDepartmentMap> blListsAllProgramDepartmentMaps() {
		
		return programDepartmentMapDao.dGetListOfAllProgramDepartmentMap()
				;
	}

	@Override
	public PcmProgramDepartmentMap blGetProgramDepartmentMap(long programDepartmentMapId) {
		
		return programDepartmentMapDao.dGetProgramDepartmentMap(programDepartmentMapId);
	}

	@Override
	public long blGetProgramDepartmentMapId(PcmProgramDepartmentMap programDepartmentMap) 
	{
		
		return programDepartmentMapDao.dGetProgramDepartmentMapId(programDepartmentMap);
	}

	@Override
	public void blDeleteProgramDepartmentMap(PcmProgramDepartmentMap programDepartmentMap) 
	{
		
		programDepartmentMapDao.dDeleteProgramDepartmentMap(programDepartmentMap);
	}

}
