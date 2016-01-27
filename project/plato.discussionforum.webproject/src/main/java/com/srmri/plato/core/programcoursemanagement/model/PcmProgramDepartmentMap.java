package main.java.com.srmri.plato.core.programcoursemanagement.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_program_department_map")
public class PcmProgramDepartmentMap implements Serializable
{

	
	private static final long serialVersionUID = 4068174381848283939L;
	
	@Column(name="program_department_map_id")
	private long programDepartmentMapId;
	
	@Column(name="program_id")
	private long programId;
	
	@Column(name="department_id")
	private long departmentId;

	/**
	 * @return the programDepartmentMap
	 */
	public long getProgramDepartmentMapId() {
		return programDepartmentMapId;
	}

	/**
	 * @param programDepartmentMap the programDepartmentMap to set
	 */
	public void setProgramDepartmentMapId(long programDepartmentMapId) {
		this.programDepartmentMapId = programDepartmentMapId;
	}

	/**
	 * @return the programId
	 */
	public long getProgramId() {
		return programId;
	}

	/**
	 * @param programId the programId to set
	 */
	public void setProgramId(long programId) {
		this.programId = programId;
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
	
	

}
