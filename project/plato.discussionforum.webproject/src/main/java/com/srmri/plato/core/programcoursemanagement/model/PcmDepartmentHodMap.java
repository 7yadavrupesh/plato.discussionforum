package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_department_hod_map")
public class PcmDepartmentHodMap implements Serializable
{

	private static final long serialVersionUID = -7396610852944161785L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="department_hod_map_id")
	private long departmentHodMapId;
	
	@Column(name="department_id")
	private long departmentId;
	
	@Column(name="hod_id")
	private long hodId;

	/**
	 * @return the departmentHodMapId
	 */
	public long getDepartmentHodMapId() {
		return departmentHodMapId;
	}

	/**
	 * @param departmentHodMapId the departmentHodMapId to set
	 */
	public void setDepartmentHodMapId(long departmentHodMapId) {
		this.departmentHodMapId = departmentHodMapId;
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
	 * @return the hodId
	 */
	public long getHodId() {
		return hodId;
	}

	/**
	 * @param hodId the hodId to set
	 */
	public void setHodId(long hodId) {
		this.hodId = hodId;
	}
	
	

}
