package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmProgramLevelDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramLevel;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmProgramLevelService;

public class PcmProgramLevelServiceImpl implements PcmProgramLevelService
{
	
	@Autowired
	private PcmProgramLevelDao programLevelDao;
	
	
	@Override
	public void blAddProgramLevel(PcmProgramLevel programLevel) 
	{
		programLevelDao.dAddProgramLevel(programLevel);
		
	}

	@Override
	public List<PcmProgramLevel> blListsAllProgramLevels() {
		
		return programLevelDao.dGetListOfAllProgramLevel()
				;
	}

	@Override
	public PcmProgramLevel blGetProgramLevel(long programLevelId) 
	{
		
		return programLevelDao.dGetProgramLevel(programLevelId);
	}

	
	
	@Override
	public long blGetProgramLevelId(PcmProgramLevel programLevel) 
	{
		
		return programLevelDao.dGetProgramLevelId(programLevel);
	}

	@Override
	public void blDeleteProgramLevel(PcmProgramLevel programLevel) 
	{
		
		programLevelDao.dDeleteProgramLevel(programLevel);
	}

}
