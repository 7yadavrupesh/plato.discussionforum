package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmPrograms;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmProgramService;

public class PcmProgramServiceImpl implements PcmProgramService
{
	@Autowired
	private PcmProgramDao programDao;
	
	@Override
	public void blAddProgram(PcmPrograms program) 
	{
		programDao.dAddProgram(program);
		
	}

	@Override
	public List<PcmPrograms> blListsAllPrograms() 
	{
		
		return programDao.dGetListOfAllPrograms();
	}

	@Override
	public PcmPrograms blGetProgram(long programId) 
	{
		
		return programDao.dGetProgram(programId);
	}

	
	
	@Override
	public long blGetProgramId(PcmPrograms program) 
	{
		
		return programDao.dGetProgramId(program);
	}

	@Override
	public void blDeleteProgram(PcmPrograms program) 
	{
		programDao.dDeleteProgram(program);
		
	}

	@Override
	public PcmPrograms blGetProgram(String programCode) 
	{
		
		return programDao.dGetProgram(programCode);
	}

}
