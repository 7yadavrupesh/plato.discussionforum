package main.java.com.srmri.plato.core.programcoursemanagement.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import main.java.com.srmri.plato.core.programcoursemanagement.dao.PcmOfficeDao;
import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmOffice;
import main.java.com.srmri.plato.core.programcoursemanagement.service.PcmOfficeService;

public class PcmOfficeServiceImpl implements PcmOfficeService
{
	@Autowired
	private PcmOfficeDao officeDao;

	
	@Override
	public void blAddOffice(PcmOffice office) 
	{
		officeDao.dAddOffice(office);
		
	}

	@Override
	public List<PcmOffice> blListsAllOffices() 
	{
		
		return officeDao.dGetListOfAllOffice();
	}

	@Override
	public PcmOffice blGetOffice(long officeId) {
		
		return officeDao.dGetOffice(officeId);
	}

	
	
	@Override
	public long blGetOfficeId(PcmOffice office) 
	{
		
		return officeDao.dGetOfficeId(office);
	}

	@Override
	public void blDeleteOffice(PcmOffice office) 
	{
		officeDao.dDeleteOffice(office);
		
	}

}
