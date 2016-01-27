package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmDepartments;

public interface PcmDepartmentService 
{
	void blAddDepartment(PcmDepartments department);

	List<PcmDepartments> blListsAllDepartments();
	
	PcmDepartments blGetDepartment(long departmentId);
	
	void blDeleteDepartment(PcmDepartments department);

	long blGetDepartmentId(PcmDepartments department);


}
