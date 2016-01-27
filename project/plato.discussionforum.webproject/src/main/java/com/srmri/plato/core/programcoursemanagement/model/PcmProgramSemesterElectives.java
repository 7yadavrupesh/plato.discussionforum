package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_program_semester_electives")
public class PcmProgramSemesterElectives implements Serializable
{

	private static final long serialVersionUID = 960846389839113490L;
	
	@Column(name="program_semester_elective_field")
	private long programSemesterElectiveId;
	
	@Column(name="elective_course_id")
	private long electiveCourseId;
	
	@Column(name="program_semester_year_id")
	private long programSemesterYearId;

	/**
	 * @return the programSemesterElectiveId
	 */
	public long getProgramSemesterElectiveId() {
		return programSemesterElectiveId;
	}

	/**
	 * @param programSemesterElectiveId the programSemesterElectiveId to set
	 */
	public void setProgramSemesterElectiveId(long programSemesterElectiveId) {
		this.programSemesterElectiveId = programSemesterElectiveId;
	}

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
	

}
