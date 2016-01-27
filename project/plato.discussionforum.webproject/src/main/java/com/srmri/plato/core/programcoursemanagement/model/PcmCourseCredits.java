package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_course_credits")
public class PcmCourseCredits implements Serializable
{

	private static final long serialVersionUID = 4694562021644012086L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_credit_id")
	private long courseCreditId;
	
	@Column(name="course_id")
	private long courseId;
	
	@Column(name="course_type_id")
	private int courseTypeId;
	
	@Column(name="credits")
	private int credits;
	
	@Column(name="min_marks")
	private int minMarks;

	/**
	 * @return the courseCreditId
	 */
	public long getCourseCreditId() {
		return courseCreditId;
	}

	/**
	 * @param courseCreditId the courseCreditId to set
	 */
	public void setCourseCreditId(long courseCreditId) {
		this.courseCreditId = courseCreditId;
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
	 * @return the courseTypeId
	 */
	public int getCourseTypeId() {
		return courseTypeId;
	}

	/**
	 * @param courseTypeId the courseTypeId to set
	 */
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}

	/**
	 * @return the credits
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * @param credits the credits to set
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * @return the minMarks
	 */
	public int getMinMarks() {
		return minMarks;
	}

	/**
	 * @param minMarks the minMarks to set
	 */
	public void setMinMarks(int minMarks) {
		this.minMarks = minMarks;
	}

}
