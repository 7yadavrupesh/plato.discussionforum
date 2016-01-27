package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmPrograms;

public interface PcmProgramService 
{
	void blAddProgram(PcmPrograms program);

	List<PcmPrograms> blListsAllPrograms();
	
	PcmPrograms blGetProgram(long programId);
	
	PcmPrograms blGetProgram(String programCode);
	
	void blDeleteProgram(PcmPrograms program);

	long blGetProgramId(PcmPrograms program);


}
