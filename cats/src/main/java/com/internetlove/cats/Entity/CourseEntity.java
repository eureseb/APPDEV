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
	private String coursecode;
	private String coursedesc;
	//private Set<TeacherEntity> teachers; //To be implemented
	//private Set<StudentEntity> students; //To be implemented
	
	public CourseEntity() {}
	public CourseEntity(int cid, String ccode, String cdesc) {
		super();
		id = cid;
		coursecode = ccode;
		coursedesc = cdesc;
	}
	
	public String getCourseCode() {return coursecode;}
	public String getCourseDesc() {return coursedesc;}
	public void setCourseCode(String ccode) {coursecode = ccode;}
	public void setCourseDesc(String cdesc) {coursedesc = cdesc;}
}
