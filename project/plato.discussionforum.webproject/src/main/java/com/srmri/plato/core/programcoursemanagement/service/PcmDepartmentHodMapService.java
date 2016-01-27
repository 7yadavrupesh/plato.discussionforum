package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmDepartmentHodMap;

public interface PcmDepartmentHodMapService 
{
	void blAddDepartmentHodMap(PcmDepartmentHodMap departmentHodMap);

	List<PcmDepartmentHodMap> blListsAllDepartmentHodMaps();
	
	PcmDepartmentHodMap blGetDepartmentHodMap(long departmentHodMapId);
	
	void blDeleteDepartmentHodMap(PcmDepartmentHodMap departmentHodMap);

	long blGetDepartmentHodMapId(PcmDepartmentHodMap departmentHodMap);

}
