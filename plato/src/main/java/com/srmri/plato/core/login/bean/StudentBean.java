package main.java.com.srmri.plato.core.login.bean;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import main.java.com.srmri.plato.core.usermanagement.model.UmStudent;


public class StudentBean 
{	
	@Size(min=2, max=500, message="Cannot be Null")
	private String studentId;
	
	@Size(min=0, max=500, message="size must be less than 500 characters")
	private String idCardPath;
	
	@NotNull
	@Size(min=2, max=255, message="Cannot be null")
	private String qualification;
	
	@NotNull(message="Cannot be Null")
	private Integer idCardIssued;
	
	@Size(min=0, max=500, message="size must be less than 500 characters")
	private String docsPath;
	
	@Size(min=0, max=255, message="size must be less than 255 characters")
	private String nationality;
	
	@Size(min=0, max=255, message="size must be less than 255 characters")
	private String presentAddress;
	
	@Size(min=0, max=255, message="size must be less than 255 characters")
	private String permanentAddress;
	
	@Pattern(regexp="[0-9]{12}", message="Not a valid phone number")
	private String phone1;
	
	@Pattern(regexp="[0-9]{12}", message="Not a valid phone number")
	private String phone2;
	
	/**
	 * @return the idCardPath
	 */
	public String getIdCardPath() {
		return idCardPath;
	}
	
	/**
	 * @param idCardPath the idCardPath to set
	 */
	public void setIdCardPath(String idCardPath) {
		this.idCardPath = idCardPath;
	}
	
	/**
	 * @return the idCardIssued
	 */
	public Integer getIdCardIssued() {
		return idCardIssued;
	}
	
	/**
	 * @param idCardIssued the idCardIssued to set
	 */
	public void setIdCardIssued(Integer idCardIssued) {
		this.idCardIssued = idCardIssued;
	}
	
	/**
	 * @return the docsPath
	 */
	public String getDocsPath() {
		return docsPath;
	}
	
	/**
	 * @param docsPath the docsPath to set
	 */
	public void setDocsPath(String docsPath) {
		this.docsPath = docsPath;
	}
	
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
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
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * @return the presentAddress
	 */
	public String getPresentAddress() {
		return presentAddress;
	}
	
	/**
	 * @param presentAddress the presentAddress to set
	 */
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	
	/**
	 * @return the permanentAddress
	 */
	public String getPermanentAddress() {
		return permanentAddress;
	}
	
	/**
	 * @param permanentAddress the permanentAddress to set
	 */
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	
	/**
	 * @return the phone1
	 */
	public String getPhone1() {
		return phone1;
	}
	
	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	
	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}
	
	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	
	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}
	
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	/**
	 * Prepares a UmStudent model from bean data
	 * @param regBean - bean created from form data
	 * @return UmStudent object
	 * @throws ParseException -for parsing date from String
	 * @throws IOException - for image file
	 */
	public UmStudent prepareModel(RegisterBean regBean) throws ParseException, IOException {
		UmStudent student = new UmStudent();
    	student.setEmailId(regBean.getEmail());
    	student.setFirstName(regBean.getFirstName());
    	student.setGender(regBean.getGender());
    	student.setIdCardIssued(this.getIdCardIssued());
    	student.setIdCardPath(this.getIdCardPath());
    	student.setLastName(regBean.getLastName());
    	student.setNationality(this.getNationality());
    	student.setOtherDocsPath(this.getDocsPath());
    	student.setPermanentAddress(this.getPermanentAddress());
    	student.setPhone1(this.getPhone1());
    	student.setPhone2(this.getPhone2());
    	student.setPicture(regBean.getImageUploadPath());
    	student.setPresentAddress(this.getPresentAddress());
    	student.setQualification(this.getQualification());
    	student.setStudentId(this.getStudentId());
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		
		
		java.sql.Date dob1 = new java.sql.Date(formatter.parse(regBean.getDateOfBirth()).getTime());
    	student.setDateOfBirth(dob1);
    	
    	
		
    	return student;
		
	}

}
