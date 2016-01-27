package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmStudentElectives;

public interface PcmStudentElectiveService 
{
	void blAddStudentElective(PcmStudentElectives studentElective);

	List<PcmStudentElectives> blListsAllStudentElectives();
	
	PcmStudentElectives blGetStudentElective(long studentElectiveId);
	
	void blDeleteStudentElective(PcmStudentElectives studentElective);

	long blGetStudentElectiveId(PcmStudentElectives studentElective);

}
