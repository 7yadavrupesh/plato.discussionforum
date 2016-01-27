package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseCategories;


public interface PcmCourseCategoriesService 
{
	void blAddCourseCategory(PcmCourseCategories courseCategory);

	List<PcmCourseCategories> blListsAllCourseCategories();
	
	PcmCourseCategories blGetCourseCategory(long courseCategoryId);
	
	void blDeleteCourseCategory(PcmCourseCategories courseCategory);

	long blGetCourseCategoryId(PcmCourseCategories courseCategory);

}
