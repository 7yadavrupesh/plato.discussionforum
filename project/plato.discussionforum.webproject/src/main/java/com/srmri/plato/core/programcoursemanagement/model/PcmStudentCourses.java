package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_student_courses")
public class PcmStudentCourses implements Serializable
{

	private static final long serialVersionUID = -6715035408292637758L;
	
	@Column(name="student_course_id")
	private long studentCourseId;
	
	@Column(name="student_id")
	private long studentId;
	
	@Column(name="program_semester_year_id")
	private long programSemesterYearId;
	
	@Column(name="_class")
	private int _class;
	
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="course_dpeartment_map_id")
	private long courseDepartmentMapId;

	/**
	 * @return the studentCourseId
	 */
	public long getStudentCourseId() {
		return studentCourseId;
	}

	/**
	 * @param studentCourseId the studentCourseId to set
	 */
	public void setStudentCourseId(long studentCourseId) {
		this.studentCourseId = studentCourseId;
	}

	/**
	 * @return the studentId
	 */
	public long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the programSemesterYearId
	 */
	public long getProgramSemesterYearId() {
		return programSemesterYearId;
	}

	/**
	 * @param programSemesterYearId the programSemesterYearId to set
	 */
	public void setProgramSemesterYearId(long programSemesterYearId) {
		this.programSemesterYearId = programSemesterYearId;
	}

	/**
	 * @return the _class
	 */
	public int get_class() {
		return _class;
	}

	/**
	 * @param _class the _class to set
	 */
	public void set_class(int _class) {
		this._class = _class;
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
	


}
