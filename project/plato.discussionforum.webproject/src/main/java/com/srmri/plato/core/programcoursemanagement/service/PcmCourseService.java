package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourses;

public interface PcmCourseService 
{
	void blAddCourse(PcmCourses course);

	List<PcmCourses> blListsAllCourses();
	
	PcmCourses blGetCourse(long courseId);
	
	PcmCourses blGetCourse(String courseCode);
	
	void blDeleteCourse(PcmCourses course);

	long blGetCourseId(PcmCourses course);

}
