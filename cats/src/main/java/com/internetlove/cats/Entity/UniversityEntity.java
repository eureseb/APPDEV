package com.internetlove.cats.Entity;

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
	
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "university_id")
	private Set<StudentEntity> students;
	
	@OneToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id")
	private Set<CourseEntity> courses;
	
	//private Set<TeacherEntity> teachers;
	//private Set<StudentEntity> students;
	
	//Constructors
	public UniversityEntity() {}

	public UniversityEntity(int id, String name, String details, String dateAdded, Set<StudentEntity> students,
			Set<CourseEntity> courses) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.dateAdded = dateAdded;
		this.students = students;
		this.courses = courses;
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

	public Set<StudentEntity> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentEntity> students) {
		this.students = students;
	}

	public Set<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseEntity> courses) {
		this.courses = courses;
	}
	
	
}
