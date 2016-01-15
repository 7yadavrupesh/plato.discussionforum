package main.java.com.srmri.plato.core.login.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import main.java.com.srmri.plato.core.usermanagement.model.UmFaculty;

public class FacultyBean 
{
	@Size(min=2, max=255, message="Cannot be null")
	private String facultyType;
		
	
	@Size(min=1, max=255, message="Cannot be null")
	private String joiningDate;
		
	@NotNull
	@Size(min=2, max=255, message="Cannot be null")
	private String qualification;
		
	private String designation;
	
	private long designation_id;
	
	/**
	 * @return the facultyType
	 */
	public String getFacultyType() {
		return facultyType;
	}
	
	/**
	 * @param facultyType the facultyType to set
	 */
	public void setFacultyType(String facultyType) {
		this.facultyType = facultyType;
	}
	
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	/**
	 * @return the qualification
	 */
	public String getQualification() {
		return qualification;
	}
	/**
	 * @param qualification the qualification to set
	 */
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
		
	/**
	 * @return the designation_id
	 */
	public long getDesignationId() {
		return designation_id;
	}
	/**
	 * @param designation_id the designation_id to set
	 */
	public void setDesignationId(long designation_id) {
		this.designation_id = designation_id;
	}
	
	/**
	 * @return the joiningDate
	 */
	public String getJoiningDate() {
		return joiningDate;
	}
	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	
	/**
	 * Prepares a UmFaculty model 
	 * @param regBean - bean created from form data
	 * @return UmFaculty prepared object
	 * @throws ParseException - parse date in String format
	 */
	public UmFaculty prepareModel(RegisterBean regBean) throws ParseException {
		UmFaculty faculty = new UmFaculty();
		
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		java.sql.Date joiningDate1 = new java.sql.Date(formatter.parse(joiningDate).getTime());
		
		java.sql.Date dob = new java.sql.Date(formatter.parse(regBean.getDateOfBirth()).getTime());
		
		faculty.setDateOfBirth(dob);
    	faculty.setDesignationId(this.getDesignationId());
    	faculty.setEmailId(regBean.getEmail());
    	faculty.setFirstName(regBean.getFirstName());
    	faculty.setLastName(regBean.getLastName());
    	faculty.setGender(regBean.getGender());
    	faculty.setImagePath(regBean.getImageUploadPath());
    	faculty.setJoiningDate(joiningDate1);
    	faculty.setQualification(this.getQualification());
    	faculty.setFacultyType(this.getFacultyType());
    	
		return faculty;
    
	}

}
