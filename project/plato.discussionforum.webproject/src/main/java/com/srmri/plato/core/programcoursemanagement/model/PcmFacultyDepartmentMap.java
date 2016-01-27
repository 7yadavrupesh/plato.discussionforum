package main.java.com.srmri.plato.core.programcoursemanagement.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_faculty_department_map")
public class PcmFacultyDepartmentMap implements Serializable
{

	private static final long serialVersionUID = 9005743026630830360L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="faculty_department_map_id")
	private long facultyDepartmentMapId;
	
	@Column(name="faculty_id")
	private long facultyId;
	
	@Column(name="department_id")
	private long departmentId;

	/**
	 * @return the facultyDepartmentMapId
	 */
	public long getFacultyDepartmentMapId() {
		return facultyDepartmentMapId;
	}

	/**
	 * @param facultyDepartmentMapId the facultyDepartmentMapId to set
	 */
	public void setFacultyDepartmentMapId(long facultyDepartmentMapId) {
		this.facultyDepartmentMapId = facultyDepartmentMapId;
	}

	/**
	 * @return the facultyId
	 */
	public long getFacultyId() {
		return facultyId;
	}

	/**
	 * @param facultyId the facultyId to set
	 */
	public void setFacultyId(long facultyId) {
		this.facultyId = facultyId;
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
