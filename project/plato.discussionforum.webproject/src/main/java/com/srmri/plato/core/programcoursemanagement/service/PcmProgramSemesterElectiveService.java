package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramSemesterElectives;

public interface PcmProgramSemesterElectiveService 
{
	void blAddProgramSemesterElective(PcmProgramSemesterElectives programSemesterElective);

	List<PcmProgramSemesterElectives> blListsAllProgramSemesterElectives();
	
	PcmProgramSemesterElectives blGetProgramSemesterElective(long programSemesterElectiveId);
	
	void blDeleteProgramSemesterElective(PcmProgramSemesterElectives programSemesterElective);

	long blGetProgramSemesterElectiveId(PcmProgramSemesterElectives programSemesterElective);

}
