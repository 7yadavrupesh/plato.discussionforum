package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramLevel;

public interface PcmProgramLevelService 
{
	void blAddProgramLevel(PcmProgramLevel programLevel);

	List<PcmProgramLevel> blListsAllProgramLevels();
	
	PcmProgramLevel blGetProgramLevel(long programLevelId);
	
	void blDeleteProgramLevel(PcmProgramLevel programLevel);

	long blGetProgramLevelId(PcmProgramLevel programLevel);


}
