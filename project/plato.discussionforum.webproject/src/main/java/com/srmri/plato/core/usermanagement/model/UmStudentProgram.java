/**********************************************************************************
* File-name - UmStudentProgram.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: StudentProgram model
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.model;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usermanagement.um_student_program")

public class UmStudentProgram implements Serializable 
{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -3269203836460778569L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "student_program_id")
	private long studentProgramId;
	
	
	@Column(name = "student_no")
	private long studentNo;
	
	@Column(name="program_id")
	private long programId;
	
	@Column(name="office_id")
	private Integer officeId;
	
	@Column(name="enrollment_year")
	private Integer enrollmentYear;
	
	@Column(name="enrollment_status")
	private Integer enrollmentStatus;
	
	@Column(name="expected_completion_year")
	private Integer expectedCompletionYear;
	
	@Column(name="prerequisite_submission_url")
	private String prerequisiteSubmissionUrl;
	
	
	@Column(name="hanout_issued")
	private Integer handoutIssued;
	
	
	@Column(name="completed")
	private Integer completed;
	
	/**
	 * Default constructor
	 */
	public UmStudentProgram(){}
	
	
	/**
	 * Parameterized constructor
	 * @param studentNo - primary key of student table
	 * @param programId - primary key of program table - to 
	 * identify program
	 * @param officeId - primary key of office - to identify office
	 * @param enrollmentYear - enrollment year for the student
	 * @param enrollmentStatus - enrollment status of the 
	 * student - complete or not
	 * @param expectedCompletionYear - expected year when the student 
	 * will complete its program
	 * @param prerequisiteSubmissionUrl - path for storing the 
	 * prerequisite documents of the student
	 * @param handoutIssued - whether handout of the program is 
	 * issued or not
	 * @param completed - whether the information of the student and
	 * student program is complete or not.
	 */
	public UmStudentProgram(long studentNo, long programId, Integer officeId, 
							Integer enrollmentYear, Integer enrollmentStatus,
							Integer expectedCompletionYear, String prerequisiteSubmissionUrl,
							Integer handoutIssued, Integer completed)
	{
		this.studentNo = studentNo;
		this.officeId = officeId;
		this.programId = programId;
		this.handoutIssued = handoutIssued;
		this.completed = completed;
		this.enrollmentStatus = enrollmentStatus;
		this.enrollmentYear = enrollmentYear;
		this.prerequisiteSubmissionUrl = prerequisiteSubmissionUrl;
		this.expectedCompletionYear = expectedCompletionYear;
		
		
	}
		
	
	/**
	 * Getter method for student program id
	 * @return student program id  of this studentprogram object
	 */
	public long getStudentProgramId() {
		return studentProgramId;
	}

	/**
	 * Setter method for gender
	 */
	public void setStudentProgramId(long studentProgramId) {
		this.studentProgramId = studentProgramId;
	}
	/**
	 * Getter method for student no
	 * @return student no  of this studentprogram object
	 */
	public long getStudentNo() {
		return studentNo;
	}

	/**
	 * Setter method for student no for this user
	 */
	public void setStudentNo(long studentNo) {
		this.studentNo = studentNo;
	}

	/**
	 * Getter method for student program id
	 * @return student program id  of this studentprogram object
	 */
	public long getProgramId() {
		return programId;
	}

	/**
	 * Setter method for program id for this user
	 */
	public void setProgramId(long programId) {
		this.programId = programId;
	}

	/**
	 * Getter method for office id
	 * @return office id  of this studentprogram object
	 */
	public Integer getOfficeId() {
		return officeId;
	}

	/**
	 * Setter method for office id for this user
	 */
	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	/**
	 * Getter method for enrollment year
	 * @return enrollment year  of this studentprogram object
	 */
	public Integer getEnrollmentYear() {
		return enrollmentYear;
	}

	/**
	 * Setter method for enrollment year for this user
	 */
	public void setEnrollmentYear(Integer enrollmentYear) {
		this.enrollmentYear = enrollmentYear;
	}

	/**
	 * Getter method for enrollment status
	 * @return enrollment status  of this studentprogram object
	 */
	public Integer getEnrollmentStatus() {
		return enrollmentStatus;
	}

	/**
	 * Setter method for enrollment status for this user
	 */
	public void setEnrollmentStatus(Integer enrollmentStatus) {
		this.enrollmentStatus = enrollmentStatus;
	}

	/**
	 * Getter method for expected completion year
	 * @return expected completion year  of this studentprogram object
	 */
	public Integer getExpectedCompletionYear() {
		return expectedCompletionYear;
	}

	/**
	 * Setter method for expected completion year for this user
	 */
	public void setExpectedCompletionYear(Integer expectedCompletionYear) {
		this.expectedCompletionYear = expectedCompletionYear;
	}

	/**
	 * Getter method for prerequisite submission url
	 * @return prerequisite submission url  of this studentprogram object
	 */
	public String getPrerequisiteSubmissionUrl() {
		return prerequisiteSubmissionUrl;
	}

	/**
	 * Setter method for prerequisite submission url for this user
	 */
	public void setPrerequisiteSubmissionUrl(String prerequisiteSubmissionUrl) {
		this.prerequisiteSubmissionUrl = prerequisiteSubmissionUrl;
	}

	/**
	 * Getter method for handout issued value
	 * @return handout issued value of this user object
	 */
	public Integer getHandoutIssued() {
		return handoutIssued;
	}

	/**
	 * Setter method for handout issued value for this user
	 */
	public void setHandoutIssued(Integer handoutIssued) {
		this.handoutIssued = handoutIssued;
	}

	/**
	 * Getter method for completed value
	 * @return completed value of this user object
	 */
	public Integer getCompleted() {
		return completed;
	}

	/**
	 * Setter method for completed value for this user
	 */
	public void setCompleted(Integer completed) {
		this.completed = completed;
	}
	
	
	

}
