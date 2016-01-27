package main.java.com.srmri.plato.core.programcoursemanagement.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_elective_courses")
public class PcmElectiveCourses implements Serializable
{

	private static final long serialVersionUID = -1335038258585302098L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="elective_course_id")
	private long electiveCourseId;
	
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="elective_type")
	private String electiveType;
	
	@Column(name="department_id")
	private long departmentId;
	
	@Column(name="program_id")
	private long programId;

	/**
	 * @return the electiveCourseId
	 */
	public long getElectiveCourseId() {
		return electiveCourseId;
	}

	/**
	 * @param electiveCourseId the electiveCourseId to set
	 */
	public void setElectiveCourseId(long electiveCourseId) {
		this.electiveCourseId = electiveCourseId;
	}

	/**
	 * @return the courseId
	 */
	public long getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the electiveType
	 */
	public String getElectiveType() {
		return electiveType;
	}

	/**
	 * @param electiveType the electiveType to set
	 */
	public void setElectiveType(String electiveType) {
		this.electiveType = electiveType;
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
	
	
}
