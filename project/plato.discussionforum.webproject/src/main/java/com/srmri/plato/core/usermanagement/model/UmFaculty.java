/**********************************************************************************
* File-name - UmFaculty.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Faculty model
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.model;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="usermanagement.um_faculty")
public class UmFaculty implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8353758678171402517L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "faculty_id")
	private long facultyId;
	
	
	@Column(name="user_id")
	private long userId;
	
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="qualification")
	private String qualification;
	
	
	@Column(name="designation_id")
	private long designationId;
	
	@Column(name="faculty_type")
	private String facultyType;
	
	@Column(name="joining_date")
	private Date joiningDate;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="picture")
	private String imagePath;
	
	@Column(name="gender")
	private String gender;
	
	

	/**
	 * to add picture of the student
	 * @param String filePath - path of the image file
	 * @return byte array from the image
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	private byte[] getImageBytes(String filePath) throws IOException
	{
		System.out.println(filePath);
		
		try
		{
			File file = new File(filePath);
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
	
	
	
	public UmFaculty(){}
	public UmFaculty(long designationId, Date joiningDate, Date dateOfBirth, 
					String firstName, String lastName, 
					String qualification,  String facultyType, 
					String emailId)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.designationId = designationId;
		this.qualification = qualification;
		this.joiningDate = joiningDate;
		this.facultyType = facultyType;
		this.emailId = emailId;
		
	}

	public long getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
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
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public long getDesignationId() {
		return designationId;
	}

	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}

	public String getFacultyType() {
		return facultyType;
	}

	public void setFacultyType(String facultyType) {
		this.facultyType = facultyType;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String image_path){
		this.imagePath = image_path;
	}



	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}



	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	/*public byte[] getImage() {
		return picture;
	}

	public void setImage(String image_path) throws IOException {
		this.picture = this.getImageBytes(image_path);
	}*/
	
}
