package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_department_school_map")
public class PcmDepartmentSchoolMap implements Serializable
{

	private static final long serialVersionUID = -3455840425769558617L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_school_map_id")
	private long departmentSchoolMapId;
	
	@Column(name="department_id")
	private long departmentId;
	
	
	@Column(name="school_id")
	private long schoolId;


	/**
	 * @return the departmentSchoolMapId
	 */
	public long getDepartmentSchoolMapId() {
		return departmentSchoolMapId;
	}


	/**
	 * @param departmentSchoolMapId the departmentSchoolMapId to set
	 */
	public void setDepartmentSchoolMapId(long departmentSchoolMapId) {
		this.departmentSchoolMapId = departmentSchoolMapId;
	}


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
	 * @return the schoolId
	 */
	public long getSchoolId() {
		return schoolId;
	}


	/**
	 * @param schoolId the schoolId to set
	 */
	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}
	
	
}
