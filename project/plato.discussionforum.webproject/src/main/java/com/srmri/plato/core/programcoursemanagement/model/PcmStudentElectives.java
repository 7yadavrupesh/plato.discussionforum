package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_student_electives")
public class PcmStudentElectives implements Serializable
{
	
	private static final long serialVersionUID = 4696498843683239238L;

	@Column(name="student_elective_id")
	private long studentElectiveId;
	
	@Column(name="student_id")
	private long studentId;
	
	@Column(name="class")
	private int _class;
	
	@Column(name="program_semester_elective_id")
	private long programSemesterElectiveId;

	/**
	 * @return the studentElectiveId
	 */
	public long getStudentElectiveId() {
		return studentElectiveId;
	}

	/**
	 * @param studentElectiveId the studentElectiveId to set
	 */
	public void setStudentElectiveId(long studentElectiveId) {
		this.studentElectiveId = studentElectiveId;
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
	
	
	

}
