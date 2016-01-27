package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmElectiveCourses;

public interface PcmElectiveCourseService 
{
	void blAddElectiveCourse(PcmElectiveCourses electiveCourse);

	List<PcmElectiveCourses> blListsAllElectiveCourses();
	
	PcmElectiveCourses blGetElectiveCourse(long electiveCourseId);
	
	void blDeleteElectiveCourse(PcmElectiveCourses electiveCourse);

	long blGetElectiveCourseId(PcmElectiveCourses electiveCourse);

}
