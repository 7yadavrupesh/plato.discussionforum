package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmStudentCourses;

public interface PcmStudentCourseService 
{
	void blAddStudentCourse(PcmStudentCourses studentCourse);

	List<PcmStudentCourses> blListsAllStudentCourses();
	
	PcmStudentCourses blGetStudentCourse(long studentCourseId);
	
	void blDeleteStudentCourse(PcmStudentCourses studentCourse);

	long blGetStudentCourseId(PcmStudentCourses studentCourse);


}
