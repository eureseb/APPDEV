package com.internetlove.cats.Entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CourseEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id; //Auto-incremented id of the Course
	private String code;
	private String desc;
	//private Set<TeacherEntity> teachers; //To be implemented
	//private Set<StudentEntity> students; //To be implemented
	
	public CourseEntity() {}
	public CourseEntity(int cid, String ccode, String cdesc) {
		super();
		id = cid;
		code = ccode;
		desc = cdesc;
	}
	
	public String getCourseCode() {return code;}
	public String getCourseDesc() {return desc;}
	public void setCourseCode(String ccode) {code = ccode;}
	public void setCourseDesc(String cdesc) {desc = cdesc;}
}
