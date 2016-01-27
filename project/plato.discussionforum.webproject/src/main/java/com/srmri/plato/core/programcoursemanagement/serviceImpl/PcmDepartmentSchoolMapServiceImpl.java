package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmDepartmentSchoolMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmDepartmentSchoolMap;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmDepartmentSchoolMapService;

public class PcmDepartmentSchoolMapServiceImpl implements PcmDepartmentSchoolMapService
{
	@Autowired
	private PcmDepartmentSchoolMapDao departmentSchoolMapDao;
	
	@Override
	public void blAddDepartmentSchoolMap(PcmDepartmentSchoolMap departmentSchoolMap) 
	{
		departmentSchoolMapDao.dAddDepartmentSchoolMap(departmentSchoolMap);
		
	}

	@Override
	public List<PcmDepartmentSchoolMap> blListsAllDepartmentSchoolMaps() 
	{
		
		return departmentSchoolMapDao.dGetListOfAllDepartmentSchoolMaps();
	}

	@Override
	public PcmDepartmentSchoolMap blGetDepartmentSchoolMap(long departmentSchoolMapId) 
	{
		
		return departmentSchoolMapDao.dGetDepartmentSchoolMap(departmentSchoolMapId);
	}

	@Override
	public long blGetDepartmentSchoolMapId(PcmDepartmentSchoolMap departmentSchoolMap) 
	{
		
		return departmentSchoolMapDao.dGetDepartmentSchoolMapId(departmentSchoolMap);
	}

	@Override
	public void blDeleteDepartmentSchoolMap(PcmDepartmentSchoolMap departmentSchoolMap) 
	{
		departmentSchoolMapDao.dDeleteDepartmentSchoolMap(departmentSchoolMap);	
		
	}

}
