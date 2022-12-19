package com.internetlove.cats.Entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "university")
public class UniversityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String details;
	private String dateAdded;
	
	//Constructors
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "uniId")
	private Set<CourseEntity> courses;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "uniId")
	private Set<TeacherEntity> teachers;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "uniId")
	private Set<StudentEntity> students;
	
	//private Set<TeacherEntity> teachers;
	//private Set<StudentEntity> students;
	public UniversityEntity() {}
	
	public UniversityEntity(int id, String name, String details, String dateAdded, Set<CourseEntity> courses,
			Set<TeacherEntity> teachers, Set<StudentEntity> students) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.dateAdded = dateAdded;
		this.courses = courses;
		this.teachers = teachers;
		this.students = students;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Set<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseEntity> courses) {
		this.courses = courses;
	}

	public Set<TeacherEntity> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<TeacherEntity> teachers) {
		this.teachers = teachers;
	}

	public Set<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentEntity> students) {
		this.students = students;
	}
	
}