package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmElectiveCoursesDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmElectiveCourses;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmElectiveCourseService;

public class PcmElectiveCourseServiceImpl implements PcmElectiveCourseService
{
	@Autowired
	private PcmElectiveCoursesDao electiveCourseDao;
	
	@Override
	public void blAddElectiveCourse(PcmElectiveCourses electiveCourse) 
	{
		electiveCourseDao.dAddelectiveCourse(electiveCourse);
		
	}

	@Override
	public List<PcmElectiveCourses> blListsAllElectiveCourses() 
	{
		
		return electiveCourseDao.dGetListOfAllElectiveCourse();
	}

	@Override
	public PcmElectiveCourses blGetElectiveCourse(long electiveCourseId) 
	{
		
		return electiveCourseDao.dGetElectiveCourse(electiveCourseId);
	}

	@Override
	public long blGetElectiveCourseId(PcmElectiveCourses electiveCourse) 
	{
		
		return electiveCourseDao.dGetElectiveCourseId(electiveCourse);
	}

	@Override
	public void blDeleteElectiveCourse(PcmElectiveCourses electiveCourse) 
	{
		
		electiveCourseDao.dDeleteElectiveCourse(electiveCourse);
	}

}
