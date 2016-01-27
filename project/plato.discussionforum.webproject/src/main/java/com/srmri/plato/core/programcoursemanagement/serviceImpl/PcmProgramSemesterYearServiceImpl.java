package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramSemesterYearDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramSemesterYear;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmProgramSemesterYearService;

public class PcmProgramSemesterYearServiceImpl implements PcmProgramSemesterYearService
{
	
	@Autowired
	private PcmProgramSemesterYearDao programSemsterYearDao;
	

	@Override
	public void blAddProgramSemesterYear(PcmProgramSemesterYear programSemesterYear) 
	{
		programSemsterYearDao.dAddProgramSemesterYear(programSemesterYear);
		
	}

	@Override
	public List<PcmProgramSemesterYear> blListsAllProgramSemesterYear() 
	{
		
		return programSemsterYearDao.dGetListOfAllProgramSemesterYear()
				;
	}

	@Override
	public PcmProgramSemesterYear blGetProgramSemesterYear(long programSemesterYearId) 
	{
		
		return programSemsterYearDao.dGetProgramSemesterYear(programSemesterYearId);
	}

	@Override
	public long blGetProgramSemesterYearId(PcmProgramSemesterYear programSemesterYear) 
	{
		
		return programSemsterYearDao.dGetProgramSemesterYearId(programSemesterYear);
	}

	@Override
	public void blDeleteProgramSemesterYear(PcmProgramSemesterYear programSemesterYear) 
	{
		
		programSemsterYearDao.dDeleteProgramSemesterYear(programSemesterYear);
	}

}
