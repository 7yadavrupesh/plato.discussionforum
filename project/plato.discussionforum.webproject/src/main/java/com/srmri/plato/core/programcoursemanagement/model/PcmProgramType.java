package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_program_type")
public class PcmProgramType implements Serializable
{

	private static final long serialVersionUID = 6372887733030768135L;
	
	@Column(name="program_type_id")
	private long programTypeId;
	
	@Column(name="program_type_name")
	private String programTypeName;
	
	@Column(name="description")
	private String description;

	/**
	 * @return the programTypeId
	 */
	public long getProgramTypeId() {
		return programTypeId;
	}

	/**
	 * @param programTypeId the programTypeId to set
	 */
	public void setProgramTypeId(long programTypeId) {
		this.programTypeId = programTypeId;
	}

	/**
	 * @return the programTypeName
	 */
	public String getProgramTypeName() {
		return programTypeName;
	}

	/**
	 * @param programTypeName the programTypeName to set
	 */
	public void setProgramTypeName(String programTypeName) {
		this.programTypeName = programTypeName;
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
