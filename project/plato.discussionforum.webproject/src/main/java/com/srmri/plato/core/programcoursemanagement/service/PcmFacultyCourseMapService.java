package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmFacultyCourseMap;

public interface PcmFacultyCourseMapService 
{
	void blAddFacultyCourseMap(PcmFacultyCourseMap facultyCourseMap);

	List<PcmFacultyCourseMap> blListsAllFacultyCourseMaps();
	
	PcmFacultyCourseMap blGetFacultyCourseMap(long facultyCourseMapId);
	
	void blDeleteFacultyCourseMap(PcmFacultyCourseMap facultyCourseMap);

	long blGetFacultyCourseMapId(PcmFacultyCourseMap facultyCourseMap);


}
