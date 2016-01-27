/**********************************************************************************
* File-name - UmDesignation.java
* Version - 1.0
* Author - SRM RI
***********************************************************************************
* Copyright (c) 2015 SRM Research Institute, Bangalore. All rights reserved.
* No part of this product may be reproduced in any form by any means without prior
* written authorization of SRM Research Institute and its licensors, if any.
***********************************************************************************
* Description: Designation model
**********************************************************************************/

package main.java.com.srmri.plato.core.usermanagement.model;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="usermanagement.um_designation")

public class UmDesignation implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8431832479036024485L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="um_designation_designation_id_seq", sequenceName="um_designation_designation_id_seq", allocationSize=1)
	@Column(name = "designation_id")
	private long designationId;
	
	@Column(name="designation_name")
	private String designationName;
	
	public UmDesignation(){}
	public UmDesignation(String designationName)
	{
		
		this.designationName = designationName;
	}


	public long getDesignationId() {
		return designationId;
	}


	public void setDesignationId(long designationId) {
		this.designationId = designationId;
	}


	public String getDesignationName() {
		return designationName;
	}


	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	
	

}
