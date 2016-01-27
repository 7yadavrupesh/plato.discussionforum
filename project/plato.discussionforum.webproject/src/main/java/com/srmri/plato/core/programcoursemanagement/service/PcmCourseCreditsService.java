package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseCredits;

public interface PcmCourseCreditsService 
{
	void blAddCourseCredit(PcmCourseCredits courseCredit);

	List<PcmCourseCredits> blListsAllCourseCredits();
	
	PcmCourseCredits blGetCourseCredit(long courseCreditId);

	
	void blDeleteCourseCredit(PcmCourseCredits courseCredit);

	long blGetCourseCreditId(PcmCourseCredits courseCredit);

}
