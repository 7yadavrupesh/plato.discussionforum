package main.java.com.srmri.plato.core.programcoursemanagement.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_faculty_course_map")
public class PcmFacultyCourseMap implements Serializable
{

	private static final long serialVersionUID = 151206846494909748L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="faculty_course_map_id")
	private long facultyCourseMapId;
	
	@Column(name="faculty_id")
	private long facultyId;
	
	@Column(name="course_department_map_id")
	private long courseDepartmentMapId;
	
	@Column(name="program_course_map_id")
	private long programCourseMapId;

	/**
	 * @return the facultyCourseMapId
	 */
	public long getFacultyCourseMapId() {
		return facultyCourseMapId;
	}

	/**
	 * @param facultyCourseMapId the facultyCourseMapId to set
	 */
	public void setFacultyCourseMapId(long facultyCourseMapId) {
		this.facultyCourseMapId = facultyCourseMapId;
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
	 * @return the courseDepartmentMapId
	 */
	public long getCourseDepartmentMapId() {
		return courseDepartmentMapId;
	}

	/**
	 * @param courseDepartmentMapId the courseDepartmentMapId to set
	 */
	public void setCourseDepartmentMapId(long courseDepartmentMapId) {
		this.courseDepartmentMapId = courseDepartmentMapId;
	}

	/**
	 * @return the programCourseMapId
	 */
	public long getProgramCourseMapId() {
		return programCourseMapId;
	}

	/**
	 * @param programCourseMapId the programCourseMapId to set
	 */
	public void setProgramCourseMapId(long programCourseMapId) {
		this.programCourseMapId = programCourseMapId;
	}
	
	
	
	

}
