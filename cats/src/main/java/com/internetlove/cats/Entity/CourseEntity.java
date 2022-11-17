package com.internetlove.cats.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class CourseEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "course_code")
	private String code;
	
	@Column(name = "course_description")
	private String description;
	
	//private Set<TeacherEntity> teachers; //To be implemented
	
	@OneToMany(cascade = CascadeType.MERGE)
	private Set<StudentEntity> students;
	
	public CourseEntity() {}
	public CourseEntity(int id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
	}
	
	public String getCourseCode() {return code;}
	public String getCourseDesc() {return description;}
	public Set<StudentEntity> getStudents() {return students;}
	public void setCourseCode(String code) {this.code = code;}
	public void setCourseDesc(String desc) {this.description = desc;}
}
