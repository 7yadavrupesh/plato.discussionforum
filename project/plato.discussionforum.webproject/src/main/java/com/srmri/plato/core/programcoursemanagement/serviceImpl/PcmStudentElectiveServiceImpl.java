package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmStudentElectivesDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmStudentElectives;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmStudentElectiveService;

public class PcmStudentElectiveServiceImpl implements PcmStudentElectiveService 
{
	@Autowired
	private PcmStudentElectivesDao studentElectiveDao;
	
	/**
	 * Adds the PcmStudentElectives object in the table
	 * @param PCmStudentElectives object
	 */
	@Override
	public void blAddStudentElective(PcmStudentElectives studentElective) 
	{
		studentElectiveDao.dAddStudentElectives(studentElective);
		
	}
	
	/**
	 * Returns the list of PcmStudentElectives objects in the table
	 * @return list PcmStudentElectives objects
	 */
	@Override
	public List<PcmStudentElectives> blListsAllStudentElectives() 
	{
		
		return studentElectiveDao.dGetListOfAllStudentElectives();
	}
	
	/**
	 * Returns the PcmStudentElectives object by studentElectiveId
	 * @param long studentElectiveid
	 * @return PcmStudentElectives object
	 */
	@Override
	public PcmStudentElectives blGetStudentElective(long studentElectiveId) 
	{
		
		return studentElectiveDao.dGetStudentElectives(studentElectiveId);
	}
	
	/**
	 * Returns the id of PcmStudentElectives object
	 * @param PcmStudentElectives object
	 * @return long studentElectiveid
	 */
	@Override
	public long blGetStudentElectiveId(PcmStudentElectives studentElective) 
	{
		
		return studentElectiveDao.dGetStudentElectivesId(studentElective);
	}
	
	/**
	 * Deletes the PcmStudentElectives row from the table 
	 * @param PcmStudentElectives object
	 */
	@Override
	public void blDeleteStudentElective(PcmStudentElectives studentElective) 
	{
		
		studentElectiveDao.dDeleteStudentElectives(studentElective);
	}

}
