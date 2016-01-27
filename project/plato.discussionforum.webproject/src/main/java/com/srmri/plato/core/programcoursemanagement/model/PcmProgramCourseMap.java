package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_program_course_map")
public class PcmProgramCourseMap implements Serializable
{

	private static final long serialVersionUID = 7112269714382420925L;
	
	@Column(name="program_course_map_id")
	private long programCourseMapId;
	
	@Column(name="program_semester_year_id")
	private long programSemesterYearId;
	
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="total_classes")
	private int totalClasses;

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
	 * @return the totalClasses
	 */
	public int getTotalClasses() {
		return totalClasses;
	}

	/**
	 * @param totalClasses the totalClasses to set
	 */
	public void setTotalClasses(int totalClasses) {
		this.totalClasses = totalClasses;
	}

	

}
