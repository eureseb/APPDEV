package com.internetlove.cats.Entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_teacher")
public class TeacherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstname;
	private String lastname;
	private String contactNumber;
	private String gender;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "courseId")
	private CourseEntity course;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "studentId")
	private Set<StudentEntity> student;
	
	
	public TeacherEntity() {
		
	}


	public TeacherEntity(int id, String firstname, String lastname, String contactNumber, String gender,
			CourseEntity course, Set<StudentEntity> student) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactNumber = contactNumber;
		this.gender = gender;
		this.course = course;
		this.student = student;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public CourseEntity getCourse() {
		return course;
	}


	public void setCourse(CourseEntity course) {
		this.course = course;
	}


	public Set<StudentEntity> getStudent() {
		return student;
	}


	public void setStudent(Set<StudentEntity> student) {
		this.student = student;
	}

	
}
