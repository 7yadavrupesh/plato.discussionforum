package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_course_department_map")
public class PcmCourseDepartmentMap implements Serializable
{
	private static final long serialVersionUID = 9038310524039177427L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_department_map_id")
	private long courseDepartmentMapId;
	
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="department_id")
	private long departmentId;

	/**
	 * @return the courseDepartmentMap
	 */
	public long getCourseDepartmentMapId() {
		return courseDepartmentMapId;
	}

	/**
	 * @param courseDepartmentMap the courseDepartmentMap to set
	 */
	public void setCourseDepartmentMapId(long courseDepartmentMapId) {
		this.courseDepartmentMapId = courseDepartmentMapId;
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
