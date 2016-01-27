package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_courses")
public class PcmCourses implements Serializable
{
	private static final long serialVersionUID = 7215987896723340451L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="course_code")
	private String courseCode;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="course_category_id")
	private int courseCategoryId;

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
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
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
	 * @return the courseCategoryId
	 */
	public int getCourseCategoryId() {
		return courseCategoryId;
	}

	/**
	 * @param courseCategoryId the courseCategoryId to set
	 */
	public void setCourseCategoryId(int courseCategoryId) {
		this.courseCategoryId = courseCategoryId;
	}
	
	
}
