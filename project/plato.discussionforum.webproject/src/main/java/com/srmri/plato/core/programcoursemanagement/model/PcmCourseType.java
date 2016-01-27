package main.java.com.srmri.plato.core.programcoursemanagement.model;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="programcoursemanagement.pcm_course_type")
public class PcmCourseType implements Serializable
{
	private static final long serialVersionUID = 8167202284159775812L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_type_id")
	private long courseTypeId;
	
	@Column(name="course_type_name")
	private String courseTypeName;
	
	@Column(name="desription")
	private String description;

	/**
	 * @return the courseTypeId
	 */
	public long getCourseTypeId() {
		return courseTypeId;
	}

	/**
	 * @param courseTypeId the courseTypeId to set
	 */
	public void setCourseTypeId(long courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	/**
	 * @return the courseTypeName
	 */
	public String getCourseTypeName() {
		return courseTypeName;
	}

	/**
	 * @param courseTypeName the courseTypeName to set
	 */
	public void setCourseTypeName(String courseTypeName) {
		this.courseTypeName = courseTypeName;
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
