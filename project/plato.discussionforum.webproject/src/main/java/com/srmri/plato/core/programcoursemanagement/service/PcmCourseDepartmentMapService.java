package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseDepartmentMap;

public interface PcmCourseDepartmentMapService 
{
	void blAddCourseDepartmentMap(PcmCourseDepartmentMap courseDepartmentMap);

	List<PcmCourseDepartmentMap> blListsAllCourseDepartmentMaps();
	
	PcmCourseDepartmentMap blGetCourseDepartmentMap(long courseDepartmentMapId);

	
	void blDeleteCourseDepartmentMap(PcmCourseDepartmentMap courseDepartmentMap);

	long blGetCourseDepartmentMapId(PcmCourseDepartmentMap courseDepartmentMap);

}
