package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_program_level")
public class PcmProgramLevel implements Serializable
{

	private static final long serialVersionUID = -6101647281515068781L;
	
	@Column(name="program_level_id")
	private long programLevelId;
	
	@Column(name="program_level_name")
	private String programLevelName;
	
	@Column(name="description")
	private String description;

	/**
	 * @return the programLevelId
	 */
	public long getProgramLevelId() {
		return programLevelId;
	}

	/**
	 * @param programLevelId the programLevelId to set
	 */
	public void setProgramLevelId(long programLevelId) {
		this.programLevelId = programLevelId;
	}

	/**
	 * @return the programLevelName
	 */
	public String getProgramLevelName() {
		return programLevelName;
	}

	/**
	 * @param programLevelName the programLevelName to set
	 */
	public void setProgramLevelName(String programLevelName) {
		this.programLevelName = programLevelName;
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
	
	

}
