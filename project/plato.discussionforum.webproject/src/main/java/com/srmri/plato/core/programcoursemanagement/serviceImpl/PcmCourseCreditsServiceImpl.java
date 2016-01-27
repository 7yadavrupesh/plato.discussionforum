package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseCreditsDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseCredits;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmCourseCreditsService;

public class PcmCourseCreditsServiceImpl implements PcmCourseCreditsService
{
	@Autowired
	private PcmCourseCreditsDao courseCreditsDao;
	
	@Transactional
	@Override
	public void blAddCourseCredit(PcmCourseCredits courseCredit) 
	{
		
		courseCreditsDao.dAddCourseCredit(courseCredit);
	}

	@Override
	public List<PcmCourseCredits> blListsAllCourseCredits() 
	{
		
		return courseCreditsDao.dGetListOfAllCourseCredits();
	}

	@Override
	public PcmCourseCredits blGetCourseCredit(long courseCreditId) 
	{
		
		return courseCreditsDao.dGetCourseCredit(courseCreditId);
	}
	
	@Override
	public long blGetCourseCreditId(PcmCourseCredits courseCredit) 
	{
		
		return courseCreditsDao.dGetCourseCreditId(courseCredit);
	}

	

	@Override
	public void blDeleteCourseCredit(PcmCourseCredits courseCredit) 
	{
		courseCreditsDao.dDeleteCourseCredit(courseCredit);
		
	}

	

}
