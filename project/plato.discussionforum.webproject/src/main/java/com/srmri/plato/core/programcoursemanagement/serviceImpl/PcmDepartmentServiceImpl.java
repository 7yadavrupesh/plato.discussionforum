package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmDepartmentDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmDepartments;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmDepartmentService;

public class PcmDepartmentServiceImpl implements PcmDepartmentService
{
	@Autowired
	private PcmDepartmentDao departmentDao;
	
	@Override
	public void blAddDepartment(PcmDepartments department) 
	{
		departmentDao.dAddDepartment(department);
		
	}

	@Override
	public List<PcmDepartments> blListsAllDepartments() 
	{
		
		return departmentDao.dGetListOfAllDepartments();
	}

	@Override
	public PcmDepartments blGetDepartment(long departmentId) 
	{
		
		return departmentDao.dGetDepartment(departmentId);
	}

	@Override
	public long blGetDepartmentId(PcmDepartments departmentName) 
	{
		
		return departmentDao.dGetDepartmentId(departmentName);
	}

	@Override
	public void blDeleteDepartment(PcmDepartments department) 
	{
		departmentDao.dDeleteDepartment(department);
		
	}

	
}
