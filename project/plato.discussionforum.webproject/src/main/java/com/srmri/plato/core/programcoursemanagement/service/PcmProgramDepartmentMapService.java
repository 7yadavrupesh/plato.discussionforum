package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramDepartmentMap;

public interface PcmProgramDepartmentMapService 
{
	void blAddProgramDepartmentMap(PcmProgramDepartmentMap programDepartmentMap);

	List<PcmProgramDepartmentMap> blListsAllProgramDepartmentMaps();
	
	PcmProgramDepartmentMap blGetProgramDepartmentMap(long programDepartmentMapId);
	
	void blDeleteProgramDepartmentMap(PcmProgramDepartmentMap programDepartmentMap);

	long blGetProgramDepartmentMapId(PcmProgramDepartmentMap programDepartmentMap);

}
