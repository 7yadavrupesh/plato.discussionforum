package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramSemesterYear;

public interface PcmProgramSemesterYearService 
{
	void blAddProgramSemesterYear(PcmProgramSemesterYear programSemesterYear);

	List<PcmProgramSemesterYear> blListsAllProgramSemesterYear();
	
	PcmProgramSemesterYear blGetProgramSemesterYear(long programSemesterYearId);
	
	void blDeleteProgramSemesterYear(PcmProgramSemesterYear programSemesterYear);

	long blGetProgramSemesterYearId(PcmProgramSemesterYear programSemesterYear);


}
