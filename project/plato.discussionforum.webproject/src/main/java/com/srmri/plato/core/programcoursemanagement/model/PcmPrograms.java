package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_programs")
public class PcmPrograms implements Serializable
{

	private static final long serialVersionUID = 1255423478899334728L;
	
	@Column(name="program_id")
	private long programId;
	
	@Column(name="program_code")
	private String programCode;
	
	@Column(name="program_name")
	private String programName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="program_type_id")
	private int programTypeId;
	
	@Column(name="program_level_id")
	private int programLevelId;
	
	@Column(name="open_date")
	private Date openDate;
	
	@Column(name="close_date")
	private Date closeDate;
	
	@Column(name="total_semesters")
	private int totalSemesters;

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
	 * @return the programCode
	 */
	public String getProgramCode() {
		return programCode;
	}

	/**
	 * @param programCode the programCode to set
	 */
	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	/**
	 * @return the programName
	 */
	public String getProgramName() {
		return programName;
	}

	/**
	 * @param programName the programName to set
	 */
	public void setProgramName(String programName) {
		this.programName = programName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the programTypeId
	 */
	public int getProgramTypeId() {
		return programTypeId;
	}

	/**
	 * @param programTypeId the programTypeId to set
	 */
	public void setProgramTypeId(int programTypeId) {
		this.programTypeId = programTypeId;
	}

	/**
	 * @return the programLevelId
	 */
	public int getProgramLevelId() {
		return programLevelId;
	}

	/**
	 * @param programLevelId the programLevelId to set
	 */
	public void setProgramLevelId(int programLevelId) {
		this.programLevelId = programLevelId;
	}

	/**
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}

	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	/**
	 * @return the closeDate
	 */
	public Date getCloseDate() {
		return closeDate;
	}

	/**
	 * @param closeDate the closeDate to set
	 */
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	/**
	 * @return the totalSemesters
	 */
	public int getTotalSemesters() {
		return totalSemesters;
	}

	/**
	 * @param totalSemesters the totalSemesters to set
	 */
	public void setTotalSemesters(int totalSemesters) {
		this.totalSemesters = totalSemesters;
	}
	
	
	
	
	

}
