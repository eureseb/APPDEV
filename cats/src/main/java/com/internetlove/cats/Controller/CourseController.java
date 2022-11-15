package com.internetlove.cats.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internetlove.cats.Entity.CourseEntity;
import com.internetlove.cats.Service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	CourseService cserv;
	
	@PostMapping("/postCourse")
	public CourseEntity postCourse(@RequestBody CourseEntity course) {
		return cserv.postCourse(course);
	}
	
	@GetMapping("/getAllCourses")
	public List<CourseEntity> getAllCourses() {
		return cserv.getAlllCourses();
	}
	
	@GetMapping("/getCourseById")
	public CourseEntity getCourseById(int id) {
		return cserv.getCourseById(id);
	}
}