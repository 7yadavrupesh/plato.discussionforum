package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramSemesterElectiveDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramSemesterElectives;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmProgramSemesterElectiveService;

public class PcmProgramSemesterElectiveServiceImpl implements PcmProgramSemesterElectiveService
{
	@Autowired
	private PcmProgramSemesterElectiveDao programSemsterElectiveDao;
	
	@Override
	public void blAddProgramSemesterElective(PcmProgramSemesterElectives programSemesterElective) 
	{
		programSemsterElectiveDao.dAddProgramSemesterElectives(programSemesterElective);
		
	}

	@Override
	public List<PcmProgramSemesterElectives> blListsAllProgramSemesterElectives() 
	{
		
		return programSemsterElectiveDao.dGetListOfAllProgramSemesterElectives()
				;
	}

	@Override
	public PcmProgramSemesterElectives blGetProgramSemesterElective(long programSemesterElectiveId) 
	{
		
		return programSemsterElectiveDao.dGetProgramSemesterElectives(programSemesterElectiveId);
	}

	@Override
	public long blGetProgramSemesterElectiveId(PcmProgramSemesterElectives programSemesterElective) 
	{
		
		return programSemsterElectiveDao.dGetProgramSemesterElectivesId(programSemesterElective);
	}

	@Override
	public void blDeleteProgramSemesterElective(PcmProgramSemesterElectives programSemesterElective) 
	{
		
		programSemsterElectiveDao.dDeleteProgramSemesterElectives(programSemesterElective);
	}

}
