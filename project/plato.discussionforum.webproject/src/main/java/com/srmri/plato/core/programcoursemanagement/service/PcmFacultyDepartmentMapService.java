package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmFacultyDepartmentMap;

public interface PcmFacultyDepartmentMapService 
{
	void blAddFacultyDepartmentMap(PcmFacultyDepartmentMap facultyDepartmentMap);

	List<PcmFacultyDepartmentMap> blListsAllFacultyDepartmentMaps();
	
	PcmFacultyDepartmentMap blGetFacultyDepartmentMap(long facultyDepartmentMapId);
	
	long blGetFacultyDepartmentMapId(String facultyDepartmentMap);
	
	void blDeleteFacultyDepartmentMap(PcmFacultyDepartmentMap facultyDepartmentMap);


}
