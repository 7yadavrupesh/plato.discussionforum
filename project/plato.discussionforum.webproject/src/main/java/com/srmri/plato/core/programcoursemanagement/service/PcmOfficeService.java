package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmOffice;

public interface PcmOfficeService 
{
	void blAddOffice(PcmOffice office);

	List<PcmOffice> blListsAllOffices();
	
	PcmOffice blGetOffice(long officeId);
	
	void blDeleteOffice(PcmOffice office);

	long blGetOfficeId(PcmOffice office);



}
