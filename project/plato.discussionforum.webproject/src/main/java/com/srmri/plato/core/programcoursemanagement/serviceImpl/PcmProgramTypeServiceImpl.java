package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramTypeDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramType;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmProgramTypeService;

public class PcmProgramTypeServiceImpl implements PcmProgramTypeService
{
	@Autowired
	private PcmProgramTypeDao programTypeDao;
	
	@Override
	public void blAddProgramType(PcmProgramType programType) 
	{
		programTypeDao.dAddProgramType(programType);
		
	}

	@Override
	public List<PcmProgramType> blListsAllProgramType() 
	{
		
		return programTypeDao.dGetListOfAllProgramType();
	}

	@Override
	public PcmProgramType blGetProgramType(long programTypeId) 
	{
		
		return programTypeDao.dGetProgramType(programTypeId);
	}

	
	@Override
	public long blGetProgramTypeId(PcmProgramType programType) 
	{
		
		return programTypeDao.dGetProgramTypeId(programType);
	}

	@Override
	public void blDeleteProgramType(PcmProgramType programType) 
	{
		
		programTypeDao.dDeleteProgramType(programType);
	}

}
