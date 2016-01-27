package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_program_semester_year")
public class PcmProgramSemesterYear implements Serializable
{

	private static final long serialVersionUID = -6734721657050175434L;
	
	@Column(name="program_semester_year_id")
	private long programSemesterYearId;
	
	@Column(name="semester")
	private int semester;
	
	@Column(name="academic_year")
	private String academicYear;
	
	@Column(name="program_id")
	private long programId;
	
	@Column(name="year")
	private int year;
	
	@Column(name="no_of_open_electives")
	private int noOpenElectives;
	
	@Column(name="no_if_department_electives")
	private int noOfDepartmentElectives;

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
	 * @return the semester
	 */
	public int getSemester() {
		return semester;
	}

	/**
	 * @param semester the semester to set
	 */
	public void setSemester(int semester) {
		this.semester = semester;
	}

	/**
	 * @return the academicYear
	 */
	public String getAcademicYear() {
		return academicYear;
	}

	/**
	 * @param academicYear the academicYear to set
	 */
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
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
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the noOpenElectives
	 */
	public int getNoOpenElectives() {
		return noOpenElectives;
	}

	/**
	 * @param noOpenElectives the noOpenElectives to set
	 */
	public void setNoOpenElectives(int noOpenElectives) {
		this.noOpenElectives = noOpenElectives;
	}

	/**
	 * @return the noOfDepartmentElectives
	 */
	public int getNoOfDepartmentElectives() {
		return noOfDepartmentElectives;
	}

	/**
	 * @param noOfDepartmentElectives the noOfDepartmentElectives to set
	 */
	public void setNoOfDepartmentElectives(int noOfDepartmentElectives) {
		this.noOfDepartmentElectives = noOfDepartmentElectives;
	}
	
	
	
	


}
