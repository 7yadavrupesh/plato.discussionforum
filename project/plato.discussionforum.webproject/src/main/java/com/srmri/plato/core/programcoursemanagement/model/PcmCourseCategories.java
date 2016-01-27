package main.java.com.srmri.plato.core.programcoursemanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="programcoursemanagement.pcm_course_categories")
public class PcmCourseCategories implements Serializable 
{

	private static final long serialVersionUID = -8467673311858800864L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_category_id")
	private long courseCategoryId;
	
	@Column(name="course_category_name")
	private String courseCategoryName;
	
	
	public long getCourseCategoryId() {
		return courseCategoryId;
	}

	public void setCourseCategoryId(long courseCategoryId) {
		this.courseCategoryId = courseCategoryId;
	}

	public String getCourseCategoryName() {
		return courseCategoryName;
	}

	public void setCourseCategoryName(String courseCategoryName) {
		this.courseCategoryName = courseCategoryName;
	}

	
	
    
}
