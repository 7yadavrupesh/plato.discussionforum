package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_departments")
public class PcmDepartments implements Serializable
{

	private static final long serialVersionUID = -5377283048218617873L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_id")
	private long departmentId;
	
	@Column(name="department_name")
	private String departmentName;
	
	@Column(name="office_id")
	private int officeId;

	/**
	 * @return the departmentId
	 */
	public long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

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
	
	

}
