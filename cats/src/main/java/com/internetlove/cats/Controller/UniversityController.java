package com.internetlove.cats.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.internetlove.cats.Entity.UniversityEntity;
import com.internetlove.cats.Service.UniversityService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/university")
public class UniversityController {
	@Autowired
	UniversityService userv;
	
	@GetMapping("/getAllUniversities")
	public List<UniversityEntity> getAllUniversities(){
		return userv.getUniversities();
	}
	
	@PostMapping("postUniversity")
	public UniversityEntity postUniversity(@RequestBody UniversityEntity university) {
		return userv.insertUniversity(university);
	}
	
	@PutMapping("/putUniversity")
	public UniversityEntity updateUniversity(@RequestParam int id, @RequestBody UniversityEntity university) throws Exception {
		return userv.updateUniversity(id, university);
	}
	
	@DeleteMapping("/deleteUniversity/{id}")
	public String deleteUniversity(@PathVariable int id) {
		return userv.deleteUniversity(id);
	}
		
}
