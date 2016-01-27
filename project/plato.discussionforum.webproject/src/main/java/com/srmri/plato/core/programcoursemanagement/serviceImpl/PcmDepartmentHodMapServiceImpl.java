package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmDepartmentHodMapDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmDepartmentHodMap;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmDepartmentHodMapService;

public class PcmDepartmentHodMapServiceImpl implements PcmDepartmentHodMapService
{
	
	@Autowired
	private PcmDepartmentHodMapDao departmentHodMapDao;
	
	@Override
	public void blAddDepartmentHodMap(PcmDepartmentHodMap departmentHodMap) 
	{
		
		departmentHodMapDao.dAddDepartmentHodMap(departmentHodMap);
	}

	@Override
	public List<PcmDepartmentHodMap> blListsAllDepartmentHodMaps() 
	{
		
		return departmentHodMapDao.dGetListOfAllDepartmentHodMap();
	}

	@Override
	public PcmDepartmentHodMap blGetDepartmentHodMap(long departmentHodMapId) 
	{
		
		return departmentHodMapDao.dGetDepartmentHodMap(departmentHodMapId);
	}

	@Override
	public long blGetDepartmentHodMapId(PcmDepartmentHodMap departmentHodMap) 
	{
		
		return departmentHodMapDao.dGetDepartmentHodMapId(departmentHodMap);
	}

	@Override
	public void blDeleteDepartmentHodMap(PcmDepartmentHodMap departmentHodMap) 
	{
		
		departmentHodMapDao.dDeleteDepartmentHodMap(departmentHodMap);
	}

}
