package com.internetlove.cats.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internetlove.cats.Entity.CourseEntity;
import com.internetlove.cats.Repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	CourseRepository crepo;
	
	//Create
	public CourseEntity postCourse(CourseEntity course) {
		return crepo.save(course);
	}
	
	//Read
	public List<CourseEntity> getAlllCourses() {
		return crepo.findAll();
	}
	public CourseEntity getCourseById(int id) {
		if(crepo.findById(id)!=null)
			return crepo.findById(id).get();
		else
			return null;
	}
	public CourseEntity getCourseByCode(String coursecode) {
		if(crepo.findByCode(coursecode)!=null)
			return crepo.findByCode(coursecode);
		else
			return null;
	}
	
	//Update
	//public CourseEntity putCourse() {}
	
	//Delete
	//public CourseEntity deleteCourse() {}
}
