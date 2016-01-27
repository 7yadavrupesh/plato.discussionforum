package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmDepartmentSchoolMap;

public interface PcmDepartmentSchoolMapService 
{
	void blAddDepartmentSchoolMap(PcmDepartmentSchoolMap departmentSchoolMap);

	List<PcmDepartmentSchoolMap> blListsAllDepartmentSchoolMaps();
	
	PcmDepartmentSchoolMap blGetDepartmentSchoolMap(long departmentSchoolMapId);
	
	void blDeleteDepartmentSchoolMap(PcmDepartmentSchoolMap departmentSchoolMap);

	long blGetDepartmentSchoolMapId(PcmDepartmentSchoolMap departmentSchoolMap);

}
