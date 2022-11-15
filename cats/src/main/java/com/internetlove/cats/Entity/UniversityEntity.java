package com.internetlove.cats.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Table(name = "tbl_course")
public class UniversityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String details;
	private String dateAdded;
	
	//Constructors
	//@OneToMany(cascade = CascadeType.MERGE)
	//@JoinColumn(name = "userid")
	//private Set<CourseEntity> courses;
	//private Set<TeacherEntity> teachers;
	//private Set<StudentEntity> students;
	public UniversityEntity() {}
	
	public UniversityEntity(int id, String name, String details, String dateAdded) {
		super();
		this.id = id;
		this.name = name;
		this.details = details;
		this.dateAdded = dateAdded;
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

}
