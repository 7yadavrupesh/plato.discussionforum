/**********************************************************************************
* File-name - UmStudent.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Student model
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usermanagement.um_student")
public class UmStudent implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3269203836460778569L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "student_no")
	private long studentNo;
	
	@Column(name="student_id")
	private String studentId;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String  gender;
	
	@Column(name="picture")
	private String  picture;
	
	@Column(name="qualification")
	private String qualification;
	
	
	@Column(name="present_address")
	private String presentAddress;
	
	@Column(name="permanent_address")
	private String permanentAddress;
	
	@Column(name="nationality")
	private String nationality;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="phone1")
	private String phone1;
	
	@Column(name="phone2")
	private String phone2;
	
	@Column(name="id_card_issued")
	private Integer idCardIssued;
	
	@Column(name="id_Card_path")
	private String idCardPath;
	
	@Column(name="other_docs_path")
	private String otherDocsPath;
	
	
	/**
	 * to add picture of the student
	 * @param String filePath - path of the image file
	 * @return byte array from the image
	 * @throws IOException 
	 */
	private byte[] getImageBytes(String filePath) throws IOException
	{
		System.out.println(filePath);
		File file = new File(filePath);
		try
		{
			byte[] bytes = new byte[(int) file.length()]; 
		
			FileInputStream fileInputStream = new FileInputStream(file);
			
			fileInputStream.read(bytes);
			fileInputStream.close();
			
			return bytes;
		}
		catch(Exception e)
		{
			return null;
		}
			
	}
	

	public UmStudent(){}
	public UmStudent(String studentId)
	{
		this.studentId = studentId;
	}
	
	
	public long getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(long studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getPicture() {
		return picture;
	}

	public void setPicture(String image_path) throws IOException {
		this.picture = image_path;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public Integer getIdCardIssued() {
		return idCardIssued;
	}

	public void setIdCardIssued(Integer idCardIssued) {
		this.idCardIssued = idCardIssued;
	}

	public String getIdCardPath() {
		return idCardPath;
	}

	public void setIdCardPath(String idCardPath) {
		this.idCardPath = idCardPath;
	}
	
	public String getOtherDocsPath() {
		return otherDocsPath;
	}

	public void setOtherDocsPath(String otherDocsPath) {
		this.otherDocsPath = otherDocsPath;
	}
	
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	

	
}
