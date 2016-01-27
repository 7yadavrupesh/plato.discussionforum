package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmCourseCategoriesDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmCourseCategories;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmCourseCategoriesService;


public class PcmCourseCategoriesServiceImpl implements PcmCourseCategoriesService
{
	
	@Autowired
	private PcmCourseCategoriesDao courseCategoryDao;
	
	@Transactional
	@Override
	public void blAddCourseCategory(PcmCourseCategories courseCategory) 
	{
		courseCategoryDao.dAddCourseCategory(courseCategory);
		
	}

	@Override
	public List<PcmCourseCategories> blListsAllCourseCategories() 
	{
	
		return courseCategoryDao.dGetListOfAllCourseCategories();
	}

	@Override
	public PcmCourseCategories blGetCourseCategory(long courseCategoryId) 
	{
	
		return courseCategoryDao.dGetcourseCategory(courseCategoryId);
	}

		
	@Override
	public long blGetCourseCategoryId(PcmCourseCategories courseCategory) 
	{
	
		return courseCategoryDao.dGetCourseCategoriesId(courseCategory);
	}

	@Override
	public void blDeleteCourseCategory(PcmCourseCategories courseCategory) 
	{
	
		courseCategoryDao.dDeleteCourseCategory(courseCategory);
	}

}
