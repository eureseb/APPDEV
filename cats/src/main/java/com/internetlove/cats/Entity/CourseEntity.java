package com.internetlove.cats.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_course")
public class CourseEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id; //Auto-incremented id of the Course
	@Column(name = "course_code")
	private String code;
	@Column(name = "course_description")
	private String description;
	//private Set<TeacherEntity> teachers; //To be implemented
	//private Set<StudentEntity> students; //To be implemented
	
	public CourseEntity() {}
	public CourseEntity(int cid, String ccode, String cdesc) {
		super();
		id = cid;
		code = ccode;
		description = cdesc;
	}
	
	public String getCourseCode() {return code;}
	public String getCourseDesc() {return description;}
	public void setCourseCode(String ccode) {code = ccode;}
	public void setCourseDesc(String cdesc) {description = cdesc;}
}
