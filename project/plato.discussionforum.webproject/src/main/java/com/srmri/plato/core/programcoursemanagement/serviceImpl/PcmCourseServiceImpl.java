package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourses;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmCourseService;

public class PcmCourseServiceImpl implements PcmCourseService
{
	@Autowired
	private PcmCourseDao courseDao;
	
	@Transactional
	@Override
	public void blAddCourse(PcmCourses course) 
	{
		courseDao.dAddCourse(course);
		
	}

	@Override
	public List<PcmCourses> blListsAllCourses() 
	{
		
		return courseDao.dGetListOfAllCourses();
	}

	@Override
	public PcmCourses blGetCourse(long courseId) 
	{
		
		return courseDao.dGetCourse(courseId);
	}

	
	
	@Override
	public long blGetCourseId(PcmCourses course) 
	{
		
		return courseDao.dGetCourseId(course);
	}

	@Override
	public void blDeleteCourse(PcmCourses course) 
	{
		courseDao.dDeleteCourse(course);
		
	}

	@Override
	public PcmCourses blGetCourse(String courseCode)
	{
	
		return courseDao.dGetCourse(courseCode);
	}

}
