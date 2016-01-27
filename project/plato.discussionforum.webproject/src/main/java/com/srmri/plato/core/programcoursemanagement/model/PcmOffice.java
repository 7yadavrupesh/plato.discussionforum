package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_office")
public class PcmOffice implements Serializable 
{	
	private static final long serialVersionUID = 8458258592825631112L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="office_id")
	private int officeId;
	
	@Column(name="office_name")
	private String officeName;

	/**
	 * @return the officeId
	 */
	public int getOfficeId() {
		return officeId;
	}

	/**
	 * @param officeId the officeId to set
	 */
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
	

}
