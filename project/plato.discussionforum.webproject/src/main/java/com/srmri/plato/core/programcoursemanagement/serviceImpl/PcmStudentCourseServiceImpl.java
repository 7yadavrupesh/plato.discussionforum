package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmStudentCoursesDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmStudentCourses;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmStudentCourseService;

public class PcmStudentCourseServiceImpl implements PcmStudentCourseService
{
	@Autowired
	private PcmStudentCoursesDao studentCourseDao;
	
	
	@Override
	public void blAddStudentCourse(PcmStudentCourses studentCourse) 
	{
		studentCourseDao.dAddStudentCourses(studentCourse);
		
	}

	@Override
	public List<PcmStudentCourses> blListsAllStudentCourses() 
	{
		
		return studentCourseDao.dGetListOfAllStudentCourses();
	}

	@Override
	public PcmStudentCourses blGetStudentCourse(long studentCourseId) 
	{	
		return studentCourseDao.dGetStudentCourses(studentCourseId);
	}

	@Override
	public long blGetStudentCourseId(PcmStudentCourses studentCourse) 
	{	
		return studentCourseDao.dGetStudentCoursesId(studentCourse);
	}

	@Override
	public void blDeleteStudentCourse(PcmStudentCourses studentCourse) 
	{
		studentCourseDao.dDeleteStudentCourses(studentCourse);
		
	}

}
