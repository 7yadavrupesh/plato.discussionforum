package main.java.com.srmri.plato.core.programcoursemanagement.service;

import java.util.List;

import main.java.com.srmri.plato.core.programcoursemanagement.model.PcmProgramType;

public interface PcmProgramTypeService 
{
	void blAddProgramType(PcmProgramType programType);

	List<PcmProgramType> blListsAllProgramType();
	
	PcmProgramType blGetProgramType(long programTypeId);
	
	void blDeleteProgramType(PcmProgramType programType);

	long blGetProgramTypeId(PcmProgramType programType);

}
