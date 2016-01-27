package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramCourseMap;

public interface PcmProgramCourseMapService 
{
	void blAddProgramCourseMap(PcmProgramCourseMap programCourseMap);

	List<PcmProgramCourseMap> blListsAllProgramCourseMaps();
	
	PcmProgramCourseMap blGetProgramCourseMap(long programCourseMapId);
	
	void blDeleteProgramCourseMap(PcmProgramCourseMap programCourseMap);

	long blGetProgramCourseMapId(PcmProgramCourseMap programCourseMap);

}
