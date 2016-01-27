package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseTypeDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseType;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmCourseTypeService;

public class PcmCourseTypeServiceImpl implements PcmCourseTypeService
{
	@Autowired
	private PcmCourseTypeDao courseTypeDao;
	
	@Transactional
	@Override
	public void blAddCourseType(PcmCourseType courseType) 
	{
		courseTypeDao.dAddCourseType(courseType);
		
	}

	@Override
	public List<PcmCourseType> blListsAllCoursesTypes() 
	{
		
		return courseTypeDao.dGetListOfAllCourseTypes();
	}

	@Override
	public PcmCourseType blGetCourseType(long courseTypeId) 
	{
		
		return courseTypeDao.dGetCourseType(courseTypeId);
	}

	@Override
	public long blGetCourseTypeId(PcmCourseType courseType) 
	{
		
		return courseTypeDao.dGetCourseTypeId(courseType);
	}

	@Override
	public void blDeleteCourseType(PcmCourseType courseType) 
	{
		courseTypeDao.dDeleteCourseType(courseType);
	
	}

}
