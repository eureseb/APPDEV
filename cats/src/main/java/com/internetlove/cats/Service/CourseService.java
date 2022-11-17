package com.internetlove.cats.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
	public CourseEntity getCourseByCode(String code) {
		if(crepo.findByCode(code)!=null)
			return crepo.findByCode(code);
		else
			return null;
	}
	
	//Update
	public CourseEntity putCourse(int courseid, CourseEntity newCourseDetails) throws Exception {
		CourseEntity course = new CourseEntity();
		
		try {
			course = crepo.findById(courseid).get();
			
			course.setCourseDesc(newCourseDetails.getCourseDesc());
			
			return crepo.save(course);
		}catch (NoSuchElementException nex) {
			throw new Exception("Course ID Number "+courseid+" does not exist!");
		}
	}
	
	//Delete
	//public CourseEntity deleteCourse() {}
}
