package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseType;

public interface PcmCourseTypeService 
{
	void blAddCourseType(PcmCourseType courseType);

	List<PcmCourseType> blListsAllCoursesTypes();
	
	PcmCourseType blGetCourseType(long courseTypeId);
	
	void blDeleteCourseType(PcmCourseType courseType);

	long blGetCourseTypeId(PcmCourseType courseType);

}
